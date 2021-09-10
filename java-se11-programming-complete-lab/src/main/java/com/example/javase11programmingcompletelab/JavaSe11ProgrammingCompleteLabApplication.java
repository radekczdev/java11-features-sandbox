package com.example.javase11programmingcompletelab;

import com.example.javase11programmingcompletelab.inheritance.Drink;
import com.example.javase11programmingcompletelab.inheritance.Food;
import com.example.javase11programmingcompletelab.inheritance.Product;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class JavaSe11ProgrammingCompleteLabApplication {

  public static void main(String[] args) {
//    SpringApplication.run(JavaSe11ProgrammingCompleteLabApplication.class, args);
    Product p1 = new Product(101,"Tea", BigDecimal.valueOf(1.99));
    Product p2 = new Drink(102,"Coffe", BigDecimal.valueOf(1.99));
    Product p3 = new Food(103,"Cake", BigDecimal.valueOf(3.99), LocalDate.of(2021,1,25));

    System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " ");
    System.out.println(p2.getId() + " " + p1.getName() + " " + p1.getPrice() + " ");
    System.out.println(p3.getId() + " " + p1.getName() + " " + p1.getPrice() + " ");
  }

}
