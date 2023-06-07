package com.natwest.payment.pagination.domain;

import java.util.List;

import com.natwest.payment.pagination.domain.PaymentsAppPage.PaymentsAppPageBuilder;

public final class PaymentsAppPagesFixture {

  private PaymentsAppPagesFixture() {}

  public static PaymentsAppPage<String> page() {
    return pageBuilder().build();
  }

  public static PaymentsAppPageBuilder<String> pageBuilder() {
    return PaymentsAppPage.builder(List.of("test")).currentPage(2).pageSize(10).totalElementsCount(21);
  }
}
