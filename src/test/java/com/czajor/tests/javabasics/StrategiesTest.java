package com.czajor.tests.javabasics;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class StrategiesTest {
  @Test
  void shouldNotChangeEnumName() {
    String name = Strategies.CAPACITY_FOR_ACTUALS.name;
    name.replaceAll(".*", "changed");
    assertNotEquals("changed", Strategies.CAPACITY_FOR_ACTUALS.name);

  }

  @Test
  void shouldCheckIfMapContainsKey() {
    var mapOfVals = Map.of("1", List.of(1), "2", List.of(2));
    assertFalse(mapOfVals.containsKey("3"));
  }

}