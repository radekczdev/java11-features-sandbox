import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Test {


  public static final String PROJECT_RESPONSIBLE = "role1";
  public static final String PROJECT_RESPONSIBLE_BUNDLE = "role2";
  public static final String ASSESSMENT_MODERATOR = "role3";

  public static void main(String[] args) {
    var roles1 = Set.of("role1");
    var roles2 = Set.of("role2");
    var roles3 = Set.of("role3");
    var roles12 = Set.of("role1", "role2");
    var roles13 = Set.of("role1", "role3");
    var roles23 = Set.of("role2", "role3");

    var testObject1 = new TestObject("Z", roles1);
    var testObject2 = new TestObject("G", roles2);
    var testObject3 = new TestObject("B", roles3);
    var testObject13 = new TestObject("X", roles13);
    var testObject12 = new TestObject("H", roles12);
    var testObject23 = new TestObject("J", roles23);
    var testObject1n = new TestObject("A", roles1);
    var testObject2n = new TestObject("Y", roles2);
    var testObjectn0 = new TestObject("F", Collections.emptySet());
    var testObjectn1 = new TestObject("L", Collections.emptySet());
    var testObjectn2 = new TestObject("K", Collections.emptySet());

    List<TestObject> members = new ArrayList<>(List.of(testObject1,
        testObjectn1,
        testObject2,
        testObject3,
        testObjectn2,
        testObject12,
        testObject13,
        testObjectn0,
        testObject23,
        testObject2n,
        testObject1n));

    System.out.println("BEFORE SORTING");
    System.out.println(members);
    Comparator<Object> cmp = Comparator
        .comparing(a -> (TestObject) a, (tm1, tm2) -> rolesComparator(tm1, tm2, PROJECT_RESPONSIBLE))
        .thenComparing(a -> (TestObject) a, (tm1, tm2) -> rolesComparator(tm1, tm2, PROJECT_RESPONSIBLE_BUNDLE))
        .thenComparing(a -> (TestObject) a, (tm1, tm2) -> rolesComparator(tm1, tm2, ASSESSMENT_MODERATOR))
        .thenComparing(a -> (TestObject) a, (tm1, tm2) -> {
          var hasPRtm1 = tm1.getRoles().isEmpty();
          var hasPRtm2 = tm2.getRoles().isEmpty();
          final var bothHasNoRoles = Boolean.compare(hasPRtm2, hasPRtm1);
          return bothHasNoRoles == 0 ? tm1.getName().compareTo(tm2.getName()) : bothHasNoRoles;
        })

        ;
    Collections.sort(members, cmp);
    System.out.println("AFTER SORTING");
    System.out.println(members);
  }

  private static int rolesComparator(TestObject tm1, TestObject tm2, String testRole) {
    var hasPRtm1 = tm1.getRoles().contains(testRole);
    var hasPRtm2 = tm2.getRoles().contains(testRole);
    if (!hasPRtm1 && !hasPRtm2) {
      return 0;
    }
    final var bothHasRole = Boolean.compare(hasPRtm2, hasPRtm1);
    return bothHasRole == 0 ? tm1.getName().compareTo(tm2.getName()) : bothHasRole;
  }

}

class TestObject {

  private final String name;
  private final Set<String> roles;

  public TestObject(String name, Set<String> roles) {
    this.name = name;
    this.roles = roles;
  }

  public String getName() {
    return name;
  }

  public Set<String> getRoles() {
    return roles;
  }

  @Override
  public String toString() {
    String retString = "\n" + "name: " + this.name;
    String roles = ", roles: " + String.join(",", this.roles);
    return retString + roles;
  }
}