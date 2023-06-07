package com.natwest.payment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.natwest.payment.common.domain.Generated;

@SpringBootApplication
@Generated(reason = "Not testing logs")
public class PaymentsAppApp {

  private static final Logger log = LoggerFactory.getLogger(PaymentsAppApp.class);

  public static void main(String[] args) {
    Environment env = SpringApplication.run(PaymentsAppApp.class, args).getEnvironment();

    if (log.isInfoEnabled()) {
      log.info(ApplicationStartupTraces.of(env));
    }
  }
}
