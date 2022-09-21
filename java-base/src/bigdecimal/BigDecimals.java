package bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class BigDecimals {

  public static void main(String[] args) {
//    String[] s = new String[]{
//        "9",
//        "-100",
//        "50",
//        "0",
//        "56.6",
//        "90",
//        "0.12",
//        ".12",
//        "02.34",
//        "000.000"};
    String[] s = new String[] {
//        "123",
//        "45",
//        "766",
//        "324324",
//        ".324",
//        "0.325",
//        "-234",
//        "4546",
//        "100",
//        "0"
        "5",
        "0",
        "0",
        "0",
        "0",
        "0"
    };


    class StringWrapper {
      final String value;

      StringWrapper(String val) {
        this.value = val;
      }

      @Override
      public boolean equals(Object o) {
          return false;
      }

      @Override
      public int hashCode() {
        return value.hashCode();
      }
    }

    Map<StringWrapper, BigDecimal> mapOfVals = new HashMap<>();
    Arrays
        .stream(s)
        .filter(Objects::nonNull)
        .forEach(a -> mapOfVals.put(new StringWrapper(a), new BigDecimal(a).setScale(300)));

    List<Map.Entry<StringWrapper, BigDecimal>> entries = new ArrayList<>(mapOfVals.entrySet());
    entries.sort(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1) == 0 ? 0 : v2.compareTo(v1)));

    String []temp = new String[s.length];
    int countr = 0;
    for(Map.Entry<StringWrapper, BigDecimal> entry : entries) {
      temp[countr] = entry.getKey().value;
      countr++;
    }
    s = temp;


    //Output
    for(int i=0;i< s.length;i++)
    {
      System.out.println(s[i]);
    }
  }
}



