package kr.kro.moonlightmoist.shopapi.helpcenter.domain;


import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import lombok.*;

@Entity
@Table(name = "faqs")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Faq extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryType inquiryType; // 1:1문의와 자주묻는질문들의 열거형이 같은 맥락

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
