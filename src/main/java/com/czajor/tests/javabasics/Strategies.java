package com.czajor.tests.javabasics;

public enum Strategies {
  CAPACITY_FOR_OTHER_VERSIONS("Capacity for Other Versions"),
  CAPACITY_FOR_ACTUALS("Capacity for Actuals"),
  COSTS_FOR_OTHER_VERSIONS("Costs for Other Versions"),
  COSTS_FOR_ACTUALS("Costs for Actuals"),
  HOURS_FOR_OTHER_VERSIONS("Hours for Other Versions"),
  HOURS_FOR_ACTUALS("Hours for Actuals");

  public final String name;

  Strategies(String name) {
    this.name = name;
  }
}
