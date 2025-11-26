package kr.kro.moonlightmoist.shopapi.review.repository;

import kr.kro.moonlightmoist.shopapi.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByUserId(Long userId);

    List<Review> findByProductId(Long productId);

    @Query("select avg(r.rating) from Review r where r.product.id = :productId")
    public double reviewAvgRating(@Param("productId") Long productId);

    @Query("select count(r.id) from Review r where r.product.id = :productId")
    public int reviewCount(@Param("productId") Long productId);

    @Query("select count(r) from Review r where r.product.id = :productId and r.rating = :rating")
    public int ratingByCount(@Param("productId") Long productId, @Param("rating") int rating);

    @Query("select count(r) from Review r where r.product.id = :productId and r.rating in (4,5)")
    public int positiveReview(@Param("productId") Long productId);
}
