package com.czajor.tests.javabasics;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StrategiesTest {
  @Test
  void shouldNotChangeEnumName() {
    String name = Strategies.CAPACITY_FOR_ACTUALS.name;
    name.replaceAll(".*", "changed");
    assertNotEquals("changed", Strategies.CAPACITY_FOR_ACTUALS.name);

  }

}