package kr.kro.moonlightmoist.shopapi.user.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_withdrawal")
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserWithdrawal extends BaseTimeEntity { // 회원탈퇴 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserWithdrawalReason userWithdrawalReason;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    // 관리자 회원복구 로직 병국이형


}
