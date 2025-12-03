package kr.kro.moonlightmoist.shopapi.review.service;

public interface ReviewLikeService {

    boolean toggleReviewLike(Long reviewId, Long userId);

    int countReviewLike(Long reviewId);
}
