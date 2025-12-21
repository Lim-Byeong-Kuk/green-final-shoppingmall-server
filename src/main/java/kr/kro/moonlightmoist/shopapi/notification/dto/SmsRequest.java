package kr.kro.moonlightmoist.shopapi.notification.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class SmsRequest {

    private List<Long> userIds;
    private String message;
}
