package kr.kro.moonlightmoist.shopapi.order.domain;

public enum OrderProductStatus {
    //결제 대기
    PENDING_PAYMENT,
    //결제 완료
    PAID,
    //배송 준비중
    PREPARING,
    //배송중
    SHIPPING,
    //배송 완료
    DELIVERED,
    //취소 신청
    CANCEL_REQUESTED,
    //교환 신청
    EXCHANGE_REQUESTED,
    //반품 신청
    RETURN_REQUESTED,

}
