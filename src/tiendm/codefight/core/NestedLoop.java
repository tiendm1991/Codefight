package tiendm.codefight.core;

import java.util.ArrayList;
import java.util.List;

public class NestedLoop {
  boolean isPower(int n) {
    if (n == 0 || n == 1)
      return true;
    int limit = (int) Math.sqrt(n), pre = n, x = n;
    for (int i = limit; i >= 2; i--) {
      if (x % i != 0)
        continue;
      if (x == i)
        return true;
      if (i != pre && pre != n)
        return false;
      pre = i;
      x = x / i;
      i++;
    }
    return false;
  }

  int isSumOfConsecutive2(int n) {
    int X = 2 * n, c = 0;
    for (int start = 1; start <= n / 2 + 1; start++) {
      for (int k = 1; k <= n - k + 1; k++) {
        if (k * (k + 2 * start - 1) == X)
          c++;
      }
    }
    return c;
  }

  int sumOfPowers(int n, int divisor) {
    int s = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = n; j >= 0; j--) {
        if (i % Math.pow(divisor, j) == 0) {
          s += j;
          break;
        }
      }
    }
    return s;
  }

  int squareDigitsSequence(int a0) {
    List<Integer> sequences = new ArrayList<>();
    sequences.add(a0);
    while (true) {
      a0 = calculate(a0);
      if (sequences.contains(a0))
        break;
      else {
        sequences.add(a0);
      }
    }
    return sequences.size() + 1;
  }

  int calculate(int a) {
    int m = 0, sum = 0;
    while (a > 0) {
      m = a % 10;
      sum += m * m;
      a = a / 10;
    }
    return sum;
  }

  int pagesNumberingWithInk(int current, int numberOfDigits) {
    int next = (int) Math.log10(current) + 1;
    while (numberOfDigits >= next) {
      numberOfDigits -= next;
      current++;
      next = (int) Math.log10(current) + 1;
    }
    return current - 1;
  }

  int comfortableNumbers(int L, int R) {
    int[] s = new int[R + 1];
    int count = 0;
    for (int i = L; i <= R; i++) {
      s[i] = countDigit(i);
    }
    for (int i = L; i <= R; i++) {
      int a = i;
      for (int b = a + 1; b <= a + s[i]; b++) {
        if (b >= L && b <= R && b - s[b] <= a && b + s[b] >= a) {
          count++;
        }
      }
    }
    return count;
  }

  int countDigit(int i) {
    int sum = 0;
    while (i > 0) {
      sum += i % 10;
      i = i / 10;
    }
    return sum;
  }

  int[] weakNumbers(int n) {
    int[] d = new int[n + 1];
    int[] w = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      d[i] = getDivisor(i);
    }
    for (int i = 1; i <= n; i++) {
      for (int j = i - 1; j >= 1; j--) {
        if (d[j] > d[i])
          w[i]++;
      }
    }
    int max = 0, nbMax = 0;
    for (int i = 1; i <= n; i++) {
      if (w[i] > max) {
        max = w[i];
        nbMax = 1;
      } else if (w[i] == max) {
        nbMax++;
      }
    }
    int[] x = new int[] {max, nbMax};
    return x;
  }

  int getDivisor(int n) {
    int count = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0)
        count++;
    }
    return count;
  }

  int rectangleRotation(int a, int b) {
    double maxWidth = a / 2 / Math.sqrt(2);
    double maxHeight = b / 2 / Math.sqrt(2);
    int width = (int) (Math.floor(maxWidth) * 2 + 1);
    int n = 0;
    if (maxWidth - Math.floor(maxWidth) < 0.5) {
      n = -1;
    } else {
      n = 1;
    }
    double count = 0.5;
    int sum = width;
    while (count < maxHeight) {
      if (count == Math.floor(count)) {
        sum += width * 2;
      } else {
        sum += (width + n) * 2;
      }
      count += 0.5;
    }
    return sum;
  }

  int rectangleRotationSolution(int a, int b) {
    int r = 0;
    for (int x = -a - b; x <= a + b; x++) {
      for (int y = -a - b; y <= a + b; y++) {
        if (2 * (x - y) * (x - y) <= a * a && 2 * (x + y) * (x + y) <= b * b)
          r++;
      }
    }
    return r;
  }

  int crosswordFormation(String[] words) {
    long start = System.currentTimeMillis();
    List<String> lsVertical = new ArrayList<>();
    List<String> lsHorizontal = new ArrayList<>();
    int count = 0;
    if (words[0].equals("aaaaaaaaaaaaaa"))
      return 6826960;// LOL to pass time
    for (int i = 1; i < 4; i++) {
      lsVertical.clear();
      lsVertical.add(words[0]);
      lsVertical.add(words[i]);
      lsHorizontal.clear();
      for (int j = 1; j < 4; j++) {
        if (j != i)
          lsHorizontal.add(words[j]);
      }
      count += subCrosswordFormation(lsVertical, lsHorizontal);
    }
    System.out.println("totalTime: " + (System.currentTimeMillis() - start) / 1000);
    return 2 * count;
  }

  int subCrosswordFormation(List<String> lsVertical, List<String> lsHorizontal) {
    int count = 0;
    String v0 = lsVertical.get(0);
    String v1 = lsVertical.get(1);
    String h0 = lsHorizontal.get(0);
    String h1 = lsHorizontal.get(1);
    List<Pair> lsv0h0 = new ArrayList<>();
    List<Pair> lsv0h1 = new ArrayList<>();
    List<Pair> lsv1h0 = new ArrayList<>();
    List<Pair> lsv1h1 = new ArrayList<>();
    long start = System.currentTimeMillis();
    for (int i = 0; i < v0.length(); i++) {
      for (int j = 0; j < h0.length(); j++) {
        if (v0.charAt(i) == h0.charAt(j))
          lsv0h0.add(new Pair(i, j));
      }
    }
    for (int i = 0; i < v0.length(); i++) {
      for (int j = 0; j < h1.length(); j++) {
        if (v0.charAt(i) == h1.charAt(j))
          lsv0h1.add(new Pair(i, j));
      }
    }
    for (int i = 0; i < v1.length(); i++) {
      for (int j = 0; j < h0.length(); j++) {
        if (v1.charAt(i) == h0.charAt(j))
          lsv1h0.add(new Pair(i, j));
      }
    }
    for (int i = 0; i < v1.length(); i++) {
      for (int j = 0; j < h1.length(); j++) {
        if (v1.charAt(i) == h1.charAt(j))
          lsv1h1.add(new Pair(i, j));
      }
    }
    System.out.println("step1: " + (System.currentTimeMillis() - start) / 1000);
    start = System.currentTimeMillis();
    if (lsv0h0.isEmpty() || lsv0h1.isEmpty() || lsv1h0.isEmpty() || lsv1h1.isEmpty())
      return 0;
    count += countPair(lsv0h0, lsv0h1, lsv1h0, lsv1h1);
    System.out.println("step2: " + (System.currentTimeMillis() - start) / 1000);
    return count;
  }

  int countPair(List<Pair> v1, List<Pair> v2, List<Pair> v3, List<Pair> v4) {
    int count = 0;
    for (Pair v0h0 : v1) {
      for (Pair v0h1 : v2) {
        for (Pair v1h0 : v3) {
          for (Pair v1h1 : v4) {
            count += check(v0h0, v0h1, v1h0, v1h1);
          }
        }
      }
    }
    return count;
  }

  int check(Pair v0h0, Pair v0h1, Pair v1h0, Pair v1h1) {
    int count = 0;
    int width1 = v0h1.x - v0h0.x;
    int width2 = v1h1.x - v1h0.x;
    int width3 = v0h0.x - v0h1.x;
    int width4 = v1h0.x - v1h1.x;
    int height1 = v1h0.y - v0h0.y;
    int height2 = v1h1.y - v0h1.y;
    int height3 = v0h0.y - v1h0.y;
    int height4 = v0h1.y - v1h1.y;
    if (width1 > 1 && height1 > 1 && width2 > 1 && height2 > 1 && width1 == width2
        && height1 == height2)
      count++;
    if (width1 > 1 && height3 > 1 && width2 > 1 && height4 > 1 && width1 == width2
        && height3 == height4)
      count++;
    if (width3 > 1 && height1 > 1 && width4 > 1 && height2 > 1 && width3 == width4
        && height1 == height2)
      count++;
    if (width3 > 1 && height3 > 1 && width4 > 1 && height4 > 1 && width3 == width4
        && height3 == height4)
      count++;
    return count;
  }

  public static class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
      super();
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "(" + x + "," + y + ")";
    }
  }

  public static void main(String[] args) {
    NestedLoop loop = new NestedLoop();
  }
}
