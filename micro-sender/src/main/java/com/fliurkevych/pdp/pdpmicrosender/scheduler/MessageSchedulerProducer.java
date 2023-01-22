package com.fliurkevych.pdp.pdpmicrosender.scheduler;

import com.fliurkevych.pdp.pdpmicrosender.publisher.MessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Component
public class MessageSchedulerProducer {
  
  private final MessagePublisher messagePublisher;

  public MessageSchedulerProducer(MessagePublisher messagePublisher) {
    this.messagePublisher = messagePublisher;
  }
  
  @Scheduled(fixedDelayString = "${spring.scheduler.rabbitmq.producer.fixedDelay}")
  public void produceMessage() {
    var message = String.valueOf("Message " + LocalDateTime.now());
    log.info("Producing new message: [{}]", message);
    if (messagePublisher.sendMessage(message)){
      log.info("Produced new message: [{}]", message);
    };
    
  }
}
