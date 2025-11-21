package kr.kro.moonlightmoist.shopapi.user.controller;


import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.dto.UserSignUpRequest;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import kr.kro.moonlightmoist.shopapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Slf4j
@CrossOrigin(origins = "*",
        allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE})
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> userResister(@RequestBody UserSignUpRequest userSignUpRequest) {
        // @RequestBody JSON 데이터를 Java 객체로 자동 변환해주는 어노테이션
        User registeredUser = userRepository.save(userService.registerUser(userSignUpRequest));
        log.info("유저정보 Controller => {}"  ,userSignUpRequest);
        log.info("DB에서 꺼낸 정보 => {}"  ,registeredUser);
        return ResponseEntity.ok("성공");
    }
}
