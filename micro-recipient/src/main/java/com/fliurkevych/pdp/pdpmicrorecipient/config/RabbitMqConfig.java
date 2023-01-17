package com.fliurkevych.pdp.pdpmicrorecipient.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oleh Fliurkevych
 */
@Configuration
public class RabbitMqConfig {

  @Value("${app.rabbitmq.queue.name}")
  private String queueName;

  @Value("${app.rabbitmq.exchange.name}")
  private String exchangeName;

  @Value("${app.rabbitmq.routing.key}")
  private String routingKey;

  @Bean
  public Queue queue() {
    return new Queue(queueName, false);
  }

  @Bean
  public Exchange directExchange() {
    return new DirectExchange(exchangeName);
  }

  @Bean
  public Binding binding(Queue queue, Exchange exchange) {
    return BindingBuilder.bind(queue).to(exchange).with(routingKey).noargs();
  }

}
