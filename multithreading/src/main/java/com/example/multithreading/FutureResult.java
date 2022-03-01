package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureResult {

  private static int counter = 0;

  public static void main(String[] unused) throws Exception {
    ExecutorService service = null;
    try {
      service = Executors.newSingleThreadExecutor();
      Future<?> result = service.submit(() -> {
        for (int i = 0; i < 500; i++) {
          FutureResult.counter++;
        }
      });
      result.get(10, TimeUnit.SECONDS);
      System.out.println("Reached!");
    } catch (TimeoutException e) {
      System.out.println("Not reached in time");
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }
}
