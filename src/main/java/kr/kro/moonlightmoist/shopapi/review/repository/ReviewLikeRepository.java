package kr.kro.moonlightmoist.shopapi.review.repository;

import kr.kro.moonlightmoist.shopapi.review.domain.Review;
import kr.kro.moonlightmoist.shopapi.review.domain.ReviewLike;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewLikeRepository extends JpaRepository<ReviewLike, Long> {

    Optional<ReviewLike> findByReviewAndUser(Review review, User user);

    int countByReviewAndDeletedFalse(Review review);
}
