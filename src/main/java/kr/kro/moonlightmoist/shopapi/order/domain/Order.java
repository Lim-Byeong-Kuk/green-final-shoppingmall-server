package kr.kro.moonlightmoist.shopapi.order.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain.DeliveryPolicy;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Check(constraints = "payment_method IN ('CARD', 'BANK_TRANSFER', 'MOBILE', 'KAKAO_PAY', 'NAVER_PAY', 'PAYCO')")
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    // todo : User 클래스 만들어야함
//    @ManyToOne
//    @JoinColumn(name="user_id",nullable = false)
//    private User user;
    @Column(nullable = false)
    private String orderNumber;
    @Column(name = "payment_method",nullable = false)
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name="delivery_policy_id",nullable = true)
    private DeliveryPolicy deliveryPolicy;
    @Column(nullable = false)
    private int deliveryFee;
    @Column(nullable = false)
    private LocalDate expectedDeliveryDate;
    @Column(nullable = false)
    private int totalProductAmount;
    @Column(nullable = false)
    private int usedpoints;
    @Column(nullable = false)
    private int finalAmount;
    @Column(nullable = false)
    private String recipientName;
    @Column(nullable = false)
    private String recipientPhone;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = false)
    private String detailedAddress;
    @Column(nullable = true)
    private String deliveryRequest;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
