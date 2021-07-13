package com.example.multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceOne {
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public CompletableFuture<List<Integer>> getNumbers() {
    logger.info("Current thread ID: {}", Thread.currentThread().getId());
    return CompletableFuture.completedFuture(
        IntStream
            .of(0, 9999)
            .boxed()
            .collect(Collectors.toList())
    );
  }

}
