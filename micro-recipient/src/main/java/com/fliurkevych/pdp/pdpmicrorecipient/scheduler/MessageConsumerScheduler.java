package com.fliurkevych.pdp.pdpmicrorecipient.scheduler;

import com.fliurkevych.pdp.pdpmicrorecipient.service.NotificationService;
import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Component
public class MessageConsumerScheduler {
  
  private final RabbitTemplate rabbitTemplate;
  private final NotificationService notificationService;

  @Value("${app.rabbitmq.queue.name}")
  private String queueName;

  public MessageConsumerScheduler(RabbitTemplate rabbitTemplate,
    NotificationService notificationService) {
    this.rabbitTemplate = rabbitTemplate;
    this.notificationService = notificationService;
  }

  @Counted(value = "message.consumer.counted", description = "Count of invoking message consumer")
  @Scheduled(fixedDelayString = "${spring.scheduler.rabbitmq.consumer.fixedDelay}")
  public void receiveMessageFromRabbitMq(){
    log.info("Receiving message from rabbitmq queue [{}]", queueName);
    Optional.ofNullable(rabbitTemplate.receive(queueName))
          .ifPresent(message -> {
              log.info("Received message: [{}]", message.getBody());
              notificationService.create(message);
              log.info("Saved received message: [{}]", message.getBody());
            });
  }

}
