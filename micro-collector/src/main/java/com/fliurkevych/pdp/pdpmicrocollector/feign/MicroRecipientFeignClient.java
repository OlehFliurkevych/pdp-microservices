package com.fliurkevych.pdp.pdpmicrocollector.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Oleh Fliurkevych
 */
@FeignClient("micro-recipient")

public interface MicroRecipientFeignClient {

  @GetMapping("/messages")
  ResponseEntity<List<?>> getAndRemoveAllNotifications();

}
