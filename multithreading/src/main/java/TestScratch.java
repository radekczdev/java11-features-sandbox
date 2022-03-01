abstract class Foo {
  int i = 0;
  abstract void m();
}

class TestScratch {

  public static void main(String[] args) {
    int i =2;
    new Foo() {
      void m() {
        i++;
      }
    };
    System.out.println(i);
  }
}
