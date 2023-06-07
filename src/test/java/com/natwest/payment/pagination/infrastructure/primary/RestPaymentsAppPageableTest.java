package com.natwest.payment.pagination.infrastructure.primary;

import static com.natwest.payment.BeanValidationAssertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.natwest.payment.UnitTest;
import com.natwest.payment.pagination.domain.PaymentsAppPageable;

@UnitTest
class RestPaymentsAppPageableTest {

  @Test
  void shouldConvertToDomain() {
    PaymentsAppPageable pageable = pageable().toPageable();

    assertThat(pageable.page()).isEqualTo(1);
    assertThat(pageable.pageSize()).isEqualTo(15);
  }

  @Test
  void shouldNotValidateWithPageUnderZero() {
    RestPaymentsAppPageable pageable = pageable();
    pageable.setPage(-1);

    assertThatBean(pageable).hasInvalidProperty("page");
  }

  @Test
  void shouldNotValidateWithSizeAtZero() {
    RestPaymentsAppPageable pageable = pageable();
    pageable.setPageSize(0);

    assertThatBean(pageable).hasInvalidProperty("pageSize").withParameter("value", 1L);
  }

  @Test
  void shouldNotValidateWithPageSizeOverHundred() {
    RestPaymentsAppPageable pageable = pageable();
    pageable.setPageSize(101);

    assertThatBean(pageable).hasInvalidProperty("pageSize");
  }

  private RestPaymentsAppPageable pageable() {
    return new RestPaymentsAppPageable(1, 15);
  }
}
