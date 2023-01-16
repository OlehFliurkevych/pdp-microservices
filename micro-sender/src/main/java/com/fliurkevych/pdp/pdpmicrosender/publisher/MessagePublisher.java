package com.fliurkevych.pdp.pdpmicrosender.publisher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class MessagePublisher {

  private final RabbitTemplate rabbitTemplate;

  @Value("${spring.rabbitmq.host}")
  private String rabbitHost;
  @Value("${spring.rabbitmq.port}")
  private String rabbitPort;
  @Value("${app.rabbitmq.exchange.name}")
  private String topicExchangeName;
  @Value("${app.rabbitmq.routing.key}")
  private String routingKey;

  @Autowired
  public MessagePublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public boolean sendMessage(String message) {
    log.info("Sending message [{}] to exchange [{}].", message, topicExchangeName);
    rabbitTemplate.convertAndSend(topicExchangeName, routingKey, message);
    log.info("Sent message [{}] to exchange [{}].", message, topicExchangeName);
    return true;
  }

}
