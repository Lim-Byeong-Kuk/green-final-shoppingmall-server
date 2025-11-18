package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.brand.domain.Brand;
import kr.kro.moonlightmoist.shopapi.category.domain.Category;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Builder
@Setter
@Table(name = "products")
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(unique = true, nullable = false)
    private String productName;

    @Column(unique = true, nullable = false)
    private String productCode;

    private String searchKeywords;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExposureStatus exposureStatus;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SaleStatus saleStatus;

    private String description;

    @Column(name = "is_cancelable", nullable = false)
    private boolean cancelable;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted;

}

