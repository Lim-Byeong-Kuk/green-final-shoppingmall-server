package kr.kro.moonlightmoist.shopapi.pointHistory.service;

public interface PointHistoryService {
    int getActivePoint(Long userId);
    Long earnPoint(Long userId, Long orderId, int pointValue);
    Long usePoint(Long userId, Long orderId, int amountToUse);
    Long rollbackPoint(Long orderId);
    void checkAndUpgradeUserGrade(Long userId);
}
