package kr.kro.moonlightmoist.shopapi.user.domain;

public enum UserWithdrawalReason {
    SERVICE_DISSATISFACTION("서비스 불만족"),
    PRIVACY_CONCERN("개인정보 우려"),
    LOW_USAGE("사용 빈도 낮음"),
    SWITCHING_SERVICE("다른 서비스를 이용"),
    EXPENSIVE("가격이 비싸다"),
    ETC("기타");

    private final String description;

    UserWithdrawalReason(String description) {
    this.description = description;
    }

}

