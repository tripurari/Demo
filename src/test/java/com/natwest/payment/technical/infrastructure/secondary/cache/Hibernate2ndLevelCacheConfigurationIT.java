package com.natwest.payment.technical.infrastructure.secondary.cache;

import org.assertj.core.api.Assertions;
import org.hibernate.cache.internal.EnabledCaching;
import org.junit.jupiter.api.Test;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import com.natwest.payment.IntegrationTest;

@IntegrationTest
class Hibernate2ndLevelCacheConfigurationIT {

  @PersistenceUnit
  EntityManagerFactory factory;

  @Test
  void shouldEnableHibernateCaching() {
    Assertions.assertThat(factory.getCache()).isInstanceOf(EnabledCaching.class);
  }
}
