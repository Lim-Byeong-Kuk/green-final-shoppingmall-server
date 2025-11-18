package kr.kro.moonlightmoist.shopapi.productInfo.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "product_info")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id",nullable = false)
    private Product product;
    @Column(nullable = false)
    private String capacity;
    @Column(nullable = false)
    private String manufactureDate;
    @Column(nullable = false)
    private String skinType;
    @Column(nullable = false)
    private String usagePeriod;
    @Column(nullable = false)
    private String usageMethod;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String origin;
    @Column(nullable = false)
    private String ingredients_text;
    @Column(nullable = false)
    private String functionalCertification;
    @Column(nullable = false)
    private String caution;
    @Column(nullable = false)
    private String qualityGuarantee;
    @Column(nullable = false)
    private String customerServiceNumber;
    @Column(nullable = false)
    private String shippingInfo;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;


}
