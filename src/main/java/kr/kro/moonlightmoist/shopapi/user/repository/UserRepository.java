package kr.kro.moonlightmoist.shopapi.user.repository;

import kr.kro.moonlightmoist.shopapi.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
