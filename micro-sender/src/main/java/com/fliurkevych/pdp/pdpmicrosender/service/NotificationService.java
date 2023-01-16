package com.fliurkevych.pdp.pdpmicrosender.service;

import com.fliurkevych.pdp.pdpmicrosender.publisher.MessagePublisher;
import com.fliurkevych.pdp.pdpmicrosender.request.NotificationDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class NotificationService {

  private final MessagePublisher messagePublisher;

  @Autowired
  public NotificationService(MessagePublisher messagePublisher) {
    this.messagePublisher = messagePublisher;
  }

  public boolean notification(NotificationDto notificationDto) {
    log.info("Sending received notification message [{}] from user [{}]",
      notificationDto.getMessage(), notificationDto.getUser());
    return messagePublisher.sendMessage(notificationDto.getMessage());
  }

}
