package com.czajor.tests.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class RegexTest {

  @Test
  void shouldExtractNumber(){
    String result = "66978";
    String input1 = "+142028/66978";
    String input2 = "+142028/66978/43434";

    Pattern pattern = Pattern.compile("\\+\\d*/(\\d*)(/(.*))?");
    Matcher matcher1 = pattern.matcher(input1);
    Matcher matcher2 = pattern.matcher(input2);

    assertTrue(matcher1.find());
    assertTrue(matcher2.find());

    assertEquals(result, matcher1.group(1));
    assertEquals(result, matcher2.group(1));

  }
}
