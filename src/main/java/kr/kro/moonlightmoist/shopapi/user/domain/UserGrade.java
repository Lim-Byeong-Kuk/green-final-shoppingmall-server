package kr.kro.moonlightmoist.shopapi.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity // 엔티티 설정 JPA와 1:1매핑 JPA가 관리
@Table(name = "user_grades") // 테이블생성
@AllArgsConstructor // 전체필드 생성자 -> 빌더를 사용하려면 꼭 필요하다.
@NoArgsConstructor // 기본 생성자.
@Getter // 데이터 가져오기
@Builder // 빌더패턴 생성
@ToString // 객체의 모든 필드를 포함하는 문자열 자동 생성, 디버깅이나 로그 기록 시 엔티티 객체의 상태를 쉽게 확인하기 위해
public class UserGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // pk

    @Column(nullable = false)
    private String grade;   // 등급이름

    @Column(nullable = false)
    private int minTotalPoints; // 최소 누적 포인트

    @Column(nullable = false)
    private int disCountRate; // 할인율

    @Column(nullable = false)
    private int freeDeliveryMinAmount; // 무료 배송 기준

    @Column(nullable = false)
    private String description; // 등급 설명(혜택)

}
