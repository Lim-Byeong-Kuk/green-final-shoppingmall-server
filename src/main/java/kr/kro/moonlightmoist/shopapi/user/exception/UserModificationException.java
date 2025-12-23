package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserModificationException extends BusinessException {
    public UserModificationException() {
        super(HttpStatus.BAD_REQUEST, "회원 정보 수정 중 오류가 발생했습니다.");
    }

    public UserModificationException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
