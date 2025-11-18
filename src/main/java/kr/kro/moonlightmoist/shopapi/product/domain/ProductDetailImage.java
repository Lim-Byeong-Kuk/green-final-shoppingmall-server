package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Table(name = "product_detail_images")
public class ProductDetailImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int displayOrder;

}

