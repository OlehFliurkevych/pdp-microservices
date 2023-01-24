package com.fliurkevych.pdp.pdpmicrorecipient.controller;

import com.fliurkevych.pdp.pdpmicrorecipient.entity.NotificationEntity;
import com.fliurkevych.pdp.pdpmicrorecipient.service.NotificationService;
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
public class MessageController {

  public final NotificationService notificationService;

  public MessageController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @GetMapping("/messages/remove")
  public ResponseEntity<List<NotificationEntity>> getAndRemoveAllNotifications() {
    return ResponseEntity.ok(notificationService.getAndRemoveAllNotifications());
  }

  @GetMapping("/messages")
  public ResponseEntity<List<NotificationEntity>> getAllNotifications() {
    return ResponseEntity.ok(notificationService.getAllNotifications());
  }
  
}
