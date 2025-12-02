package kr.kro.moonlightmoist.shopapi.product.dto;

import kr.kro.moonlightmoist.shopapi.product.domain.ImageType;
import kr.kro.moonlightmoist.shopapi.product.domain.ProductMainImage;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductMainImageDto {
    private String imageUrl;
    private int displayOrder;
    private ImageType imageType;
    private String type;

    public ProductMainImage toDomain() {
        return ProductMainImage.builder()
                .imageUrl(this.imageUrl)
                .displayOrder(this.displayOrder)
                .imageType(this.imageType)
                .build();
    }
}
