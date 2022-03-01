package com.example.multithreading;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class MultithreadingApplication {

  private static final Logger logger = LoggerFactory.getLogger("Logger in MAIN");

  public static void main(String[] args) {
    logger.info("Current thread ID: " + Thread.currentThread().getId());
    try {
      Runnable classForNewThread = new ClassForNewThread();
      var t = new Thread(classForNewThread);
      t.start();
//      Thread.currentThread().wait(5000);
      if(t.isInterrupted()) {
        logger.warn("I CARE about Runnables!");
      } else {
        logger.warn("I don't care about Runnables!");
      }
    } catch (Exception e) {
      logger.error("Catched exception: " + e);
    }
//    logger.info("Current thread ID: {}", Thread.currentThread().getId());
//    try {
//      var classForNewThread = new ClassForNewThread();
//      classForNewThread.run();
//      // Warning should change
//      if(Thread.currentThread().isInterrupted()) {
//        logger.warn("I CARE about Runnables!");
//      } else {
//        logger.warn("I don't care about Runnables!");
//      }
//    } catch (Exception e) {
//      logger.error("Catched exception: {}", e);
//    }
  }

}
