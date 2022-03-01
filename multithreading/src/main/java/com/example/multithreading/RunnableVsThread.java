package com.example.multithreading;

public class RunnableVsThread {

  public static void main(String[] args) {
    // start() creates new Thread, whereas run() is started in current thread
    Thread f = new Thread(() -> {
      System.out.println("GO!");
      System.out.println(Thread.currentThread());
    });
    Runnable sloth = () -> {
      System.out.println("Hello World");
      System.out.println(Thread.currentThread());
    };
    Thread t = new Thread(sloth);
    Thread t1 = new Thread(f);
    Runnable snake = () -> {
      System.out.println("Snake");
      System.out.println(Thread.currentThread());
    };
    Runnable beaver = () -> {
      System.out.println("Beaver");
      System.out.println(Thread.currentThread());
    };
    Runnable coyote = () -> {
      System.out.println("Coyote");
      System.out.println(Thread.currentThread());
      return;
    };
    f.start();
    t.start();
    t1.start();
    snake.run();
    beaver.run();
    coyote.run();

  }


}
