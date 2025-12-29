package kr.kro.moonlightmoist.shopapi.user.service;

import kr.kro.moonlightmoist.shopapi.notification.service.EmailService;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.exception.UserNotFoundException;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional // 모든 메서드에 트랜잭션 적용
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void sendFindIdCode(String email) {
        // 이메일로 가입된 사용자가 있는지 확인
        if (!userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("해당 이메일로 가입된 정보가 없습니다.");
        }
        emailService.sendVerificationEmail(email);
    }

    @Override
    @Transactional(readOnly = true) // 조회만 하므로 읽기 전용 트랜잭션설정
    public String verifyFindId(String email, String code) {
        // 인증 코드 검증
        if (!emailService.verifyCode(email, code)) {
            throw new IllegalArgumentException("인증번호가 틀렸습니다.");
        }
        // 이메일로 사용자를 찾아 로그인 ID 반환
        return userRepository.findByEmail(email)
                .map(User::getLoginId)
                .orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public void sendFindPwCode(String userId, String email) {
        log.info("받은 userId: [{}]", userId);
        log.info("받은 email: [{}]", email);
        log.info("userId 길이: {}", userId != null ? userId.length() : "null");
        log.info("email 길이: {}", email != null ? email.length() : "null");

        if (userId != null) {
            // userId에 공백이 포함되어 있는지 확인
            log.info("userId에 공백 포함: {}", userId.contains(" "));
            log.info("trim 전후 비교: [{}] vs [{}]", userId, userId.trim());
        }

        // DB에 로그인 ID와 이메일이 모두 일치하는 사용자가 있는지 확인
        boolean exists = userRepository.existsByLoginIdAndEmail(userId, email);
        log.info("DB 조회 결과: {}", exists);

        if (!exists) {
            // DB에 있는 모든 사용자 확인 (디버깅용)
            List<User> allUsers = userRepository.findAll();
            log.info("전체 사용자 수: {}", allUsers.size());
            allUsers.forEach(user -> {
                log.info("DB 사용자 - loginId: [{}], email: [{}]",
                        user.getLoginId(), user.getEmail());
            });

            throw new UserNotFoundException("입력하신 이메일이 일치하는 회원이 없습니다.");
        }

        emailService.sendVerificationEmail(email);
        log.info("인증 코드 발송 완료");
    }

    @Override
    @Transactional(readOnly = true)
    public boolean verifyFindPw(String email, String code) {
        return emailService.verifyCode(email, code);
    }

    @Override
    public void resetPassword(String userId, String newPassword) {
        User user = userRepository.findByLoginId(userId)
                .orElseThrow(() -> new UserNotFoundException());

        // 암호화하여 저장
        user.changePassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }
}