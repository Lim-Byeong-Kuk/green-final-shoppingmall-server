package kr.kro.moonlightmoist.shopapi.order.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.product.domain.Product;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_products")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private int purchasedPrice;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderProductStatus orderProductStatus;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
