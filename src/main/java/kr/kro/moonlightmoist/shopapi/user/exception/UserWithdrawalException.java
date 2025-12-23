package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UserWithdrawalException extends BusinessException {
    public UserWithdrawalException() {
        super(HttpStatus.BAD_REQUEST, "회원 탈퇴 처리 중 오류가 발생하였습니다.");
    }

    public UserWithdrawalException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
