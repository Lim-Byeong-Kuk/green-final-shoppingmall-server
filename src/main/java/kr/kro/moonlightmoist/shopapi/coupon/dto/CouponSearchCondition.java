package kr.kro.moonlightmoist.shopapi.coupon.dto;

import kr.kro.moonlightmoist.shopapi.coupon.domain.CouponAvailability;
import kr.kro.moonlightmoist.shopapi.coupon.domain.DiscountType;
import kr.kro.moonlightmoist.shopapi.coupon.domain.IssueType;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponSearchCondition {
    private String name;
    private String couponCode;
    private List<IssueType> issueType;
    private List<CouponAvailability> availability;
    private List<DiscountType> discountType;
    private LocalDate createdAtFrom;
    private LocalDate createdAtTo;
}
