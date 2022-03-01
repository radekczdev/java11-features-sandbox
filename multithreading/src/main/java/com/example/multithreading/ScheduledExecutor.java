package com.example.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    Runnable task1 = () -> System.out.println("Hello Zoo");
    Callable task2 = () -> "Monkey";
    ScheduledFuture<?> r1 = service.schedule(task1, 10, TimeUnit.SECONDS);
//    Future<?> r1 = service.submit(task1);
    ScheduledFuture<?> r2 = service.schedule(task2, 1, TimeUnit.MINUTES);
//    Future<?> r2 = service.submit(task2);
    service.shutdown();
//    while ((!r1.isDone() && !r2.isDone()) || service.isTerminated()) {}
    System.out.println(r2.get());

  }
}
