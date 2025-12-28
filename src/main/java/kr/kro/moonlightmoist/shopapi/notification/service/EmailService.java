package kr.kro.moonlightmoist.shopapi.notification.service;

public interface EmailService {
    void sendVerificationEmail(String toEmail);
    boolean verifyCode(String email, String code);
    void sendEmail(String toEmail, String verificationCode);
    String generateVerificationCode();
    String buildEmailContent(String code);
    void cleanupExpiredCodes();
}
