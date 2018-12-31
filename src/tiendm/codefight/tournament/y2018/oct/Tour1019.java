package tiendm.codefight.tournament.y2018.oct;

public class Tour1019 {
  int maxSubmatrixSum(int[][] matrix, int n, int m) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i <= matrix.length - n; i++) {
      for (int j = 0; j <= matrix[0].length - m; j++) {
        int s = 0;
        for (int x = i; x < i + n; x++) {
          for (int y = j; y < j + m; y++) {
            s += matrix[x][y];
          }
        }
        if (s > max)
          max = s;
      }
    }
    return max;
  }

  int[] digitDifferenceSort(int[] a) {
    for (int i = 0; i < a.length - 1; i++) {
      for (int j = i; j < a.length; j++) {
        String x = a[i] + "";
        String y = a[j] + "";
        if (diff(x) >= diff(y))
          swap(a, i, j);
      }
    }
    return a;
  }

  private int diff(String s) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      int x = s.charAt(i) - '0';
      if (x < min)
        min = x;
      if (x > max)
        max = x;
    }
    return max - min;
  }

  private void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;

  }

  int deleteDigit(int n) {
    int max = 0;
    String s = n + "";
    for (int i = 1; i < s.length() - 1; i++) {
      int x = Integer.parseInt(s.substring(0, i) + s.substring(i + 1));
      if (x > max)
        max = x;
    }
    int f = Integer.parseInt(s.substring(0, s.length() - 1));
    int l = Integer.parseInt(s.substring(1));
    return Math.max(max, Math.max(f, l));
  }

  int[] directionOfReading(int[] numbers) {
    int L = numbers.length;
    int[][] arr = new int[L][L];
    for (int i = 0; i < L; i++) {
      int x = numbers[i];
      String s = x + "";
      int idx = L - 1;
      for (int j = s.length() - 1; j >= 0; j--) {
        arr[i][idx--] = s.charAt(j) - '0';
      }
    }
    int[] result = new int[L];
    for (int i = 0; i < L; i++) {
      String s = "";
      for (int j = 0; j < L; j++) {
        s += (arr[j][i] + "");
      }
      result[i] = Integer.parseInt(s);
    }
    return result;
  }

  String addDigits(int a, int b, int n) {
    String s = a + "";
    int max = (int) Math.pow(10, n);
    String format = "%0" + n + "d";
    for (int i = 1; i < max; i++) {
      String newStr = s + String.format(format, i);
      if (Integer.parseInt(newStr) % b == 0)
        return newStr;
    }
    return "";
  }

  String insertDashes(String inputString) {
    String s = "";
    boolean add = true;
    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) != ' ') {
        if (add) {
          s += "-";
        }
        s += inputString.charAt(i);
        add = true;
      } else {
        s += " ";
        add = false;
      }
    }
    return s.substring(1);
  }

  int rangeBitCount(int a, int b) {

    int ans = 0;
    for (int i = a; i <= b; i++) {
      int t = i;
      while (t != 0) {
        ans += t % 2;
        t /= 2;
      }
    }

    return ans;
  }

  boolean isIncreasingDigitsSequence(int n) {
    int x = n % 10;
    n /= 10;
    while (n > 0) {
      int y = n % 10;
      if (y >= x)
        return false;
      x = y;
      n /= 10;
    }
    return true;
  }

  int[] inversePermutation(int[] permutation) {
    int[] arr = new int[permutation.length];
    for (int i = 0; i < permutation.length; i++) {
      arr[permutation[i] - 1] = i + 1;
    }
    return arr;
  }

  public static void main(String[] args) {
    Tour1019 t = new Tour1019();
    int[] values = {1, 3, 4, 2};
    System.out.println(t.inversePermutation(values));
  }
}
