package kr.kro.moonlightmoist.shopapi.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import kr.kro.moonlightmoist.shopapi.product.dto.ProductDetailImageDto;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class ProductDetailImage {

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private int displayOrder;

    public void setDisplayOrder(int ord) {
        this.displayOrder = ord;
    }

    public ProductDetailImageDto toDTO() {
        return ProductDetailImageDto.builder()
                .imageUrl(this.imageUrl)
                .displayOrder(this.displayOrder)
                .build();
    }
}

