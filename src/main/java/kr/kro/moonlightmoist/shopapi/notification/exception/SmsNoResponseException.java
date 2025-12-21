package kr.kro.moonlightmoist.shopapi.notification.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class SmsNoResponseException extends BusinessException {
    public SmsNoResponseException() {
        super(HttpStatus.SERVICE_UNAVAILABLE, "메시지 발송 서비스에 일시적인 문제가 있습니다.");
    }
}
