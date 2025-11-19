package kr.kro.moonlightmoist.shopapi.helpcenter.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import kr.kro.moonlightmoist.shopapi.user.domain.User;
import lombok.*;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inquiry extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // pk

    @Column(nullable = false)
    private String title;   // 문의 제목

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryType inquiryType;  // 문의 유형

    @Column(nullable = false)
    private String content;   // 문의내용

    @Column(name = "is_answered")
    private boolean answered;   // 답변 완료여부

    @Column(nullable = false)
    private String answerContent; // 답변내용

    @Column(name = "is_visible")
    private boolean visible;   // 노출 여부

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InquiryStatus inquiryStatus; // 진행 상태

    private boolean agreeEmailContact; // 이메일알림동의

    private boolean agreeSmsContact; // sms 알림동의

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
