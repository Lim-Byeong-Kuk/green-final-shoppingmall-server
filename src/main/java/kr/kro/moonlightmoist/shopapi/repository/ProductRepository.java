package kr.kro.moonlightmoist.shopapi.repository;

import kr.kro.moonlightmoist.shopapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
