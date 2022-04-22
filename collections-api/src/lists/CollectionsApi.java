package lists;

import java.util.ArrayList;
import java.util.List;

public class CollectionsApi {

  public static void main(String[] args) {
    List<String> allNames = new ArrayList<>(List.of("John", "George", "Peter"));
    List<String> namesToCheck = List.of("George");
    allNames.retainAll(namesToCheck);
    allNames.forEach(System.out::println);
  }
}
