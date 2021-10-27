package com.czajor.tests.javabasics;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionsTest {

  public static void main(String[] args) {
    var result = Stream.of("a", "b", "c").collect(Collectors.toList());
    String resultAddress = String.valueOf(result.hashCode());
    var resultCopy = List.copyOf(result);
    result.removeAll(resultCopy);
    String resultAddressAfterRemoval = String.valueOf(result.hashCode());

    if(!resultAddress.equals(resultAddressAfterRemoval)) {
      System.out.println("This is not the same array: " + resultAddress + " " + resultAddressAfterRemoval);
    }
    var message = result.isEmpty() ? "Array is empty" : " Result is not Empty";
    System.out.println(message);
  }

}
