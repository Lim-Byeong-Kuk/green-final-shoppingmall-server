package kr.kro.moonlightmoist.shopapi.coupon.repository;

import kr.kro.moonlightmoist.shopapi.coupon.domain.Coupon;
import kr.kro.moonlightmoist.shopapi.coupon.dto.CouponSearchCondition;

import java.util.List;

public interface CouponCustomRepository {
    List<Coupon> search(CouponSearchCondition condition);
}
