package com.natwest.payment.pagination.infrastructure.primary;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import io.swagger.v3.oas.annotations.media.Schema;
import com.natwest.payment.common.domain.Generated;
import com.natwest.payment.pagination.domain.PaymentsAppPageable;

@Schema(name = "PaymentsAppPageable", description = "Pagination information")
public class RestPaymentsAppPageable {

  private int page;
  private int pageSize = 10;

  @Generated
  public RestPaymentsAppPageable() {}

  public RestPaymentsAppPageable(int page, int pageSize) {
    this.page = page;
    this.pageSize = pageSize;
  }

  @Min(value = 0)
  @Schema(description = "Page to display (starts at 0)", example = "0")
  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  @Min(value = 1)
  @Max(value = 100)
  @Schema(description = "Number of elements on each page", example = "10")
  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public PaymentsAppPageable toPageable() {
    return new PaymentsAppPageable(page, pageSize);
  }
}
