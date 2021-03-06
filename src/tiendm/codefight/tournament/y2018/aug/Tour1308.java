package tiendm.codefight.tournament.y2018.aug;

import java.util.Arrays;

public class Tour1308 {
  int summaryProficiency(int[] a, int n, int m) {
    Arrays.sort(a);
    int sum = 0;
    int count = 0;
    for (int i = a.length - 1; i >= 0; i--) {
      if (count == n)
        break;
      if (a[i] >= m) {
        sum += a[i];
        count++;
      }
    }
    return sum;
  }

  String reduceString(String inputString) {
    while (inputString.length() > 0
        && inputString.charAt(0) == inputString.charAt(inputString.length() - 1)) {
      if (inputString.length() == 1)
        return "";
      inputString = inputString.substring(1, inputString.length() - 1);
    }
    return inputString;
  }

  int digitSum(int n) {
    String s = Integer.toBinaryString(n);
    int c = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        c++;
      }
    }
    return c;
  }

  int sumBelowBound(int bound) {
    int n = 1, s = 0;
    while (s + n <= bound) {
      s += n;
      n++;
    }
    return n - 1;
  }

  int candles(int candlesNumber, int makeNew) {
    int count = 0, leftovers = 0;
    while (count == 0 || leftovers > 1) {
      if (leftovers != 0) {
        candlesNumber = leftovers / makeNew;
        leftovers = leftovers % makeNew;
      }
      count += candlesNumber;
      leftovers += candlesNumber;
    }
    return count;
  }

  public static void main(String[] args) {
    Tour1308 t = new Tour1308();
    int[] x = {4, 2, 3, 6, 2, 5, 4};
  }
}
