package kr.kro.moonlightmoist.shopapi.review.domain;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ReviewImage {

    private String imageUrl;
    private int imageOrder;
    private String fileName;

    public void setImageOrder(int imageOrder) {
        this.imageOrder = imageOrder;
    }

}
