package kr.kro.moonlightmoist.shopapi.notification.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "email_verification")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, length = 6)
    private String code;

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    @Builder.Default
    private LocalDateTime expiresAt = LocalDateTime.now().plusMinutes(5);

    @Column(nullable = false)
    @Builder.Default
    private Boolean verified = false;

    // 인증 완료 처리
    public void verify() {
        this.verified = true;
    }

    // 만료 여부 확인
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiresAt);
    }

    // 코드 일치 여부 확인
    public boolean matchesCode(String inputCode) {
        return this.code.equals(inputCode);
    }
}
