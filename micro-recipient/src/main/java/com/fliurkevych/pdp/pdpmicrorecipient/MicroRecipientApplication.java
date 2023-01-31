package com.fliurkevych.pdp.pdpmicrorecipient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroRecipientApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroRecipientApplication.class, args);
  }

}
