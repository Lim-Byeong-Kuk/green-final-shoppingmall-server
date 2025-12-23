package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public UserNotFoundException() {
        super(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.");
    }

    public UserNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
