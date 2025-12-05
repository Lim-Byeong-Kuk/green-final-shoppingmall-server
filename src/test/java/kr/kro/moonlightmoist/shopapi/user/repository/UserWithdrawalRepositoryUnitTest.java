package kr.kro.moonlightmoist.shopapi.user.repository;

import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.domain.UserWithdrawal;
import kr.kro.moonlightmoist.shopapi.user.domain.UserWithdrawalReason;
import kr.kro.moonlightmoist.shopapi.util.EntityFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import javax.swing.text.html.parser.Entity;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class UserWithdrawalRepositoryUnitTest {

    @Autowired
    private UserWithdrawalRepository userWithdrawalRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원탈퇴 생성테스트")
    public void createUserWithdrawal() {
        User user = EntityFactory.createUser(); // 유저 생성
        User savedUser = userRepository.save(user); // 유저 DB 저장

        user.withdrawal();

        UserWithdrawal userWithdrawal = UserWithdrawal.builder() // 회원 탈퇴 생성
                .user(savedUser) // 유저 생성
                .userWithdrawalReason(UserWithdrawalReason.ETC) // 회원탈퇴 사유 ENUM Type -> 기타
                .build();

        UserWithdrawal savedUserWithdrawal = userWithdrawalRepository.save(userWithdrawal);

        assertThat(savedUserWithdrawal.getUser().getLoginId()).isEqualTo("user");
        assertThat(savedUserWithdrawal.getUserWithdrawalReason()).isEqualTo(UserWithdrawalReason.ETC);
    }


}