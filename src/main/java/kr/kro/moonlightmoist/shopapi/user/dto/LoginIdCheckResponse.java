package kr.kro.moonlightmoist.shopapi.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginIdCheckResponse {
    private boolean isDuplicate; // 중복아이디 체크 true or false
    private String message; // 중복된 아이디에 대한 체크 메세지
}
