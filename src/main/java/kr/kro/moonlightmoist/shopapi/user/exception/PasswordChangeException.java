package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class PasswordChangeException extends BusinessException {
        public PasswordChangeException() {
            super(HttpStatus.BAD_REQUEST, "비밀번호 수정 중 오류가 발생했습니다.");
        }

        public PasswordChangeException(String message) {
            super(HttpStatus.BAD_REQUEST, message);
        }
}
