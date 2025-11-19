package kr.kro.moonlightmoist.shopapi.user.repository;

import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGradeRepository extends JpaRepository<UserGrade, Long> {
}
