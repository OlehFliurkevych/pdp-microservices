package com.fliurkevych.microvisualizer.service;

import com.fliurkevych.microvisualizer.entity.NotificationEntity;
import com.fliurkevych.microvisualizer.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@Service
public class NotificationService {

  private final NotificationRepository notificationRepository;

  public NotificationService(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  public List<NotificationEntity> getNotifications() {
    log.info("Fetching all notifications");
    var notifications = notificationRepository.findAll();
    log.info("Fetched [{}] notifications", notifications.size());
    return notifications;
  }

}
