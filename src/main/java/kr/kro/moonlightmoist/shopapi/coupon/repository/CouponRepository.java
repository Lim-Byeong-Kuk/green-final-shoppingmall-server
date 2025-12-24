package kr.kro.moonlightmoist.shopapi.coupon.repository;

import kr.kro.moonlightmoist.shopapi.coupon.domain.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long>, CouponCustomRepository {
    Optional<Coupon> findByCouponCode(String couponCode);
    @Query("SELECT c FROM Coupon c WHERE c.issueType = 'MANUAL' AND (c.validTo IS NULL OR c.validTo > :now)")
    List<Coupon> findManualCoupons(@Param("now") LocalDateTime now);
}
