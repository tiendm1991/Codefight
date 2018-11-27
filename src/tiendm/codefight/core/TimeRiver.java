package tiendm.codefight.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeRiver {
  boolean validTime(String time) {
    String[] arr = time.split("\\:");
    try {
      int h = Integer.parseInt(arr[0]);
      int m = Integer.parseInt(arr[1]);
      return h < 24 && m < 60;
    } catch (Exception e) {
      return false;
    }
  }

  /////////////////////////////////////////////
  int[] videoPart(String part, String total) {
    String[] arrTotal = total.split("\\:");
    int lTotal = Integer.parseInt(arrTotal[0]) * 3600 + Integer.parseInt(arrTotal[1]) * 60
        + Integer.parseInt(arrTotal[2]);
    String[] arrPart = part.split("\\:");
    int lPart = Integer.parseInt(arrPart[0]) * 3600 + Integer.parseInt(arrPart[1]) * 60
        + Integer.parseInt(arrPart[2]);
    int x = gcd(lTotal, lPart);
    return new int[] {lPart / x, lTotal / x};
  }

  int gcd(int lTotal, int lPart) {
    if (lTotal % lPart == 0)
      return lPart;
    return gcd(lPart, lTotal % lPart);
  }

  /////////////////////////////////////////
  int dayOfWeek(String birthdayDate) {
    SimpleDateFormat fomat = new SimpleDateFormat("MM-dd-yyyy");
    try {
      Calendar cal = Calendar.getInstance();
      cal.setTime(fomat.parse(birthdayDate));
      int day = cal.get(Calendar.DAY_OF_WEEK);
      int count = 0, dayNext = -1;
      while (day != dayNext) {
        if (birthdayDate.startsWith("02-29"))
          count += 4;
        else
          count++;
        String year = buildDate(birthdayDate, count);;
        cal.setTime(fomat.parse(year));
        dayNext = cal.get(Calendar.DAY_OF_WEEK);
      }
      return count;
    } catch (ParseException e) {
      e.printStackTrace();
      return 0;
    }
  }

  String buildDate(String birthdayDate, int count) {
    String[] arr = birthdayDate.split("-");
    int year = Integer.parseInt(arr[2]) + count;
    return arr[0] + "-" + arr[1] + "-" + year;
  }

  ///////////////////////////////////////////////////////////
  String curiousClock(String someTime, String leavingTime) {
    SimpleDateFormat fomat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    try {
      Date d1 = fomat.parse(someTime);
      Date d2 = fomat.parse(leavingTime);
      long period = d2.getTime() - d1.getTime();
      long timed3 = d1.getTime() - period;
      Calendar cal = Calendar.getInstance();
      cal.setTimeInMillis(timed3);
      Date d3 = cal.getTime();
      return fomat.format(d3);
    } catch (ParseException e) {
      e.printStackTrace();
      return "";
    }
  }

  /////////////////////////////////////////////////////////////
  int newYearCelebrations(String takeOffTime, int[] minutes) {
    String[] arr = takeOffTime.split("\\:");
    int h = Integer.parseInt(arr[0]) == 0 ? 24 : Integer.parseInt(arr[0]);
    int m = Integer.parseInt(arr[1]);
    int time = h * 60 + m, timeCheck = 60 * 24, count = 0;
    int i = 0;
    while (i < minutes.length) {
      int timeStop = time + (i == 0 ? minutes[i] : minutes[i] - minutes[i - 1]);
      if (time <= timeCheck && timeStop >= timeCheck)
        count++;
      time = timeStop - 60;
      i++;
    }
    if (time <= timeCheck)
      count++;
    return count;
  }

  /////////////////////////////////////////////////////////////
  String regularMonths(String currMonth) {
    SimpleDateFormat fomat = new SimpleDateFormat("dd-MM-yyyy");
    Calendar cal = Calendar.getInstance();
    int day = -1;
    String dateCheck = "";
    int m = Integer.parseInt(currMonth.split("-")[0]);
    int y = Integer.parseInt(currMonth.split("-")[1]);
    try {
      while (day != 2) {
        if (m == 12) {
          m = 1;
          y++;
        } else {
          m++;
        }
        dateCheck = buildDate(m, y);
        cal.setTime(fomat.parse(dateCheck));
        day = cal.get(Calendar.DAY_OF_WEEK);
      }
    } catch (Exception e) {
    }
    return dateCheck.substring(3);
  }

  String buildDate(int m, int y) {
    return "01-" + ((m < 10) ? "0" : "") + m + "-" + y;
  }

  ////////////////////////////////////////
  int missedClasses(int year, int[] daysOfTheWeek, String[] holidays) {
    String sCheck = "";
    int count = 0;
    SimpleDateFormat fomat = new SimpleDateFormat("MM-dd-yyyy");
    Calendar cal = Calendar.getInstance();
    for (int i : daysOfTheWeek) {
      sCheck += (i == 7) ? 1 : i + 1;
    }
    for (String h : holidays) {
      int month = Integer.parseInt(h.split("-")[0]);
      if (month > 5 && month < 9)
        continue;
      int y = month < 9 ? year + 1 : year;
      try {
        cal.setTime(fomat.parse(h + "-" + y));
        int day = cal.get(Calendar.DAY_OF_WEEK);
        if (sCheck.contains(day + ""))
          count++;
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
    return count;
  }

  /////////////////////////////////////////////////
  int holiday(int x, String weekDay, String month, int yearNumber) {
    Calendar cal = Calendar.getInstance();
    Calendar calCheck = Calendar.getInstance();
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};
    String[] days =
        {"", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    List<String> lsMonth = Arrays.asList(months);
    List<String> lsDay = Arrays.asList(days);
    int iWDay = lsDay.indexOf(weekDay);
    int iMonth = lsMonth.indexOf(month);
    cal.set(Calendar.YEAR, yearNumber);
    cal.set(Calendar.MONTH, iMonth);

    cal.set(Calendar.DAY_OF_MONTH, 1);
    cal.setFirstDayOfWeek(cal.get(Calendar.DAY_OF_WEEK));

    cal.set(Calendar.WEEK_OF_MONTH, x);
    cal.set(Calendar.DAY_OF_WEEK, iWDay);
    int dayMonth = cal.get(Calendar.DAY_OF_MONTH);
    if (cal.get(Calendar.MONTH) != iMonth)
      return -1;
    return dayMonth;
  }

  public static void main(String[] args) {
    TimeRiver time = new TimeRiver();
    System.out.println(time.holiday(3, "Thursday", "January", 2101));
  }
}
