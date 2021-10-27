package com.czajor.tests.javabasics;

import org.apache.commons.lang.StringUtils;

public class ApacheStringUtils {

  public static void main(String[] args) {
    String nullString = null;
    String empty = "";

    System.out.println(StringUtils.isNotBlank(nullString) ? "NullString is not blank(empty)" : "NullString is blank(empty)");
    System.out.println(StringUtils.isNotBlank(empty) ? "Empty is not blank(empty)" : "NullString is blank(empty)");
  }

}
