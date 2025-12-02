package kr.kro.moonlightmoist.shopapi.product.dto;

import kr.kro.moonlightmoist.shopapi.product.domain.ProductDetailImage;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetailImageDto {
    private String imageUrl;
    private int displayOrder;
    private String type;

    public ProductDetailImage toDomain() {
        return ProductDetailImage.builder()
                .imageUrl(this.imageUrl)
                .displayOrder(this.displayOrder)
                .build();
    }
}
