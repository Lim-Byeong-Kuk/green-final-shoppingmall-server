package kr.kro.moonlightmoist.shopapi.user.service;

import kr.kro.moonlightmoist.shopapi.user.dto.UserWithdrawalRequest;
import kr.kro.moonlightmoist.shopapi.user.dto.UserWithdrawalResponse;

public interface UserWithdrawalService {
    public UserWithdrawalResponse withdrawUser(UserWithdrawalRequest request);

}
