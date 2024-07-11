package com.czajor.authenticationinnewthread;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainClass {


  public static void main(String[] args) {
    SpringApplication.run(MainClass.class, args);
  }

  @Bean
  public CommandLineRunner specificationsTest(SettingContext settingContext) {
    return args -> {
      System.out.println(Thread.currentThread());
      SecurityUtil.setContextAuthentication(SecurityUtil.user()); // this auth context will be cleared in new thread, so checking Authentication will not work
      Runnable runnable =
            () -> {
//              System.out.println(Thread.currentThread());  // setting this context here will work
              settingContext.calledMethodInNewThread();
            };
      Thread newThread = new Thread(runnable);
      newThread.start();


    };
  }

}
