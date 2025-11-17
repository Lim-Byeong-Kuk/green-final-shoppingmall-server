package kr.kro.moonlightmoist.shopapi.address.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user_addresses")
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false)
    // todo : User 클래스 추가해야함
    private User user;
    private String addressName;
    private String receiverName;
    private String receiverPhone;
    private String zipCode;
    private String roadAddress;
    private String detailAddress;

    @Column(name="is_default")
    private boolean defaultAddress;

    private String deliveryRequest;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
