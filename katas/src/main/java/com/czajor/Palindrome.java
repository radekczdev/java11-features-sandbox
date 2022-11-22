package com.czajor;

import java.util.List;
import java.util.stream.IntStream;

public class Palindrome {

  public static void main(String[] args) {
    List<String> values = List.of("abba", "kata", "aviva", "aviiva", "george", "tat", "at", "aa", "baab", "hello", "a");

    values
        .forEach(a -> System.out.println(a + " is palindrome?: " + isPalindrome(a)));
  }

  public static boolean isPalindrome(final String value) {
    int end = value.length() - 1;

    return IntStream
        .range(0, end)
        .noneMatch(start -> value.charAt(start) != value.charAt(end - start));

  }

}
