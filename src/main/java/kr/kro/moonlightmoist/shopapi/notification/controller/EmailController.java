package kr.kro.moonlightmoist.shopapi.notification.controller;


import jakarta.validation.Valid;
import kr.kro.moonlightmoist.shopapi.notification.dto.EmailRequest;
import kr.kro.moonlightmoist.shopapi.notification.dto.VerifyRequest;
import kr.kro.moonlightmoist.shopapi.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
@Slf4j
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-verification")
    public ResponseEntity<?> sendVerification(@Valid @RequestBody EmailRequest request) {
        try {
            emailService.sendVerificationEmail(request.getEmail());

            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "인증 코드가 발송되었습니다. 이메일을 확인해주세요."
            ));

        } catch (Exception e) {
            log.error("인증 코드 발송 실패", e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "success", false,
                            "message", "이메일 발송에 실패했습니다. 잠시 후 다시 시도해주세요."
                    ));
        }
    }


    @PostMapping("/verify")
    public ResponseEntity<?> verifyCode(@Valid @RequestBody VerifyRequest request) {
        try {
            boolean isValid = emailService.verifyCode(
                    request.getEmail(),
                    request.getCode()
            );

            if (isValid) {
                return ResponseEntity.ok(Map.of(
                        "success", true,
                        "message", "이메일 인증이 완료되었습니다."
                ));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of(
                                "success", false,
                                "message", "인증 코드가 올바르지 않거나 만료되었습니다."
                        ));
            }

        } catch (Exception e) {
            log.error("인증 코드 검증 실패", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of(
                            "success", false,
                            "message", "인증 처리 중 오류가 발생했습니다."
                    ));
        }
    }
}
