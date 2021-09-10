package com.example.javase11programmingcompletelab.inheritance;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {
  private int id;
  private String name;
  private BigDecimal price;
}
