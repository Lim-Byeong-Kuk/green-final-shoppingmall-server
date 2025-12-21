package kr.kro.moonlightmoist.shopapi.notification.service;

import jakarta.persistence.EntityNotFoundException;
import kr.kro.moonlightmoist.shopapi.common.config.CoolSmsConfig;
import kr.kro.moonlightmoist.shopapi.notification.exception.SmsNoResponseException;
import kr.kro.moonlightmoist.shopapi.notification.exception.SmsNotReceivedException;
import kr.kro.moonlightmoist.shopapi.notification.exception.SmsUnknownException;
import kr.kro.moonlightmoist.shopapi.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.message.exception.NurigoEmptyResponseException;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.exception.NurigoUnknownException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.response.MultipleDetailMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService{

    private final DefaultMessageService messageService;
    private final CoolSmsConfig coolSmsConfig;
    private final UserRepository userRepository;

    public void sendSmsMessage(String toNumber, String content) {
        try {
            Message message = new Message();
            message.setFrom(coolSmsConfig.getSender());
            message.setTo(toNumber);
            message.setText(content);

            MultipleDetailMessageSentResponse result = messageService.send(message);

            log.info("발송 요청 후 응답 : {}", result);

        } catch (NurigoMessageNotReceivedException e) {
            log.info("수신자에게 발송 실패 : {}", e.getFailedMessageList());
            throw new SmsNotReceivedException();
        } catch (NurigoEmptyResponseException e) {
            log.info("CoolSms 로부터 응답 없음 : {}", e.getMessage());
            throw new SmsNoResponseException();
        } catch (NurigoUnknownException e) {
            log.info("메시지 발송 요청 중 예기치 않은 오류 발생 : {}", e.getMessage());
            throw new SmsUnknownException();
        }
    }

    public void sendBatchSmsMessage(List<Long> userIds, String content) {

        List<String> toNumbers = userIds.stream()
                .map((id) -> userRepository.findById(id).orElseThrow(EntityNotFoundException::new)
                        .getPhoneNumber()).toList();

        List<Message> messages = new ArrayList<>();

        for (String number : toNumbers) {
            Message message = new Message();
            message.setFrom(coolSmsConfig.getSender());
            message.setTo(number);
            message.setText(content);

            messages.add(message);
        }

        try {
            messageService.send(messages);
        } catch (NurigoMessageNotReceivedException e) {
            log.info("일부 수신자에게 발송 실패 : {}", e.getFailedMessageList());
            throw new RuntimeException(e);
        } catch (NurigoEmptyResponseException e) {
            log.info("CoolSms 로부터 응답 없음 : {}", e.getMessage());
            throw new RuntimeException(e);
        } catch (NurigoUnknownException e) {
            log.info("메시지 발송 요청 중 예기치 않은 오류 발생 : {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
