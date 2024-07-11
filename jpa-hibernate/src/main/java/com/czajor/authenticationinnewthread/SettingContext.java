package com.czajor.authenticationinnewthread;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SettingContext {

  private final IntermediateMethodWithoutTransaction intermediateMethodWithoutTransaction;

  @Transactional
  public void calledMethodInNewThread() {
    System.out.println(Thread.currentThread());
    intermediateMethodWithoutTransaction.noTransaction();
  }
}
