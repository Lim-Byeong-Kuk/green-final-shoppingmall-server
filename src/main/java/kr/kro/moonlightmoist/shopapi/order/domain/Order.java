package kr.kro.moonlightmoist.shopapi.order.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // todo : User 클래스 만들어야함
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="delivery_policy_id")
    private DeliveryPolicy deliveryPolicy;

    private String orderNumber;
    private int totalAmount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;



}
