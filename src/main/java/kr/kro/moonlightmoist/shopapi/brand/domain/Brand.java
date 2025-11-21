package kr.kro.moonlightmoist.shopapi.brand.domain;

import jakarta.persistence.*;
import kr.kro.moonlightmoist.shopapi.brand.dto.BrandDTO;
import kr.kro.moonlightmoist.shopapi.common.domain.BaseTimeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Getter
@Table(name = "brands")
public class Brand extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "is_deleted", nullable = false)
    @Builder.Default
    private boolean deleted = false;

    public void changeName(String name) {
        this.name = name;
    }

    public void deleteBrand() {
        this.deleted = true;
    }

    public BrandDTO toDTO() {
        return BrandDTO.builder()
                .id(this.id)
                .name(this.name)
                .deleted(this.deleted)
                .build();
    }
}
