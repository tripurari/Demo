package com.natwest.payment.kipe.application;

import com.natwest.payment.common.domain.Generated;
import com.natwest.payment.error.domain.Assert;
import org.springframework.security.core.Authentication;

@Generated(reason = "Untested null object structure")
record NullElementAccessContext<T>(Authentication authentication, String action) implements AccessContext<T> {
  public NullElementAccessContext {
    Assert.notNull("authentication", authentication);
    Assert.notBlank("action", action);
  }

  @Override
  public T element() {
    return null;
  }
}
