package com.natwest.payment.technical.infrastructure.secondary.logstash;

import static org.assertj.core.api.Assertions.assertThat;

import com.natwest.payment.UnitTest;
import org.junit.jupiter.api.Test;

@UnitTest
class LogstashTcpPropertiesTest {

  @Test
  void shouldDisableByDefault() {
    assertThat(new LogstashTcpProperties().isEnabled()).isFalse();
  }
}
