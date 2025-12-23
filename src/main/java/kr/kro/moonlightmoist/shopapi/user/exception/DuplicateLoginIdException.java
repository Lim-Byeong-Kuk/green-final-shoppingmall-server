package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DuplicateLoginIdException extends BusinessException {
    public DuplicateLoginIdException() {
        super(HttpStatus.BAD_REQUEST, "이미 사용중인 아이디 입니다.");
    }

    public DuplicateLoginIdException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
