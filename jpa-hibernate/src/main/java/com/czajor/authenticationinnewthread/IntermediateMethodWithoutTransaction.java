package com.czajor.authenticationinnewthread;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IntermediateMethodWithoutTransaction {

  private final LastClassReadingContext lastClassReadingContext;

  public void noTransaction() {
    lastClassReadingContext.readingContext();
  }
}
