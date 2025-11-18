package kr.kro.moonlightmoist.shopapi.policy.returnPolicy.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "return_policies")
public class ReturnPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String applyMethod;
    @Column(nullable = false)
    private String applyPeriod;
    @Column(nullable = false)
    private String costInfo;
    @Column(nullable = false)
    private String notAllowedCondition;
    @Column(nullable = false)
    private String customerServiceNumber;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
