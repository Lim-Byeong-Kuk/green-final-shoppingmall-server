package kr.kro.moonlightmoist.shopapi.user.repository;


import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import kr.kro.moonlightmoist.shopapi.user.domain.UserRole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@EnableJpaAuditing
class UserRepositoryUnitTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGradeRepository userGradeRepository;

    @Test
    @DisplayName("유저생성 테스트")
    public void createUser() {

        UserGrade userGrade = UserGrade.builder()
                .grade("BRONZE")
                .minTotalPoints(0)
                .freeDeliveryMinAmount(30000)
                .description("브론즈는 혜택이 없습니다.")
                .disCountRate(0)
                .build();
        UserGrade savedUserGrade = userGradeRepository.save(userGrade);


        User newUser = User.builder()
                .loginId("user")
                .passwordHash("123123")
                .name("유저")
                .email("user@naver.com")
                .phoneNumber("01012345678")
                .postalCode("11111")
                .address("성남")
                .addressDetail("분당")
                .birthDate(LocalDate.of(2025,11,11))
                .emailAgreement(true)
                .smsAgreement(false)
                .userGrade(savedUserGrade)
                .userRole(UserRole.USER)
                .build();

        User savedUser = userRepository.save(newUser);

        assertThat(savedUser.getLoginId()).isEqualTo("user");
        assertThat(savedUser.getPasswordHash()).isEqualTo("123123");
        assertThat(savedUser.getName()).isEqualTo("유저");
        assertThat(savedUser.getEmail()).isEqualTo("user@naver.com");
        assertThat(savedUser.getPhoneNumber()).isEqualTo("01012345678");
        assertThat(savedUser.getPostalCode()).isEqualTo("11111");
        assertThat(savedUser.getAddress()).isEqualTo("성남");
        assertThat(savedUser.getAddressDetail()).isEqualTo("분당");
        assertThat(savedUser.getBirthDate()).isEqualTo(LocalDate.of(2025,11,11));
        assertThat(savedUser.isEmailAgreement()).isEqualTo(true);
        assertThat(savedUser.isSmsAgreement()).isEqualTo(false);
        assertThat(savedUser.getUserGrade().getGrade()).isEqualTo("BRONZE");
        assertThat(savedUser.getUserRole()).isEqualTo(UserRole.USER);
    }

}
