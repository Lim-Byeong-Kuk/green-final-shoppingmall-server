package kr.kro.moonlightmoist.shopapi.notification.service;

import java.util.List;

public interface NotificationService {
    void sendSmsMessage(String toNumber, String content);
    void sendBatchSmsMessage(List<Long> userIds, String content);
}
