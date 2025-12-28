package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class DuplicateEmailException extends BusinessException {

    public DuplicateEmailException() {
        super(HttpStatus.BAD_REQUEST, "이미 사용 중인 이메일 입니다.");
    }

    public DuplicateEmailException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
