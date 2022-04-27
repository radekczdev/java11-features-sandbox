package com.czajor.sayhello;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@SpringBootApplication
public class SayHelloApplication {

  public static final Logger LOGGER = LoggerFactory.getLogger(SayHelloApplication.class);
  private final Random rand = new SecureRandom();

  public static void main(String[] args) {
    SpringApplication.run(SayHelloApplication.class, args);
  }

  @GetMapping("/greeting")
  public String greet() {
    LOGGER.info("Accessing /greeting");
    var greetings = List.of("Hi", "Hello", "Welcome");

    int randomNumber = rand.nextInt(greetings.size());
    return greetings.get(randomNumber);
  }

  @GetMapping("/")
  public String home() {
    LOGGER.info("Accessing /");
    return "Hi!";
  }

}
