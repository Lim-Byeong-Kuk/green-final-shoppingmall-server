package kr.kro.moonlightmoist.shopapi.user.repository;

import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.dto.UserSearchCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserCustomRepository {
    Page<User> search(UserSearchCondition condition, Pageable pageable);
}
