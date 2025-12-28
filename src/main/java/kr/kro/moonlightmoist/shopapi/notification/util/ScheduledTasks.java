package kr.kro.moonlightmoist.shopapi.notification.util;

import kr.kro.moonlightmoist.shopapi.notification.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ScheduledTasks {

    private final EmailService emailService;

    // 매일 새벽 3시에 만료된 인증 코드 정리
    @Scheduled(cron = "0 0 3 * * *")
    public void cleanupExpiredVerificationCodes() {
        log.info("만료된 인증 코드 정리 작업 시작");
        emailService.cleanupExpiredCodes();
    }
}
