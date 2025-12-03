package kr.kro.moonlightmoist.shopapi.review.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
public class ReviewLikeDTO {
    private Long id;
    private Long reviewId;
    private Long userId;
    private String loginId;
}
