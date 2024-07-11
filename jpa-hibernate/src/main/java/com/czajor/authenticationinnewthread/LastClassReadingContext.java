package com.czajor.authenticationinnewthread;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LastClassReadingContext {

  @Transactional
  @PreAuthorize("isAuthenticated()")
  public void readingContext() {
    String securityContextHolder = SecurityContextHolder.getContext().getAuthentication().getName();
    System.out.println(securityContextHolder);
  }
}
