package kr.kro.moonlightmoist.shopapi.cart.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@ToString
public class CartProductListDTO {
    //CartProduct Id
    private Long id;
    private int quantity;
    private Long productOptionId;
    private String productName; // 상품 이름
    private String optionName; // 옵션 이름
    private int optionPrice; // 옵션 가격
    private String imageUrl; // 대표 이미지 Url

    //JPQL 생성자 프로젝션에서 사용될 "시그니처 고정" 생성자
    public CartProductListDTO(Long id, int quantity, Long productOptionId, String productName, String optionName, int optionPrice, String imageUrl) {
        this.id=id;
        this.quantity=quantity;
        this.productOptionId=productOptionId;
        this.productName=productName;
        this.optionName=optionName;
        this.optionPrice=optionPrice;
        this.imageUrl=imageUrl;
    }
}
