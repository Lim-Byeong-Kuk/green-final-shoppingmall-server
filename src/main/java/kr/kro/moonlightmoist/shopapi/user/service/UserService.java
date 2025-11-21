package kr.kro.moonlightmoist.shopapi.user.service;

import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.dto.UserSignUpRequest;


public interface UserService {
    User registerUser(UserSignUpRequest userSignUpRequest);
}
