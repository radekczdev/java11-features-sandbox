package com.example.javase11programmingcompletelab.inheritance;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;

@Getter

public class Food extends Product {
  private LocalDate bestBefore;

  public Food(int id, String name, BigDecimal price, LocalDate bestBefore) {
    super(id, name, price);
    this.bestBefore = bestBefore;
  }
}
