package kr.kro.moonlightmoist.shopapi.brand.dto;

import kr.kro.moonlightmoist.shopapi.brand.domain.Brand;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrandDTO {
    private Long id;
    private String name;
    private boolean deleted;

    public Brand toEntity() {
        return Brand.builder()
                .name(this.name)
                .deleted(this.deleted)
                .build();
    }
}
