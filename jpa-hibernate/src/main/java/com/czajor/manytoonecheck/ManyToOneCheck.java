package com.czajor.manytoonecheck;

import com.czajor.manytoonecheck.service.Checking;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToOneCheck {

  public static void main(String[] args) {
    SpringApplication.run(ManyToOneCheck.class, args);
  }

  @Bean
  CommandLineRunner run(Checking checking) {
    return args -> checking.runChecking();
  }
}
