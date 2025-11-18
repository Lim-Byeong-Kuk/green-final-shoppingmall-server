package kr.kro.moonlightmoist.shopapi.policy.deliveryPolicy.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Check;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Check(constraints = "policy_type IN ('PAID','CONDITIONAL_FREE','FREE')")
@Table(name = "delivery_policies")
public class DeliveryPolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "policy_type",nullable = false)
    private String policyType;
    @Column(nullable = false)
    private int basicDeliveryFee;
    @Column(nullable = true)
    private int freeConditionAmount;
    @Column(name = "is_default",nullable = false)
    private boolean defaultPolicy;
    @Column(name = "is_deleted",nullable = false)
    private boolean deleted;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = true)
    private LocalDateTime updatedAt;
}
