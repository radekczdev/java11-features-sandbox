package com.czajor.tests.javabasics;

import java.util.Arrays;
import java.util.List;

public class CollectionsTest {

  public static void main(String[] args) {
//    var result = Stream.of("a", "b", "c").collect(Collectors.toList());
//    String resultAddress = String.valueOf(result.hashCode());
//    var resultCopy = List.copyOf(result);
//    result.removeAll(resultCopy);
//    String resultAddressAfterRemoval = String.valueOf(result.hashCode());
//
//    if(!resultAddress.equals(resultAddressAfterRemoval)) {
//      System.out.println("This is not the same array: " + resultAddress + " " + resultAddressAfterRemoval);
//    }
//    var message = result.isEmpty() ? "Array is empty" : " Result is not Empty";
//    System.out.println(message);

    List<Integer> lista = Arrays.asList(2, 4, 6, 7, 8);
    boolean allEven = lista.stream().allMatch(i -> {
      System.out.print(i);
      return i % 2 == 0;
    });


  }

}
