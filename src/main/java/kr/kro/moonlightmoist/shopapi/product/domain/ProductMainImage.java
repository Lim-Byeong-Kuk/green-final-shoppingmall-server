package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
@Table(name = "product_main_images")
public class ProductMainImage extends BaseTimeEntity {

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

    @Column(nullable = false)
    private ImageType imageType;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

}

