package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUnsafeCodeWithSynchronizedBlock {

  private int sheepCount = 0;

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(20);
      ThreadUnsafeCodeWithSynchronizedBlock manager = new ThreadUnsafeCodeWithSynchronizedBlock();
      for (int i = 0; i < 10; i++) {
          service.submit(manager::incrementAndReport);
      }
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

  private void incrementAndReport() { // adding synchronized after private is same as sync block below
    synchronized (this) {
      System.out.println(Thread.currentThread().getName());
      System.out.print((++sheepCount) + " ");
    }
  }
}
