package enums;

public class EnumsTest {

  enum ExceptionMessages {
    NO_STRUCTURE_FOUND_FOR_ANY_OF_PROVIDED_VERSIONS("No structure found for any of provided versions!");

    private final String message;

    ExceptionMessages(String message) {
      this.message = message;
    }

    @Override
    public String toString() {
      return message;
    }
  }

  public static void main(String[] args) {
    System.out.println(ExceptionMessages.NO_STRUCTURE_FOUND_FOR_ANY_OF_PROVIDED_VERSIONS.toString());
  }

}
