package com.natwest.payment.kipe.application;

import com.natwest.payment.authentication.domain.Role;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;

public final class TestAuthentications {

  private TestAuthentications() {}

  public static Authentication admin() {
    return new TestingAuthenticationToken("admin", null, Role.ADMIN.key());
  }

  public static Authentication user() {
    return user("user");
  }

  public static TestingAuthenticationToken user(String username) {
    return new TestingAuthenticationToken(username, null, Role.USER.key());
  }
}
