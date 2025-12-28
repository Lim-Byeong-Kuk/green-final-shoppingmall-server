package kr.kro.moonlightmoist.shopapi.user.dto;


import kr.kro.moonlightmoist.shopapi.user.domain.UserGrade;
import kr.kro.moonlightmoist.shopapi.user.domain.UserRole;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserLoginResponse {

    private Long id;
    private String loginId; // 로그인아이디
    private String name; // 사용자이름
    private UserRole userRole;
    private UserGrade userGrade;
    private int activePoint;

}
