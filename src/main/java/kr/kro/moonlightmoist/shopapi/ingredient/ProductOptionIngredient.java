package kr.kro.moonlightmoist.shopapi.ingredient;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.product.domain.ProductOption;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_option_ingredients")
public class ProductOptionIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "option_id",nullable = false)
    private ProductOption productOption;

    @ManyToOne
    @JoinColumn(name = "ingredient_id",nullable = false)
    private Ingredient ingredient;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
