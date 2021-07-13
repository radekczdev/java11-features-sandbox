package com.example.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceTwoInterrupted {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public CompletableFuture<List<Integer>> getNumbers() throws InterruptedException {
    logger.info("Current thread ID: {}", Thread.currentThread().getId());;
    List<Integer> ints = new ArrayList<>();

    for(var i = 0; i < 9999; i++) {
      if(i==500) {
        throw new InterruptedException("Manually thrown exception");
      }
      ints.add(i);
    }

    return CompletableFuture.completedFuture(ints);

  }

}
