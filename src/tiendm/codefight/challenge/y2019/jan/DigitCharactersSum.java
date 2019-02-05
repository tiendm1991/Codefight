package tiendm.codefight.challenge.y2019.jan;

import java.util.Arrays;

public class DigitCharactersSum {
  String digitCharactersSum(char ch1, char ch2) {
    int x1 = (int) ch1 - 48;
    int x2 = (int) ch2 - 48;
    int x3 = x1 + x2;
    return x3 + "";
  }

  boolean containsDuplicates(int[] a) {
    Arrays.sort(a);
    for (int i = 1; i < a.length; i++) {
      if (a[i] == a[i - 1]) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    DigitCharactersSum d = new DigitCharactersSum();
    System.out.println(d.digitCharactersSum('8', '9'));
    char c = '0';
    System.out.println((int) c);
  }
}
