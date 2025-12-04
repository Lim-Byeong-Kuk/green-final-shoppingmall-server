package kr.kro.moonlightmoist.shopapi.coupon.controller;

import kr.kro.moonlightmoist.shopapi.coupon.dto.CouponDto;
import kr.kro.moonlightmoist.shopapi.coupon.dto.CouponSearchCondition;
import kr.kro.moonlightmoist.shopapi.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*",
        methods = {RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.OPTIONS})
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("")
    public ResponseEntity<String> registerCoupon(@RequestBody CouponDto dto) {

        System.out.println("dto = " + dto);
        Long id = couponService.register(dto);
        System.out.println("id = " + id);

        return ResponseEntity.ok("ok");
    }

    @PostMapping("/search")
    public ResponseEntity<List<CouponDto>> searchCoupons(@RequestBody CouponSearchCondition condition) {
        System.out.println("condition = " + condition);
        List<CouponDto> coupons = couponService.searchCouponsByCondition(condition);
        return ResponseEntity.ok(coupons);
    }
}
