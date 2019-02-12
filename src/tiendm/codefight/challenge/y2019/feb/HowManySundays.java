package tiendm.codefight.challenge.y2019.feb;

import java.util.HashMap;
import java.util.Map;

public class HowManySundays {

  int howManySundays(int n, String startDay) {
    Map<String, Integer> days = new HashMap<>();
    days.put("Monday", 1);
    days.put("Tuesday", 2);
    days.put("Wednesday", 3);
    days.put("Thursday", 4);
    days.put("Friday", 5);
    days.put("Saturday", 6);
    days.put("Sunday", 0);
    return (days.get(startDay) + n) / 7;
  }

  public static void main(String[] args) {
    HowManySundays h = new HowManySundays();
    System.out.println(h.howManySundays(7, "Sunday"));
  }
}
