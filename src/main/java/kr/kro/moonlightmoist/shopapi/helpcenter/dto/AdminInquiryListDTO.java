package kr.kro.moonlightmoist.shopapi.helpcenter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AdminInquiryListDTO {
    private List<AdminInquiryDTO> inquiries;
    private int totalCount;
}
