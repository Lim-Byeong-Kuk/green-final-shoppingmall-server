package kr.kro.moonlightmoist.shopapi.brand.service;

import kr.kro.moonlightmoist.shopapi.brand.domain.Brand;
import kr.kro.moonlightmoist.shopapi.brand.dto.BrandDTO;
import kr.kro.moonlightmoist.shopapi.brand.repository.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BrandServiceImpl implements BrandService{

    private final BrandRepository brandRepository;

    @Override
    public void register(BrandDTO dto) {
        Brand brand = dto.toEntity();
        brandRepository.save(brand);
    }

    @Override
    public List<BrandDTO> getBrandList() {
        List<Brand> brands = brandRepository.findByDeletedFalse();
        List<BrandDTO> dtos = brands.stream().map(brand -> brand.toDTO()).toList();
        return dtos;
    }
}
