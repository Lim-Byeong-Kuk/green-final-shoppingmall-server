package kr.kro.moonlightmoist.shopapi.restockNoti.controller;

import kr.kro.moonlightmoist.shopapi.restockNoti.dto.RestockNotiReq;
import kr.kro.moonlightmoist.shopapi.restockNoti.dto.RestockNotiRes;
import kr.kro.moonlightmoist.shopapi.restockNoti.service.RestockNotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restock-notification")
@Slf4j
@RequiredArgsConstructor
public class RestockNotificationController {

    private final RestockNotificationService restockNotificationService;

    @PostMapping("")
    public ResponseEntity<Long> applyRestockAlarm(@RequestBody RestockNotiReq req) {
        Long id = restockNotificationService.applyRestockNotification(req.getUserId(), req.getOptionId());
        return ResponseEntity.ok(id);
    }

    @PostMapping("/cancel")
    public ResponseEntity<Long> cancelRestockAlarm(@RequestBody RestockNotiReq req) {
        Long id = restockNotificationService.cancelRestockNotification(req.getUserId(), req.getOptionId());
        return ResponseEntity.ok(id);
    }

    @GetMapping("")
    public ResponseEntity<RestockNotiRes> isAppliedRestockAlarm(
            @RequestParam("userId") Long userId,
            @RequestParam("optionId")List<Long> optionIds) {
        RestockNotiRes result = restockNotificationService.getRestockNotiStatus(userId, optionIds);
        return ResponseEntity.ok(result);
    }
}
