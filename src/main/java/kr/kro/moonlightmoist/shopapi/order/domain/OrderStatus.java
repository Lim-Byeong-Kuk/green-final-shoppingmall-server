package kr.kro.moonlightmoist.shopapi.order.domain;

public enum OrderStatus {
    //주문 접수
    PENDING,
    //결제 완료
    PAID,
    //배송 준비중
    PREPARING,
    //배송중
    SHIPPED,
    //배송 완료
    DELIVERED,
    //주문 취소
    CANCELLED,
    //환불 완료
    REFUNDED
}
