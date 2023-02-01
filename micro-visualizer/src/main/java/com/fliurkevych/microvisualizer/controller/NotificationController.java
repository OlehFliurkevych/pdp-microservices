package com.fliurkevych.microvisualizer.controller;

import com.fliurkevych.microvisualizer.entity.NotificationEntity;
import com.fliurkevych.microvisualizer.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@RestController
public class NotificationController {

  private final NotificationService notificationService;

  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping("/saved-messages")
  public ResponseEntity<List<NotificationEntity>> getNotifications() {
    var notifications = notificationService.getNotifications();
    return ResponseEntity.ok(notifications);
  }

}
