package com.czajor.tests.javabasics;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppendNullToStringBuilder {

  private final ClassWithText classWithText;

  public String appendText() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(classWithText.getText());
    stringBuilder.append(classWithText.getInternalValues().getInternalText());
    return stringBuilder.toString();
  }

}
