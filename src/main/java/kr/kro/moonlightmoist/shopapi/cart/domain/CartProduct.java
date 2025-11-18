package kr.kro.moonlightmoist.shopapi.cart.domain;

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
@Table(name = "cart_products")
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cart_id",nullable = false)
    private Cart cart;
    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private String optionName;
    @Column(nullable = false)
    private int ProductOptionPrice;
    @Column(nullable = false)
    private LocalDateTime addedAt;

}
