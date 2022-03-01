package com.example.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadUnsafeCodeWithLock {

  private int sheepCount = 0;
  private Lock lock = new ReentrantLock();

  public static void main(String[] args) {
    ExecutorService service = null;
    try {
      service = Executors.newFixedThreadPool(20);
      ThreadUnsafeCodeWithLock manager = new ThreadUnsafeCodeWithLock();
      for (int i = 0; i < 10; i++) {
          service.submit(manager::incrementAndReport);
//        try {
//          Thread.sleep(5);
//        } catch (InterruptedException e) {
//          e.printStackTrace();
//        }
      }
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }

  private void incrementAndReport() { // adding synchronized after private is same as sync block below
//    lock.lock();
    try {
      if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
        try {
          System.out.print((++sheepCount) + " ");
        } finally {
          lock.unlock();
        }
      } else {
        System.out.println("Couldn't acquire lock!");
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
