package kr.kro.moonlightmoist.shopapi.restockNoti.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RestockNotiRes {
    @Builder.Default
    private Map<Long, String> optionNotiStatus = new HashMap<>();
}
