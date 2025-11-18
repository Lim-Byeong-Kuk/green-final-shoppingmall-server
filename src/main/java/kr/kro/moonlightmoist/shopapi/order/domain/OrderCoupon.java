package kr.kro.moonlightmoist.shopapi.order.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_coupons")
public class OrderCoupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
//    @OneToOne
//    @JoinColumn(name = "user_coupon_id",nullable = false)
//    private UserCoupon userCoupon;
    @Column(nullable = false)
    private String couponCode;
    @Column(nullable = false)
    private int discountAmount;
    @Column(nullable = false)
    private LocalDateTime appliedAt;

}
