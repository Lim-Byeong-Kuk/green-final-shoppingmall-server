package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BusinessException {
    public InvalidPasswordException() {
        super(HttpStatus.BAD_REQUEST, "비밀번호가 일치 하지 않습니다.");
    }

    public InvalidPasswordException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
