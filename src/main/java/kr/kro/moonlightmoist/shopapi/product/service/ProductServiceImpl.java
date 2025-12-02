package kr.kro.moonlightmoist.shopapi.product.service;

import jakarta.persistence.EntityNotFoundException;
import kr.kro.moonlightmoist.shopapi.brand.domain.Brand;
import kr.kro.moonlightmoist.shopapi.brand.repository.BrandRepository;
import kr.kro.moonlightmoist.shopapi.category.domain.Category;
import kr.kro.moonlightmoist.shopapi.category.repository.CategoryRepository;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain.DeliveryPolicy;
import kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.repository.DeliveryPolicyRepository;
import kr.kro.moonlightmoist.shopapi.product.domain.*;
import kr.kro.moonlightmoist.shopapi.product.dto.*;
import kr.kro.moonlightmoist.shopapi.product.repository.DetailInfoRepository;
import kr.kro.moonlightmoist.shopapi.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    private final DeliveryPolicyRepository deliveryPolicyRepository;
    private final DetailInfoRepository detailInfoRepository;

    Product toEntity (ProductRequest dto) {

        Category category = categoryRepository.findById(dto.getCategory().getId()).get();
        Brand brand = brandRepository.findById(dto.getBrand().getId()).get();
        DeliveryPolicy deliveryPolicy = deliveryPolicyRepository.findById(dto.getDeliveryPolicy().getId()).get();

        return Product.builder()
                .category(category)
                .brand(brand)
                .basicInfo(dto.getBasicInfo().toDomain())
                .saleInfo(dto.getSaleInfo().toDomain())
                .deliveryPolicy(deliveryPolicy)
                .detailInfo(dto.getDetailInfo().toEntity())
                .build();
    }

    @Override
    @Transactional
    public Long register(ProductRequest dto) {

        Product product = toEntity(dto);
        for(ProductOptionDTO optionDTO : dto.getOptions()) {
            ProductOption option = optionDTO.toEntity();
            product.addProductOption(option);
        }
        Product savedProduct = productRepository.save(product);
        System.out.println("savedProduct = " + savedProduct);

        return savedProduct.getId();
    }

    @Override
    @Transactional
    public void addImageUrls(Long id, ProductImagesUrlDTO dto) {

        Product product = productRepository.findById(id).get();

        for(int i=0; i<dto.getOptionImageUrls().size(); i++) {
            product.getProductOptions().get(i).setImageUrl(dto.getOptionImageUrls().get(i));
            product.getProductOptions().get(i).setDisplayOrder(i);
        }
        System.out.println("product.getMainImages() = " + product.getMainImages());
        for(int i=0; i<dto.getMainImageUrls().size(); i++) {
            System.out.println("mainImage url 저장");
            product.getMainImages()
                    .add(ProductMainImage.builder()
                            .imageUrl(dto.getMainImageUrls().get(i))
                            .imageType(i==0 ? ImageType.THUMBNAIL : ImageType.GALLERY)
                            .displayOrder(i)
                            .build()
                    );
        }
        System.out.println("product.getMainImages() = " + product.getMainImages());
        for(int i=0; i<dto.getDetailImageUrls().size(); i++) {
            System.out.println("detailImage url 저장");
            product.getDetailImages()
                    .add(ProductDetailImage.builder()
                            .imageUrl(dto.getDetailImageUrls().get(i))
                            .displayOrder(i)
                            .build()
                    );
        }
        System.out.println("product.getDetailImages() = " + product.getDetailImages());
    }

    @Override
    public List<ProductResForList> searchProductsByCategory(List<Long> depth3CategoryIds) {

        Pageable pageable = PageRequest.of(
                0,
                24,
                Sort.by("id").descending()
        );

        Page<Product> page = productRepository.findByCategoryIdIn(depth3CategoryIds, pageable);
        List<ProductResForList> result = page.get().map(product -> product.toDTOForList()).toList();
        return result;
    }

    @Override
    public ProductResForDetail searchProductById(Long id) {
        Product product = productRepository.findById(id).get();
        ProductResForDetail dto = product.toDTOForDetail();
        return dto;
    }

    @Override
    public List<ProductResForList> searchProductsByCondition(ProductSearchCondition condition) {
        List<Product> productList = productRepository.search(condition);
        List<ProductResForList> productsRes = productList.stream().map(p -> p.toDTOForList()).toList();

        return productsRes;
    }

    @Override
    @Transactional
    public Long modify(Long id, ProductRequest dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다. id: " + id));

        Category category = categoryRepository.findById(dto.getCategory().getId()).get();
        Brand brand = brandRepository.findById(dto.getBrand().getId()).get();
        DeliveryPolicy deliveryPolicy = deliveryPolicyRepository.findById(dto.getDeliveryPolicy().getId()).get();
        DetailInfo detailInfo = detailInfoRepository.findById(dto.getDetailInfo().getId()).get();

        DetailInfo modifiedDetailInfo = detailInfo.changeDetailInfo(dto.getDetailInfo());

        // 옵션 기존의 있는 것 찾기
        List<ProductOptionDTO> existingOptions = dto.getOptions().stream()
                .filter(option -> option.getId() != null).toList();
        List<Long> existingIds = existingOptions.stream()
                .map(option ->
                    option.getId()).toList();

        List<ProductOptionDTO> newOptions = dto.getOptions().stream()
                .filter(option -> option.getId() == null).toList();

        for (ProductOption option : product.getProductOptions()) {
            if(existingIds.contains(option.getId())) {

                ProductOptionDTO foundOptionDto = existingOptions.stream()
                        .filter(optionDto -> optionDto.getId().equals(option.getId()))
                        .toList().get(0);

                if(foundOptionDto.getType().equals("deleted")) {
                    option.setDeleted(foundOptionDto.isDeleted());
                } else {
                    option.setOptionName(foundOptionDto.getOptionName());
                    option.setPurchasePrice(foundOptionDto.getPurchasePrice());
                    option.setSellingPrice(foundOptionDto.getSellingPrice());
                    option.setCurrentStock(foundOptionDto.getCurrentStock());
                    option.setInitialStock(foundOptionDto.getInitialStock());
                    option.setSafetyStock(foundOptionDto.getSafetyStock());
                    option.setImageUrl(foundOptionDto.getImageUrl());
                    option.setDisplayOrder(foundOptionDto.getDisplayOrder());
                    option.setDeleted(foundOptionDto.isDeleted());
                }
            }
        }

        for (ProductOptionDTO newOptionDto : newOptions) {
            ProductOption entity = newOptionDto.toEntity();
            product.addProductOption(entity);
        }

        product.setCategory(category);
        product.setBrand(brand);
        product.setBasicInfo(dto.getBasicInfo().toDomain());
        product.setSaleInfo(dto.getSaleInfo().toDomain());
        product.setDeliveryPolicy(deliveryPolicy);
        product.setDetailInfo(modifiedDetailInfo);
        product.setMainImages(dto.getMainImages().stream().map(img -> img.toDomain()).toList());
        product.setDetailImages(dto.getDetailImages().stream().map(img -> img.toDomain()).toList());

        Product modifiedProduct = productRepository.findById(id).get();

        return 0L;
    }

}
