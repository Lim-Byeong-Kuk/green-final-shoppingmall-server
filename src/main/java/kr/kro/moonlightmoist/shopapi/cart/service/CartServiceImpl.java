package kr.kro.moonlightmoist.shopapi.cart.service;

import kr.kro.moonlightmoist.shopapi.cart.domain.CartProduct;
import kr.kro.moonlightmoist.shopapi.cart.dto.CartProductDTO;
import kr.kro.moonlightmoist.shopapi.cart.dto.CartProductListDTO;
import kr.kro.moonlightmoist.shopapi.cart.repository.CartProductRepository;
import kr.kro.moonlightmoist.shopapi.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CartServiceImpl implements CartService{

    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;

    @Override
    public List<CartProductListDTO> addOrModify(CartProductDTO dto) {


//        cartProductRepository.save()
        return null;
    }

    @Override
    public List<CartProductListDTO> remove(Long id) {
        cartProductRepository.deleteById(id);
        return null;
    }
}
