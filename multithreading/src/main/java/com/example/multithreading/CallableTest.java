package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CallableTest {

  public static void main(String[] args) throws Exception {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<Integer> result = service.submit(() ->
          IntStream.of(99999999).sum());
      System.out.println(result.get()); // 41
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
    if (service != null) {
      service.awaitTermination(1, TimeUnit.MICROSECONDS);
// Check whether all tasks are finished
      if (service.isTerminated()) {
        System.out.println("Finished!");
      } else {
        System.out.println("At least one task is still running");
      }
    }
  }
}
