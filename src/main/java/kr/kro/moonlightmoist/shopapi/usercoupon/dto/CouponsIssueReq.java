package kr.kro.moonlightmoist.shopapi.usercoupon.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CouponsIssueReq {
    List<Long> userIds;
    List<Long> couponIds;
}
