package kr.kro.moonlightmoist.shopapi.notification.repository;

import jakarta.transaction.Transactional;
import kr.kro.moonlightmoist.shopapi.notification.domain.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {
    Optional<EmailVerification> findTopByEmailAndVerifiedFalseOrderByCreatedAtDesc(String email);

    // 만료된 코드 삭제 (배치 작업용)
    @Modifying
    @Transactional
    @Query("DELETE FROM EmailVerification e WHERE e.expiresAt < :now")
    void deleteExpired(@Param("now") LocalDateTime now);
}
