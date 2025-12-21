package kr.kro.moonlightmoist.shopapi.notification.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class SmsUnknownException extends BusinessException {
    public SmsUnknownException() {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "메시지 발송 중 예기치 않은 오류가 발생했습니다.");
    }
}
