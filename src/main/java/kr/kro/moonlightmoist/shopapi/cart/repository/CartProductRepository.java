package kr.kro.moonlightmoist.shopapi.cart.repository;

import kr.kro.moonlightmoist.shopapi.cart.domain.CartProduct;
import kr.kro.moonlightmoist.shopapi.cart.dto.CartProductListDTO;
import kr.kro.moonlightmoist.shopapi.product.domain.ProductOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CartProductRepository extends JpaRepository<CartProduct,Long> {
////    @Query(""" select new kr.kro.moonlightmoist.shopapi CartProductListDTO(
////            c.id, c.quantity,
////            )
////            from CartProduct c
////            join c.cart cc
////            join c.product cp
////            where
////            """)
//    public List<CartProductListDTO> removeCartProductByCartProductDTOId(@Param("id") Long id);
}
