package kr.kro.moonlightmoist.shopapi.helpcenter.domain;


import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import lombok.*;

@Entity
@Table(name = "notices")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NoticeType noticeType;

    @Column(name = "is_topfix")
    private boolean topFix; // 상단 고정

    @Column(nullable = false)
    private int viewCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NoticeStatus noticeStatus;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
