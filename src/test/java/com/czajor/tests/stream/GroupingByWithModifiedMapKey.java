package com.czajor.tests.stream;

import static com.czajor.tests.stream.GroupingByWithModifiedMapKey.FoodTypes.DRINK;
import static com.czajor.tests.stream.GroupingByWithModifiedMapKey.FoodTypes.FOOD;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.partitioningBy;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.h2.expression.function.Function;

public class GroupingByWithModifiedMapKey {

  public static void main(String[] args) {
    final var foods = List.of(
        new Food(1, FOOD), new Food(2, FOOD), new Food(3, DRINK)
    );

    Map<FoodTypes, List<Food>> foodTypesListMap =
        foods
            .stream()
            .collect(groupingBy(Food::getType));
    System.out.println(foodTypesListMap);
  }

  enum FoodTypes {
    FOOD,
    DRINK
  }

  @RequiredArgsConstructor
  @EqualsAndHashCode
  @Getter
  static class Food {
    private final int id;
    private final FoodTypes type;
  }

}
