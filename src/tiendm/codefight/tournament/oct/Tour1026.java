package tiendm.codefight.tournament.oct;

import java.util.HashSet;
import java.util.Set;

public class Tour1026 {
  String deleteWhitespaces(String inputStr) {
    String s = "";
    for (int i = 0; i < inputStr.length(); i++) {
      char c = inputStr.charAt(i);
      if (c != ' ') {
        s += c + "";
      }
    }
    return s;
  }

  private static int differentValuesInMultiplicationTable(int n, int m) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        set.add((i+1) * (j+1));
      }
    }
    return set.size();
  }

  public static void main(String[] args) {
    Tour1026 t = new Tour1026();
    int[] values = {6, 2, 3, 8};
    System.out.println(t.differentValuesInMultiplicationTable(3, 2));
  }
}
