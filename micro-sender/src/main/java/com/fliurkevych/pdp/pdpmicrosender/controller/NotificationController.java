package com.fliurkevych.pdp.pdpmicrosender.controller;

import com.fliurkevych.pdp.pdpmicrosender.request.NotificationDto;
import com.fliurkevych.pdp.pdpmicrosender.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Oleh Fliurkevych
 */
@Slf4j
@RestController
public class NotificationController {

  private final NotificationService notificationService;

  @Autowired
  public NotificationController(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @PostMapping(path = "/notification")
  public ResponseEntity<String> notification(@RequestBody NotificationDto notificationDto) {
    log.info("Received notification: [{}]", notificationDto);
    return notificationService.notification(notificationDto)
      ? ResponseEntity.ok("Successfully processed notification message")
      : ResponseEntity.badRequest().body("Error with processing notification message");
  }

}
