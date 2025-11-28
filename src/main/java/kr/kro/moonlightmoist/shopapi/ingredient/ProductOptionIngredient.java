//package kr.kro.moonlightmoist.shopapi.ingredient;
//
//import jakarta.persistence.*;
//import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
//import kr.kro.moonlightmoist.shopapi.product.domain.ProductOption;
//import lombok.*;
//
//import java.time.LocalDateTime;
//
//@Getter
//@ToString
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "product_option_ingredients")
//public class ProductOptionIngredient extends BaseTimeEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "option_id",nullable = false)
//    private ProductOption productOption;
//
//    @ManyToOne
//    @JoinColumn(name = "ingredient_id",nullable = false)
//    private Ingredient ingredient;
//
//
//}
