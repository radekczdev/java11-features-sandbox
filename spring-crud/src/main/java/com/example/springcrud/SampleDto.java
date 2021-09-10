package com.example.springcrud;

import java.util.List;
import lombok.Data;

@Data
public class SampleDto {
  private String fieldA;
  private Integer number;
  private List<String> names;
}
