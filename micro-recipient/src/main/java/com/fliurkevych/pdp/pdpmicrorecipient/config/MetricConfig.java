package com.fliurkevych.pdp.pdpmicrorecipient.config;

import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Oleh Fliurkevych
 */
@Configuration
public class MetricConfig {

  @Bean
  public CountedAspect countedAspect(MeterRegistry meterRegistry) {
    return new CountedAspect(meterRegistry);
  }

}
