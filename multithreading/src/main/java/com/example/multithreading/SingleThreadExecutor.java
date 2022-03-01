package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SingleThreadExecutor {

  public static void main(String[] args) {
    ExecutorService service = null;
    Runnable task1 = () ->
        System.out.println("Printing zoo inventory");
    Runnable task2 = () ->
        IntStream
            .range(0, 3)
            .forEach(i -> System.out.println("Printing record: " + i));
    try {
      service = Executors.newSingleThreadExecutor();
      System.out.println("begin");
      service.submit(task1);
      service.submit(task2);
      service.submit(task1);
      System.out.println("end");
    } finally {
      if (service != null) {
        service.shutdown();
        if(service.isTerminated()) {
          service.shutdownNow();
        }
      }
    }
  }
}
