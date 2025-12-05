package kr.kro.moonlightmoist.shopapi.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
public class UserWithdrawalResponse {

    private boolean success;
    private String message;
}
