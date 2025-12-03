package kr.kro.moonlightmoist.shopapi.review.service;

import jakarta.transaction.Transactional;
import kr.kro.moonlightmoist.shopapi.review.domain.Review;
import kr.kro.moonlightmoist.shopapi.review.domain.ReviewLike;
import kr.kro.moonlightmoist.shopapi.review.repository.ReviewLikeRepository;
import kr.kro.moonlightmoist.shopapi.review.repository.ReviewRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class ReviewLikeServiceImpl implements ReviewLikeService{

    private final ReviewRepository reviewRepository;
    private final ReviewLikeRepository reviewLikeRepository;
    private final UserRepository userRepository;

    @Override
    public boolean toggleReviewLike(Long reviewId, Long userId) {
        Review review = reviewRepository.findById(reviewId).get();
        User user = userRepository.findById(userId).get();

        //좋아요(도움이 돼요)가 존재하는지 확인
        Optional<ReviewLike> reviewLike = reviewLikeRepository.findByReviewAndUser(review, user);

        if (reviewLike.isPresent()) {
            //존재하면 삭제 (좋아요 취소)
            reviewLikeRepository.delete(reviewLike.get());
            return false; //취소 상태
        } else {
            //없으면 추가
            ReviewLike like = ReviewLike.builder()
                    .review(review)
                    .user(user)
                    .build();
            reviewLikeRepository.save(like);
            return true; //좋아요(도움이 돼요) 상태
        }
    }

    @Override
    public int countReviewLike(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).get();
        return reviewLikeRepository.countByReviewAndDeletedFalse(review);
    }
}
