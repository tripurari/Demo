package com.natwest.payment.pagination.infrastructure.secondary;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.natwest.payment.error.domain.Assert;
import com.natwest.payment.pagination.domain.PaymentsAppPage;
import com.natwest.payment.pagination.domain.PaymentsAppPageable;

public final class PaymentsAppPages {

  private PaymentsAppPages() {}

  public static Pageable from(PaymentsAppPageable pagination) {
    return from(pagination, Sort.unsorted());
  }

  public static Pageable from(PaymentsAppPageable pagination, Sort sort) {
    Assert.notNull("pagination", pagination);
    Assert.notNull("sort", sort);

    return PageRequest.of(pagination.page(), pagination.pageSize(), sort);
  }

  public static <S, T> PaymentsAppPage<T> from(Page<S> springPage, Function<S, T> mapper) {
    Assert.notNull("springPage", springPage);
    Assert.notNull("mapper", mapper);

    return PaymentsAppPage
      .builder(springPage.getContent().parallelStream().map(mapper).toList())
      .currentPage(springPage.getNumber())
      .pageSize(springPage.getSize())
      .totalElementsCount(springPage.getTotalElements())
      .build();
  }
}
