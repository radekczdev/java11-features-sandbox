package com.czajor.softdelete;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftDeleteTest {

  public static void main(String[] args) {
    SpringApplication.run(SoftDeleteTest.class, args);
  }

  @Bean
  public CommandLineRunner specificationsTest(PersonRepository personRepository) {
    return args -> {
      System.out.println("Hello World!");
      Address address = Address.builder().id(1L).city("CITY").street("STREET").build();
      Person person = Person.builder().id(1L).address(address).build();
      personRepository.save(person);
      System.out.println("PERSON IS SAVED");
      personRepository.delete(person);
      System.out.println("PERSON IS DELETED");
    };
  }
}