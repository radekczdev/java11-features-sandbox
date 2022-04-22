package innerclasses;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter(value = AccessLevel.PRIVATE)
public class InnerClass {

  private final String name;
  private final CompositeKey compositeKey;
  private final int id;
  private final int version;

  @Builder
  public InnerClass(String name, int id, int version) {
    this.name = name;
    this.id = id;
    this.version = version;
    this.compositeKey = new CompositeKey(id, version);
  }

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  @ToString
  private static class CompositeKey {

    private int id;
    private int version;

    private CompositeKey(final int id, final int version) {
      this.id = id;
      this.version = version;
    }
  }


}

