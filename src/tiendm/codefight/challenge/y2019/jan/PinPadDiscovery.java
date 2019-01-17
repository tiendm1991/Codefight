package tiendm.codefight.challenge.y2019.jan;

import java.util.HashSet;
import java.util.Set;

public class PinPadDiscovery {
  String pinPadDiscovery(String[][] logins) {
    if (logins.length == 1) {
      return "????";
    }
    String result = "";
    for (int i = 0; i < 4; i++) {
      Set<String> set = new HashSet<>();
      for (int j = 0; j < logins.length; j++) {
        set.add(logins[j][i]);
      }
      result += checkCommon(set);
    }
    return result;
  }

  String checkCommon(Set<String> set) {
    if (set.size() == 1)
      return "?";
    for (int i = 0; i <= 9; i++) {
      int c = 0;
      for (String s : set) {
        if (s.contains(i + "")) {
          c++;
        }
      }
      if (c == set.size())
        return i + "";
    }
    return "?";
  }

  public static void main(String[] args) {
    PinPadDiscovery p = new PinPadDiscovery();
    String[][] s = {{"58", "24", "06", "24"}};
    System.out.println();
  }
}
