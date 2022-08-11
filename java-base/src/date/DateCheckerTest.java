package date;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class DateCheckerTest {

  @Test
  void ttt() {
    DateChecker dateChecker = new DateChecker();

    var data = LocalDate.now().withDayOfMonth(15);
    var dataSame = LocalDate.now().plusDays(2L);
    assertFalse(DateChecker.hasDateSameMonthAndYearAsNow(data));
    assertTrue(DateChecker.hasDateSameMonthAndYearAsNow(dataSame));
  }

}