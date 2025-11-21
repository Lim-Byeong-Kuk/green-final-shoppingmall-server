package kr.kro.moonlightmoist.shopapi.category.dto;

import kr.kro.moonlightmoist.shopapi.category.domain.Category;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CategoryRegisterReq {
    private Long id;
    private Category parent;
    private String name;
    private int depth;
    private int displayOrder;
    private boolean deleted;

    public Category toEntity() {
        return Category.builder()
                .parent(this.parent)
                .name(this.name)
                .depth(this.depth)
                .displayOrder(this.displayOrder)
                .deleted(this.deleted)
                .build();
    }
}
