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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id",nullable = false)
//    // todo : User 클래스 추가해야함
//    private User user;
    @Column(nullable = false)
    private String addressName;
    @Column(nullable = false)
    private String receiverName;
    @Column(nullable = false)
    private String receiverPhone;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String streetAddress;
    @Column(nullable = true)
    private String detailedAddress;

    @Column(name="is_default",nullable = false)
    private boolean defaultAddress;

    @Column(nullable = true)
    private String deliveryRequest;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

}
