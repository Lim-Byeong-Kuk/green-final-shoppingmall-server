package kr.kro.moonlightmoist.shopapi.user.exception;

import kr.kro.moonlightmoist.shopapi.common.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class AlreadyWithdrawUserException extends BusinessException {
    public AlreadyWithdrawUserException() {
        super(HttpStatus.BAD_REQUEST,"이미 탈퇴한 유저입니다.");
    }
    public AlreadyWithdrawUserException(String message) {
        super(HttpStatus.BAD_REQUEST,message);
    }
}
