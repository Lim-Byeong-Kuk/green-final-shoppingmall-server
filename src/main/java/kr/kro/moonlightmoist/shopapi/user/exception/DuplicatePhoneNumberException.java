package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DuplicatePhoneNumberException extends BusinessException {
    public DuplicatePhoneNumberException() {
        super(HttpStatus.BAD_REQUEST, "이미 사용 중인 연락처 입니다.");
    }

    public DuplicatePhoneNumberException(String message){
        super(HttpStatus.BAD_REQUEST, message);
    }
}
