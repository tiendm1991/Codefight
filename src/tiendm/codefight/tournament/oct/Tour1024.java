package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tour1024 {
  int divisorsSubset(int[] subset, int n) {

    int res = 0;

    for (int i = 1; i <= n; i++) {
      boolean correct = true;
      for (int j = 0; j < subset.length; j++) {
        if (i % subset[j] != 0) {
          correct = false;
        }
      }
      if (correct) {
        res++;
      }
    }

    return res;
  }

  int[] setUnion(int[] a, int[] b) {

    List<Integer> c = new ArrayList<>();
    int pos_b = 0;

    Arrays.sort(a);
    Arrays.sort(b);

    for (int pos_a = 0; pos_a < a.length; pos_a++) {
      while (pos_b < b.length && a[pos_a] > b[pos_b]) {
        c.add(b[pos_b]);
        pos_b++;
      }
      c.add(a[pos_a]);
      if (pos_b < b.length && a[pos_a] == b[pos_b]) {
        pos_b++;
      }
    }
    while (pos_b < b.length) {
      c.add(b[pos_b]);
      pos_b++;
    }

    int[] res = new int[c.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = c.get(i);
    }

    return res;
  }

  int parkingCost(String timeIn, String timeOut) {
    int diff =
        Integer.parseInt(timeOut.substring(0, 2)) * 60 + Integer.parseInt(timeOut.substring(3))
            - Integer.parseInt(timeIn.substring(0, 2)) * 60 - Integer.parseInt(timeIn.substring(3));
    if (diff <= 30) {
      return 0;
    }
    if (diff <= 120) {
      return (diff - 21) / 10;
    }
    return 9 + ((diff - 111) / 10) * 2;
  }

  int factorialTrailingZeros(int n) {
    int result = 0;
    for (int i = 5; i <= n; i += 5) {
      int number = i;
      while (number % 5 == 0) {
        number /= 5;
        result++;
      }
    }
    return result;
  }

  boolean cyclicSequence(int[] sequence) {
    if (sequence.length == 1)
      return true;
    int cur = sequence[0];
    int i = 1;
    while (i < sequence.length && sequence[i] > cur) {
      cur = sequence[i];
      i++;
    }
    if (i == sequence.length)
      return true;
    for (int j = i + 1; j < sequence.length; j++) {
      if (sequence[j] < sequence[j - 1])
        return false;
    }
    if (sequence[0] - sequence[sequence.length - 1] != 1)
      return false;
    return true;
  }

  String alphabeticShift(String inputString) {
    StringBuilder chars = new StringBuilder();
    for (int i = 0; i < inputString.length(); i++) {
      int number = inputString.charAt(i) - 'a';
      number = (number + 1) % 26;
      chars.append((char) ('a' + number));
    }
    return chars.toString();
  }

  int axisAlignedCirclesBoundingBox(int[] x, int[] y, int[] r) {

    int minX = x[0] - r[0], maxX = x[0] + r[0], minY = y[0] - r[0], maxY = y[0] + r[0];

    for (int i = 1; i < x.length; i++) {
      minX = Math.min(x[i] - r[i], minX);
      maxX = Math.max(x[i] + r[i], maxX);
      minY = Math.min(y[i] - r[i], minY);
      maxY = Math.max(y[i] + r[i], maxY);
    }

    return (maxX - minX) * (maxY - minY);
  }

  int divisorsSuperset(int[] superset, int n) {

    class Helper {
      boolean isInSequence(int[] sequence, int elem) {
        for (int i = 0; i < sequence.length; i++) {
          if (sequence[i] == elem) {
            return true;
          }
        }
        return false;
      }
    };

    int res = 0;
    Helper h = new Helper();

    for (int i = 1; i <= n; i++) {
      boolean correct = true;
      for (int j = 2; j * j <= i; j++) {
        if (i % j == 0) {
          if (!h.isInSequence(superset, j) || !h.isInSequence(superset, i / j)) {
            correct = false;
            break;
          }
        }
      }
      if (correct) {
        res++;
      }
    }

    return res;
  }

  int countLineColorings(int points, int colors) {
    if (points == 1)
      return colors;
    if (colors == 1)
      return 1;
    return colors * countLineColorings(points - 1, colors - 1);
  }

  int boxPiles(int[] a) {

    Arrays.sort(a);
    boolean[] used = new boolean[a.length];
    int usedNum = 0;
    int answer = 0;
    while (usedNum < used.length) {
      int height = 0;
      for (int i = 0; i < a.length; i++) {
        if (height <= a[i] && !used[i]) {
          height++;
          used[i] = true;
          usedNum++;
        }
      }
      answer++;
    }

    return answer;
  }

  int[] mergeArrays(int[] a, int[] b) {

    int[] result = new int[a.length + b.length];
    int i, j;
    int k = 0;

    for (i = 0, j = 0; i < a.length && j < b.length;) {
      if (a[i] < b[j]) {
        result[k++] = a[i];
        i++;
      } else {
        result[k++] = b[j];
        j++;
      }
    }

    while (i < a.length) {
      result[k++] = a[i];
      i++;
    }

    while (j < b.length) {
      result[k++] = b[j];
      j++;
    }

    return result;
  }

  int[] fractionSum(int[] a, int[] b) {

    class Helper {
      int gcdEuclid(int a, int b) {
        if (a == 0) {
          return b;
        }
        return gcdEuclid(b % a, a);
      }
    }
    Helper h = new Helper();

    int[] c = {a[0] * b[1] + a[1] * b[0], a[1] * b[1]};
    int gcd = h.gcdEuclid(c[0], c[1]);

    c[0] /= gcd;
    c[1] /= gcd;

    return c;
  }

  ArrayList<Integer> extractEachKth(ArrayList<Integer> inputArray, int k) {

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < inputArray.size(); i++) {
      if ((i + 1) % k != 0) {
        result.add(inputArray.get(i));
      }
    }
    return result;
  }

  boolean higherVersion(String ver1, String ver2) {

    String[] a = ver1.split("\\.");
    String[] b = ver2.split("\\.");
    for (int i = 0; i < a.length; i++) {
      int cmp = Integer.parseInt(a[i]) - Integer.parseInt(b[i]);
      if (cmp > 0) {
        return true;
      } else if (cmp < 0) {
        return false;
      }
    }

    return false;
  }

  int maxZeros(int n) {
    int answer = 0, maxZeros = 0;
    for (int k = 2; k <= n; k++) {
      int numZeros = 0, value = n;
      while (value != 0) {
        if (value % k == 0) {
          numZeros++;
        }
        value /= k;
      }
      if (numZeros > maxZeros) {
        maxZeros = numZeros;
        answer = k;
      }
    }
    return answer;
  }

  int axisAlignedBoundingBox(int[] x, int[] y) {

    int minX = x[0], maxX = x[0], minY = y[0], maxY = y[0];

    for (int i = 1; i < x.length; i++) {
      minX = Math.min(x[i], minX);
      maxX = Math.max(x[i], maxX);
      minY = Math.min(y[i], minY);
      maxY = Math.max(y[i], maxY);
    }

    return (maxX - minX) * (maxY - minY);
  }

  boolean isCaseInsensitivePalindrome(String inputString) {

    for (int i = 0; i < inputString.length() / 2; i++) {
      char[] c = {inputString.charAt(i), inputString.charAt(inputString.length() - i - 1)};
      for (int j = 0; j < 2; j++) {
        if (c[j] >= 'A' && c[j] <= 'Z') {
          c[j] = (char) (c[j] + 'a' - 'A');
        }
      }
      if (c[0] != c[1]) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Tour1024 t = new Tour1024();
    int[] values = {6, 2, 3, 8};
    System.out.println(t.alphabeticShift("crazy"));
  }
}
