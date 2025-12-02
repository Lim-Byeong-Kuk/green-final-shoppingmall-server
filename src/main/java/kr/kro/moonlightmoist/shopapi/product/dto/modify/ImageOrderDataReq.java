package kr.kro.moonlightmoist.shopapi.product.dto.modify;

import kr.kro.moonlightmoist.shopapi.product.domain.ImageType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImageOrderDataReq {
    private String type;
    private String imageUrl;
    private int displayOrder;
    private ImageType imageType;

}
