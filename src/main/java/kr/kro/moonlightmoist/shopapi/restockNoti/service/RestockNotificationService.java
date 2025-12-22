package kr.kro.moonlightmoist.shopapi.restockNoti.service;

import kr.kro.moonlightmoist.shopapi.restockNoti.dto.RestockNotiRes;

import java.util.List;

public interface RestockNotificationService {
    Long applyRestockNotification(Long userId, Long optionId);
    Long cancelRestockNotification(Long userId, Long optionId);
    RestockNotiRes getRestockNotiStatus(Long userId, List<Long> optionIds);
}
