package kr.kro.moonlightmoist.shopapi.product.dto;

import kr.kro.moonlightmoist.shopapi.brand.dto.BrandDTO;
import kr.kro.moonlightmoist.shopapi.category.dto.CategoryRegisterReq;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.dto.DeliveryPolicyDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "detailInfo")
public class ProductRequest {
    private CategoryRegisterReq category;
    private BrandDTO brand;
    private BasicInfoDTO basicInfo;
    private SaleInfoDTO saleInfo;
    private DeliveryPolicyDTO deliveryPolicy;
    private DetailInfoDTO detailInfo;
    private List<ProductOptionDTO> options;
    private boolean deleted;
    private List<ProductMainImageDto> mainImages;
    private List<ProductDetailImageDto> detailImages;
}
