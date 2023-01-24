package com.fliurkevych.pdp.pdpmicrocollector.scheduler;

import com.fliurkevych.pdp.pdpmicrocollector.feign.MicroRecipientFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Component
public class MessageScheduler {

  private final MicroRecipientFeignClient microRecipientFeignClient;

  public MessageScheduler(MicroRecipientFeignClient microRecipientFeignClient) {
    this.microRecipientFeignClient = microRecipientFeignClient;
  }

  @Scheduled(fixedDelayString = "${spring.scheduler.message.getAndRemoveAll.fixedDelay}")
  public void callMicroRecipient() {
    log.info("Scheduled call GET 'micro-recipient/messages/remove'");
    var response = microRecipientFeignClient.getAndRemoveAllNotifications();

    if (response.getStatusCode().is2xxSuccessful()) {
      log.info("Successfully called GET 'micro-recipient/messages/remove'. Body of response: [{}]",
        response.getBody());
    } else {
      log.info("Failed call GET 'micro-recipient/messages/remove'");
    }
  }

}
