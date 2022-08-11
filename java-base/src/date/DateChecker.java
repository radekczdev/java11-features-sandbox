package date;

import java.time.LocalDate;

public class DateChecker {


  public static boolean hasDateSameMonthAndYearAsNow(final LocalDate dateUnderTest) {
    var currentDate = LocalDate.now().withDayOfMonth(1);
    return currentDate.compareTo(dateUnderTest.withDayOfMonth(1)) == 0;
  }

  public static void main(String[] args) {
    var current = LocalDate.now().withDayOfMonth(15);
    var currentPlus2Days = LocalDate.now().plusDays(2);
    var currentMinus2Days = LocalDate.now().minusDays(2);
    var lastMonth = current.minusMonths(1L);
    var lastYear = LocalDate.of(2019,1,12);
    var futureYear = LocalDate.of(2019,1,12);

    System.out.println("currentDate: " + hasDateSameMonthAndYearAsNow(current));
    System.out.println("currentPlus2Days: " + hasDateSameMonthAndYearAsNow(currentPlus2Days));
    System.out.println("currentMinus2Days: " + hasDateSameMonthAndYearAsNow(currentMinus2Days));
    System.out.println("lastMonth: " + hasDateSameMonthAndYearAsNow(lastMonth));
    System.out.println("lastYear: " + hasDateSameMonthAndYearAsNow(lastYear));
    System.out.println("futureYear: " + hasDateSameMonthAndYearAsNow(futureYear));
  }

}
