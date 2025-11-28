package kr.kro.moonlightmoist.shopapi.product.repository;

import kr.kro.moonlightmoist.shopapi.product.dto.ProductResForList;
import kr.kro.moonlightmoist.shopapi.product.dto.ProductSearchCondition;

import java.util.List;

public interface ProductCustomRepository {
    List<ProductResForList> search(ProductSearchCondition condition);
}
