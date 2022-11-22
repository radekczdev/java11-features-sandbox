import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {

  public static void main(String[] args) {
    Comparator<Integer> c = (o1, o2) -> o2-o1;
    List<Integer> list = Arrays.asList(5, 4, 7, 1);
    Collections.sort(list, c);
    System.out.println(Collections.binarySearch(list, 1));
//    A. 0
//    B. 1
//    C. 2
//    D. The result is undefined.
//    E. The code does not compile.
//        F. A runtime exception is thrown.
  }

}
