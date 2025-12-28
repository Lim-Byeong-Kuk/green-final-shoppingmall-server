package kr.kro.moonlightmoist.shopapi.user.controller;

import kr.kro.moonlightmoist.shopapi.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/find-id/send-code")
    public ResponseEntity<?> sendFindIdCode(@RequestBody Map<String, String> request) {
        authService.sendFindIdCode(request.get("email"));
        return ResponseEntity.ok(Map.of("success", true));
    }

    @PostMapping("/find-id/verify")
    public ResponseEntity<?> verifyFindId(@RequestBody Map<String, String> request) {
        String foundId = authService.verifyFindId(request.get("email"), request.get("code"));
        return ResponseEntity.ok(Map.of("success", true, "userId", foundId));
    }

    @PostMapping("/find-pw/send-code")
    public ResponseEntity<?> sendFindPwCode(@RequestBody Map<String, String> request) {
        authService.sendFindPwCode(request.get("userId"), request.get("email"));
        return ResponseEntity.ok(Map.of("success", true));
    }

    @PostMapping("/find-pw/verify")
    public ResponseEntity<?> verifyFindPw(@RequestBody Map<String, String> request) {
        boolean isVerified = authService.verifyFindPw(request.get("email"), request.get("code"));
        if (isVerified) {
            return ResponseEntity.ok(Map.of("success", true));
        }
        return ResponseEntity.badRequest().body(Map.of("message", "인증번호가 틀렸습니다."));
    }

    @PostMapping("/find-pw/reset")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        authService.resetPassword(request.get("userId"), request.get("newPassword"));
        return ResponseEntity.ok(Map.of("success", true, "message", "비밀번호가 변경되었습니다."));
    }
}