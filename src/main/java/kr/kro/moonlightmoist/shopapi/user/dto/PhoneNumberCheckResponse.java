package kr.kro.moonlightmoist.shopapi.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PhoneNumberCheckResponse {

    private boolean isDuplicate; // 중복연락처 체크 true or false
    private String message; // 중복된 연락처에 대한 체크 메세지

}
