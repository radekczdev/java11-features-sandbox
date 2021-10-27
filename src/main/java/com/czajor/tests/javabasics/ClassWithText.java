package com.czajor.tests.javabasics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor
@Getter
@ConstructorBinding
public class ClassWithText {

  private final String text;
  private final InternalValues internalValues;

  @AllArgsConstructor
  @ConstructorBinding
  @Getter
  public static class InternalValues {
    private final String internalText;
  }

}
