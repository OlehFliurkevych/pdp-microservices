package com.fliurkevych.pdp.pdpmicrorecipient.converter;

import com.fliurkevych.pdp.pdpmicrorecipient.entity.NotificationEntity;
import org.springframework.amqp.core.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Oleh Fliurkevych
 */
@Component
public final class NotificationConverter implements Converter<Message, NotificationEntity> {

  @Override
  public NotificationEntity convert(Message message) {
    NotificationEntity entity = new NotificationEntity();
    entity.setMessage(new String(message.getBody()));
    return entity;
  }

}
