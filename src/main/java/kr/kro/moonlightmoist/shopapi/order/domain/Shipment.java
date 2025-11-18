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
@Table(name = "shipments")
public class Shipment {//배송정보
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "order_id", unique = true, nullable = false)
    private Order order;
    @Column(nullable = false)
    private String deliveryCompany;
    @Column(nullable = false)
    private String trackingNumber;
    @Column(nullable = false)
    private LocalDateTime shippedAt;
    @Column(nullable = false)
    private LocalDateTime deliveredAt;
    @Column(nullable = false)
    private LocalDateTime createdAt;
}
