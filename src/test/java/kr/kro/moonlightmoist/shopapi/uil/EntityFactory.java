package kr.kro.moonlightmoist.shopapi.uil;

import kr.kro.moonlightmoist.shopapi.brand.domain.Brand;
import kr.kro.moonlightmoist.shopapi.category.domain.Category;
import kr.kro.moonlightmoist.shopapi.product.domain.ExposureStatus;
import kr.kro.moonlightmoist.shopapi.product.domain.Product;
import kr.kro.moonlightmoist.shopapi.product.domain.SaleStatus;

public class EntityFactory {

    public static Category createCategory(String name,int depth, int ord) {
        return Category.builder()
                .name(name)
                .depth(depth)
                .displayOrder(ord)
                .deleted(false)
                .build();
    }

    public static Brand createBrand(String name) {
        return Brand.builder()
                .name(name)
                .deleted(false)
                .build();
    }

    public static Product createProduct(Category category, Brand brand) {
        return Product.builder()
                .productName("임시상품이름")
                .brand(brand)
                .category(category)
                .productCode("임시상품코드")
                .searchKeywords("임시키워드")
                .exposureStatus(ExposureStatus.EXPOSURE)
                .saleStatus(SaleStatus.ON_SALE)
                .description("임시상품설명")
                .cancelable(true)
                .deleted(false)
                .build();
    }

}
