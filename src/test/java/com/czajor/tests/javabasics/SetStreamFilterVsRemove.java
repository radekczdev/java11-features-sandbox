package com.czajor.tests.javabasics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class SetStreamFilterVsRemove {


  @Test
  void isRemoveFasterThanFilterContains() {
    var setA = getSetA(0, 500000);
    var setB = Set.of(setA, getSetA(500001, 10000000));

    var time1 = System.currentTimeMillis();
    var resSet2 = setB.stream().filter(element -> !setA.contains(element)).collect(Collectors.toSet());
    var time2 = System.currentTimeMillis();
    var time3 = System.currentTimeMillis();
    var resSet3 = new HashSet<>(setB);
    resSet3.removeAll(setA);
    var time4 = System.currentTimeMillis();

    System.out.println("Filter/Contains: " + (time2-time1) + "ms. RemoveAll: " + (time4-time3) + " ms");
    assertEquals(resSet3, resSet2);
  }

  @Test
  void isRemoveIfFasterThanContainsRemove() {

    String valToRemove = "584";

    var setA = getSetA(0, 500000);
    var setB = getSetA(0,500000);

    var time1 = System.currentTimeMillis();
    if(setA.contains(valToRemove)) {
      setA.remove(valToRemove);
    }
    var time2 = System.currentTimeMillis();

    var time3 = System.currentTimeMillis();
    var resSet3 = new HashSet<>(setB);
    setB.removeIf(a -> a.equals(valToRemove));
    var time4 = System.currentTimeMillis();

    System.out.println("Filter/Contains: " + (time2-time1) + "ms. RemoveIF: " + (time4-time3) + " ms");
  }

  private Set<String> getSetA(Integer startInclusive, Integer endInclusive) {
    return IntStream.rangeClosed(startInclusive, endInclusive).mapToObj(String::valueOf)
        .collect(Collectors.toUnmodifiableSet());
  }
}
