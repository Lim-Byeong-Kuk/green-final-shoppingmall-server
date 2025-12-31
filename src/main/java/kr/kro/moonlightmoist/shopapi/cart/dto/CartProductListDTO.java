package kr.kro.moonlightmoist.shopapi.cart.dto;

import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain.DeliveryPolicy;
import lombok.*;

//응답 DTO
// 조회할 때 필요
@Getter
@Builder
@NoArgsConstructor
@ToString
public class CartProductListDTO {
    //CartProduct Id
    private Long id;
    private Long productOptionId;
    private String brandName; // 상품 브랜드 이름
    private String productName; // 상품 이름
    private String optionName; // 옵션 이름
    private int sellingPrice; // 옵션 가격
    private int quantity; // 상품 수량
    private String imageUrl; // 상품 대표 이미지 Url
    private DeliveryPolicy deliveryPolicy; // 배송비 정책
    private int currentStock; //현재 재고

    //JPQL 생성자 프로젝션에서 사용될 "시그니처 고정" 생성자     
    public CartProductListDTO(Long id, Long productOptionId, String brandName, String productName, String optionName, int sellingPrice, int quantity, String imageUrl, DeliveryPolicy deliveryPolicy, int currentStock) {
        this.id=id;
        this.productOptionId=productOptionId;
        this.brandName=brandName;
        this.productName=productName;
        this.optionName=optionName;
        this.sellingPrice=sellingPrice;
        this.quantity=quantity;
        this.imageUrl=imageUrl;
        this.deliveryPolicy=deliveryPolicy;
        this.currentStock=currentStock;
    }
}
