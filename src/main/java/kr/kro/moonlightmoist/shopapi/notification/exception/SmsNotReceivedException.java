package kr.kro.moonlightmoist.shopapi.notification.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class SmsNotReceivedException extends BusinessException {
    public SmsNotReceivedException() {
        super(HttpStatus.BAD_REQUEST, "메시지 발송에 실패했습니다. 수신자 정보를 확인해주세요.");
    }
}
