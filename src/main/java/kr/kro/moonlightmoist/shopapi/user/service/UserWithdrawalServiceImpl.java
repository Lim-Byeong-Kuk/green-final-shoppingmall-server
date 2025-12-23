package kr.kro.moonlightmoist.shopapi.user.service;

import jakarta.transaction.Transactional;
import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.domain.UserWithdrawal;
import kr.kro.moonlightmoist.shopapi.user.dto.UserWithdrawalRequest;
import kr.kro.moonlightmoist.shopapi.user.dto.UserWithdrawalResponse;
import kr.kro.moonlightmoist.shopapi.user.exception.AlreadyWithdrawUserException;
import kr.kro.moonlightmoist.shopapi.user.exception.InvalidPasswordException;
import kr.kro.moonlightmoist.shopapi.user.exception.UserNotFoundException;
import kr.kro.moonlightmoist.shopapi.user.exception.UserWithdrawalException;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import kr.kro.moonlightmoist.shopapi.user.repository.UserWithdrawalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserWithdrawalServiceImpl implements UserWithdrawalService {

    private final UserRepository userRepository;
    private final UserWithdrawalRepository userWithdrawalRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserWithdrawalResponse withdrawUser(UserWithdrawalRequest request) {
        try {
            log.info("여기는 회원탈퇴 요청 : {}", request);
            User user = userRepository.findByLoginId(request.getLoginId())
                    .orElseThrow(() -> new UserNotFoundException());

            if (user.isDeleted()) {
                throw new AlreadyWithdrawUserException();
            }

            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                throw new InvalidPasswordException();
            }

            user.withdraw();

            UserWithdrawal withdrawalUser = UserWithdrawal.builder()
                    .user(user)
                    .userWithdrawalReason(request.getUserWithdrawalReason())
                    .build();

            userWithdrawalRepository.save(withdrawalUser);


            return UserWithdrawalResponse.builder()
                    .success(true)
                    .message("회원 탈퇴가 정상 처리 되었습니다.")
                    .build();
        } catch (BusinessException e) {
            throw e;
        } catch (Exception e) {
            throw new UserWithdrawalException();
        }
    }
}
