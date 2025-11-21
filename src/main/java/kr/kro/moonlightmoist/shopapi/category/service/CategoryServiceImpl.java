package kr.kro.moonlightmoist.shopapi.category.service;

import kr.kro.moonlightmoist.shopapi.category.domain.Category;
import kr.kro.moonlightmoist.shopapi.category.dto.CategoryRegisterReq;
import kr.kro.moonlightmoist.shopapi.category.dto.CategoryRes;
import kr.kro.moonlightmoist.shopapi.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void register(CategoryRegisterReq dto) {
        Category category = dto.toEntity();
        categoryRepository.save(category);
    }

    @Override
    public List<CategoryRes> getCategoryList() {
        List<CategoryRes> categoryResList = categoryRepository.findByDepthAndDeletedFalse(0)
                .stream().map(category -> category.toDTO()).toList();
        return categoryResList;
    }

}
