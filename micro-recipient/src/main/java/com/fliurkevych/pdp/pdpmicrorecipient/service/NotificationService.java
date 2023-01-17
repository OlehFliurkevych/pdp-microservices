package com.fliurkevych.pdp.pdpmicrorecipient.service;

import com.fliurkevych.pdp.pdpmicrorecipient.entity.NotificationEntity;
import com.fliurkevych.pdp.pdpmicrorecipient.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class NotificationService {

  private final NotificationRepository notificationRepository;
  private final Converter<Message, NotificationEntity> converter;

  public NotificationService(NotificationRepository notificationRepository,
    Converter<Message, NotificationEntity> converter) {
    this.notificationRepository = notificationRepository;
    this.converter = converter;
  }

  public NotificationEntity create(Message message) {
    var notification = converter.convert(message);
    log.info("Saving new record of notification with message: [{}]", notification.getMessage());
    return notificationRepository.save(notification);
  }

  public List<NotificationEntity> getAndRemoveAllNotifications() {
    log.info("Fetching all notifications");
    var notifications = notificationRepository.findAll();
    log.info("Fetched [{}] records of notification", notifications.size());

    if (!notifications.isEmpty()) {
      log.info("Removing all notifications");
      notificationRepository.deleteAllInBatch();
      log.info("Removed all notification");
    }

    return notifications;
  }

}