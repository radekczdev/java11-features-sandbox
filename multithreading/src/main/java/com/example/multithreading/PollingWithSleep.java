package com.example.multithreading;

public class PollingWithSleep {

  private static int counter = 0;

  public static void main(String[] args) throws InterruptedException {
    new Thread(() -> {
      for (int i = 0; i < 500; i++) {
        PollingWithSleep.counter++;
      }
    }).start();
    while (PollingWithSleep.counter < 100) {
      System.out.println("Not reached yet");
      Thread.sleep(1000);
    }
    System.out.println("Reached!");
  }
}
