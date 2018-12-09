package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tour1022 {
  List<Integer> makeArrayConsecutive(int[] sequence) {
    Arrays.sort(sequence);
    List<Integer> ls = new ArrayList<>();
    for (int i = sequence[0]; i < sequence[sequence.length - 1]; i++) {
      if (indexOf(sequence, i) == -1) {
        ls.add(i);
      }
    }
    return ls;
  }

  int indexOf(int[] values, int check) {
    for (int i = 0; i < values.length; i++) {
      if (values[i] == check) {
        return i;
      }
    }
    return -1;
  }

  int howManySundays(int n, String startDay) {
    Map<String, Integer> days = new HashMap<>();
    days.put("Sunday", 0);
    days.put("Monday", 1);
    days.put("Tuesday", 2);
    days.put("Wednesday", 3);
    days.put("Thursday", 4);
    days.put("Friday", 5);
    days.put("Saturday", 6);
    int start = days.get(startDay);
    return (start + n) / 7;
  }

  int factorizedGCD(int[] a, int[] b) {
    int j = 0, result = 1;
    for (int i = 0; i < a.length; i++) {
      while (j < b.length && a[i] > b[j]) {
        j++;
      }
      if (j < b.length && a[i] == b[j]) {
        result *= a[i];
        j++;
      }
    }
    return result;
  }

  String longestDigitsPrefix(String inputString) {
    String s = "";
    for (int i = 0; i < inputString.length(); i++) {
      char c = inputString.charAt(i);
      if (c >= '0' && c <= '9') {
        s += c + "";
      } else {
        return s;
      }
    }
    return s;
  }

  int arrayMode(int[] sequence) {
    Arrays.sort(sequence);
    int L = sequence.length;
    int[] modes = new int[sequence[L - 1] + 1];
    for (int i = 0; i < L; i++) {
      modes[sequence[i]]++;
    }
    int max = 0, idx = 0;
    for (int i = 0; i < modes.length; i++) {
      if (modes[i] > max) {
        max = modes[i];
        idx = i;
      }
    }
    return idx;
  }

  String whoseMove(String lastPlayer, boolean win) {
    if (lastPlayer.equals("black")) {
      if (win) {
        return "black";
      } else {
        return "white";
      }
    }
    if (!win) {
      return "black";
    } else {
      return "white";
    }
  }

  String addDigits(int a, int b, int n) {

    int rem = a % b;

    StringBuilder result = new StringBuilder();
    result.append(a);

    for (int i = 0; i < n; i++) {
      int best = -1;
      for (int digit = 9; digit >= 0; digit--) {
        if ((rem * 10 + digit) % b == 0) {
          best = digit;
          break;
        }
      }
      if (best == -1) {
        break;
      }
      result.append(best);
      rem = (rem * 10 + best) % b;
    }

    return result.toString();
  }

  int firstMultiple(int[] divisors, int start) {

    for (int answer = start;; answer++) {
      boolean correct = true;
      for (int i = 0; i < divisors.length; i++) {
        if (answer % divisors[i] != 0) {
          correct = false;
        }
      }
      if (correct) {
        return answer;
      }
    }
  }

  int rectanglesIntersection(int[] a, int[] b, int[] c, int[] d) {

    int[] intersection = new int[2];

    for (int i = 0; i < 2; i++) {
      if (a[i] > b[i]) {
        int t = a[i];
        a[i] = b[i];
        b[i] = t;
      }
      if (c[i] > d[i]) {
        int t = c[i];
        c[i] = d[i];
        d[i] = t;
      }
      if (b[i] < c[i] || d[i] < a[i]) {
        return 0;
      }
      intersection[i] = Math.min(b[i], d[i]) - Math.max(a[i], c[i]);
    }

    return intersection[0] * intersection[1];
  }

  int[] fractionSubtraction(int[] a, int[] b) {
    int[] result = new int[2];
    result[0] = a[0] * b[1] - a[1] * b[0];
    result[1] = a[1] * b[1];
    int x = result[0];
    if (x < 0)
      x = -x;
    int g = gcd(x, result[1]);
    x /= g;
    result[1] /= g;
    if (result[0] < 0)
      result[0] = -x;
    else
      result[0] = x;
    return result;
  }

  int gcd(int a, int b) {
    while (a % b != 0) {
      int tmp = b;
      b = a % b;
      a = tmp;
    }
    return b;
  }

  int factorialTrailingZeros(int n) {
    int two = 0, five = 0;
    for (int i = 2; i <= n; i++) {

      int ci = i;
      while (ci % 2 == 0) {
        ci /= 2;
        two++;
      }
      while (ci % 5 == 0) {
        ci /= 5;
        five++;
      }
    }
    return Math.min(two, five);
  }

  boolean isInsideTheCircle(int xa, int ya, int xc, int yc, int rc) {
    int dist = (xa - xc) * (xa - xc) + (ya - yc) * (ya - yc);
    rc *= rc;
    if (dist < rc) {
      return true;
    }
    return false;
  }

  int[] prefixSums(int[] a) {

    ArrayList<Integer> b = new ArrayList<>();
    b.add(a[0]);
    for (int i = 1; i < a.length; i++) {
      b.add(b.get(i - 1) + a[i]);
    }

    int[] c = new int[b.size()];
    for (int i = 0; i < c.length; ++i) {
      c[i] = b.get(i);
    }

    return c;
  }

  int[][] spiralNumbers(int n) {
    int[][] ans = new int[n][];
    for (int i = 0; i < n; i++)
      ans[i] = new int[n];

    int p = 1, r = 0;
    for (; n > 0; n -= 2) {
      for (int a = 0; a < n; a++)
        ans[r][a + r] = p++;
      for (int b = r + 1; b < n + r; b++)
        ans[b][n - 1 + r] = p++;
      for (int c = n - 2 + r; c >= r; c--)
        ans[n - 1 + r][c] = p++;
      for (int d = n - 2 + r; d > r; d--)
        ans[d][r] = p++;
      r++;
    }
    return ans;
  }

  int[] primeFactors(int n) {
    ArrayList<Integer> factors = new ArrayList<>();
    int divisor = 2;

    while (n >= 2) {
      if (n % divisor == 0) {
        factors.add(divisor);
        n /= divisor;
      } else {
        divisor++;
      }
    }

    int[] ans = new int[factors.size()];
    for (int i = 0; i < ans.length; ++i) {
      ans[i] = factors.get(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    Tour1022 t = new Tour1022();
    int[] values = {6, 2, 3, 8};
    System.out.println(t.makeArrayConsecutive(values));
  }
}
