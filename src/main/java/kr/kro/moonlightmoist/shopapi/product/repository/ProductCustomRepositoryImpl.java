package kr.kro.moonlightmoist.shopapi.product.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import kr.kro.moonlightmoist.shopapi.brand.domain.QBrand;
import kr.kro.moonlightmoist.shopapi.category.domain.QCategory;
import kr.kro.moonlightmoist.shopapi.product.domain.Product;
import kr.kro.moonlightmoist.shopapi.product.domain.QBasicInfo;
import kr.kro.moonlightmoist.shopapi.product.domain.QProduct;
import kr.kro.moonlightmoist.shopapi.product.domain.QSaleInfo;
import kr.kro.moonlightmoist.shopapi.product.dto.ProductResForList;
import kr.kro.moonlightmoist.shopapi.product.dto.ProductSearchCondition;

import java.util.List;

public class ProductCustomRepositoryImpl implements ProductCustomRepository{

    private final JPAQueryFactory queryFactory;

    public ProductCustomRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ProductResForList> search(ProductSearchCondition condition) {

        QProduct product = QProduct.product;
        QCategory category = QCategory.category;
        QBrand brand = QBrand.brand;
        QBasicInfo basicInfo = QBasicInfo.basicInfo;
        QSaleInfo saleInfo = QSaleInfo.saleInfo;

        List<Product> result = queryFactory
                .selectFrom(product)
                .join(product.category, category)
                .where(
                        product.category.id.in(condition.getCategoryIds())
                )
                .fetch();

        System.out.println("result = " + result);
        System.out.println("result.size() = " + result.size());

        return List.of(new ProductResForList());
    }
}
