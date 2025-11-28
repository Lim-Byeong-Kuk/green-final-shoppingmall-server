package kr.kro.moonlightmoist.shopapi.product.dto;

import kr.kro.moonlightmoist.shopapi.product.domain.ExposureStatus;
import kr.kro.moonlightmoist.shopapi.product.domain.SaleStatus;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductSearchCondition {
    private String productName;
    private String keywords;
    private String brandName;
    private List<Long> categoryIds;
    private String dateType;
    private LocalDate fromDate;
    private LocalDate toDate;
    private List<SaleStatus> saleStatuses;
    private List<ExposureStatus> exposureStatuses;
}
