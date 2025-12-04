package kr.kro.moonlightmoist.shopapi.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kr.kro.moonlightmoist.shopapi.user.domain.UserWithdrawalReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserWithdrawalRequest {

    private String loginId;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    @NotNull(message = "탈퇴 사유를 선택해주세요.")
    private UserWithdrawalReason userWithdrawalReason;
}
