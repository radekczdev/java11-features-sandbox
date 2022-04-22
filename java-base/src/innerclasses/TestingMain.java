package innerclasses;

public class TestingMain {
  public static void main(String[] args) {
    var testClass = InnerClass
        .builder()
        .id(2)
        .name("name")
        .version(3)
        .build();
    System.out.println(testClass.getCompositeKey());
  }

}
