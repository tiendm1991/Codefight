package tiendm.codefight.tournament.y2018.nov;

import java.util.regex.Pattern;

public class Tour1117 {
  boolean latinLettersSearchRegExp(String input) {
    return Pattern.compile("[A-Za-z]").matcher(input).find();
  }

  int summaryProficiency(int[] a, int n, int m) {

    int result = 0;
    for (int i = 0; n > 0; i++) {
      if (a[i] >= m) {
        result += a[i];
        n--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Tour1117 t = new Tour1117();
    int[] values = {2, 1, 3, 5, 3, 2};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t);
  }
}
