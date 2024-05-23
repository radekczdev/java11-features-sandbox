package com.czajor;

import java.util.Set;

public record AstroResponse(
    String message,
    int number,
    Set<Assignment> people
) {
  record Assignment(
      String name,
      String craft
  ) {
  }
}
