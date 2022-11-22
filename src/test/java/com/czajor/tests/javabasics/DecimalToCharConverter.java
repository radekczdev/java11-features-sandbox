package com.czajor.tests.javabasics;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class DecimalToCharConverter {

  @Test
  public void convertDecimalToChar() {
    int[] signs = new int[]{123, 34};

    System.out.println(Arrays.stream(signs)
        .mapToObj(Character::toChars)
        .map(String::new)
        .collect(Collectors.joining()));
  }

}
