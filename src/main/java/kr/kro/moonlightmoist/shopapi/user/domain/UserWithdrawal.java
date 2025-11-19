package kr.kro.moonlightmoist.shopapi.user.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;

import java.time.LocalDate;

public class UserWithdrawal extends BaseTimeEntity { // 회원탈퇴 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserWithdrawalReason userWithdrawalReason;

    @OneToMany
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

}
