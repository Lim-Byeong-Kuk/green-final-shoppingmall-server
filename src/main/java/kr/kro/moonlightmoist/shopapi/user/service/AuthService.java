package kr.kro.moonlightmoist.shopapi.user.service;

public interface AuthService {

    // 아이디 찾기: 인증 코드 발송
    void sendFindIdCode(String email);

    // 아이디 찾기: 코드 검증 및 아이디 반환
    String verifyFindId(String email, String code);

    // 비밀번호 찾기: 인증 코드 발송
    void sendFindPwCode(String userId, String email);

    // 비밀번호 찾기: 코드 검증 (단순 확인용)
    boolean verifyFindPw(String email, String code);

    // 비밀번호 재설정
    void resetPassword(String userId, String newPassword);
}
