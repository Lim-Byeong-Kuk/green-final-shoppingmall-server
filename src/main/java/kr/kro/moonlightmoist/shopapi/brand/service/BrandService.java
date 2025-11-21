package kr.kro.moonlightmoist.shopapi.brand.service;

import kr.kro.moonlightmoist.shopapi.brand.dto.BrandDTO;

import java.util.List;

public interface BrandService {

    void register(BrandDTO dto);
    List<BrandDTO> getBrandList();
}
