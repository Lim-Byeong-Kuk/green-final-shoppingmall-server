package kr.kro.moonlightmoist.shopapi.restockNoti.service;

import jakarta.persistence.EntityNotFoundException;
import kr.kro.moonlightmoist.shopapi.product.domain.ProductOption;
import kr.kro.moonlightmoist.shopapi.product.repository.ProductOptionRepository;
import kr.kro.moonlightmoist.shopapi.restockNoti.domain.NotificationStatus;
import kr.kro.moonlightmoist.shopapi.restockNoti.domain.NotificationType;
import kr.kro.moonlightmoist.shopapi.restockNoti.domain.RestockNotification;
import kr.kro.moonlightmoist.shopapi.restockNoti.dto.RestockNotiRes;
import kr.kro.moonlightmoist.shopapi.restockNoti.repository.RestockNotificationRepository;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RestockNotificationServiceImpl implements RestockNotificationService{

    private final RestockNotificationRepository restockNotificationRepository;
    private final UserRepository userRepository;
    private final ProductOptionRepository productOptionRepository;

    @Override
    @Transactional
    public Long applyRestockNotification(Long userId, Long optionId) {

        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        ProductOption option = productOptionRepository.findById(optionId).orElseThrow(EntityNotFoundException::new);
        Optional<RestockNotification> optionalNoti = restockNotificationRepository.findByUserIdAndProductOptionId(userId, optionId);
        if (optionalNoti.isPresent()) {
            RestockNotification restockNoti = optionalNoti.get();

            if(restockNoti.getNotificationStatus() == NotificationStatus.WAITING) {
                log.info("이미 재입고 신청 후 대기 중");
                return Long.valueOf(0);
            } else { // 취소했다가 다시 신청한 경우
                log.info("재입고 취소 후 다시 신청");
                restockNoti.rollBack();
                return restockNoti.getId();
            }
        } else { // 처음 신청한 경우
            log.info("재입고 처음 신청");
            RestockNotification restockNotification = RestockNotification.builder()
                    .user(user)
                    .productOption(option)
                    .notificationType(NotificationType.SMS)
                    .notificationStatus(NotificationStatus.WAITING)
                    .build();

            return restockNotificationRepository.save(restockNotification).getId();
        }
    }

    @Override
    @Transactional
    public Long cancelRestockNotification(Long userId, Long optionId) {
        RestockNotification noti = restockNotificationRepository.findByUserIdAndProductOptionId(userId, optionId).orElseThrow(EntityNotFoundException::new);
        noti.softDelete();

        return noti.getId();
    }

    @Override
    public RestockNotiRes getRestockNotiStatus(Long userId, List<Long> optionIds) {

        Map<Long, String> optionStatusMap = new HashMap<>();

        for (Long optionId : optionIds) {
            Optional<RestockNotification> noti = restockNotificationRepository.findByUserIdAndProductOptionId(userId, optionId);
            if(noti.isEmpty()) {
                optionStatusMap.put(optionId, "NONE");
            } else {
                optionStatusMap.put(optionId, noti.get().getNotificationStatus().name());
            }
        }

        return RestockNotiRes.builder()
                .optionNotiStatus(optionStatusMap)
                .build();
    }

    @Override
    @Transactional
    public void updateNotificationStatus(Long notiId, boolean success) {
        RestockNotification noti = restockNotificationRepository
                .findById(notiId)
                .orElseThrow(EntityNotFoundException::new);

        if (success) {
            noti.successSent();
        } else {
            noti.failSent();
        }
    }

}
