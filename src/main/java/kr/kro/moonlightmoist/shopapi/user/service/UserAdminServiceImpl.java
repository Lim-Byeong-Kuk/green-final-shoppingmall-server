package kr.kro.moonlightmoist.shopapi.user.service;

import kr.kro.moonlightmoist.shopapi.review.dto.PageRequestDTO;
import kr.kro.moonlightmoist.shopapi.review.dto.PageResponseDTO;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import kr.kro.moonlightmoist.shopapi.user.dto.UserSearchCondition;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserAdminServiceImpl implements UserAdminService{

    private final UserRepository userRepository;

    @Override
    public PageResponseDTO<User> searchUsers(UserSearchCondition condition, PageRequestDTO pageRequestDTO) {

        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage() - 1,
                pageRequestDTO.getSize()
        );

        Page<User> page = userRepository.search(condition, pageable);

        PageResponseDTO<User> pageResponseDTO = PageResponseDTO.<User>withAll()
                .dtoList(page.getContent())
                .pageRequestDTO(pageRequestDTO)
                .totalDataCount((int) page.getTotalElements())
                .build();

        return pageResponseDTO;
    }
}
