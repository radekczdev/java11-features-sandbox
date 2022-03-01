package com.example.multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassForNewThread implements Runnable {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public void run() {
    var serviceOne = new ServiceOne();
    var serviceTwoInterrupted = new ServiceTwoInterrupted();
    logger.info("Current thread ID: {} ", Thread.currentThread().getId());
    try {
      CompletableFuture<List<Integer>> list1 = serviceOne.getNumbers();
      CompletableFuture<List<Integer>> list2 = serviceTwoInterrupted.getNumbers();
      CompletableFuture.allOf(list1, list2).join();
    } catch (InterruptedException e) {
      logger.error(e.getMessage(), e);
      // Comment and uncomment this line to see change.
      Thread.currentThread().interrupt();
    }
  }
}
