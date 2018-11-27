package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tour1018 {
  int ballsDistribution(int colors, int ballsPerColor, int boxSize) {
    int cur = 0, cap = boxSize, res = 0;

    for (int i = 0; i < colors; i++) {
      int start = cur;
      for (int j = 0; j < ballsPerColor; j++) {
        cap--;
        if (cap == 0) {
          cur++;
          cap = boxSize;
        }
      }

      if (start < cur && cap < boxSize || start + 1 < cur)
        res++;
    }
    return res;
  }

  boolean isSkewSymmetricMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] != -matrix[j][i])
          return false;
      }
    }
    return true;
  }

  boolean tennisSet(int score1, int score2) {
    int min = 0, max = 0;
    if (score1 < score2) {
      min = score1;
      max = score2;
    } else {
      min = score2;
      max = score1;
    }
    if (max == 6 && min < 5)
      return true;
    if (max == 7 && min < 7 && min >= 5)
      return true;
    return false;
  }

  int digitsProduct(int product) {
    ArrayList<Integer> answerDigits = new ArrayList<>();
    int answer = 0;

    if (product == 0) {
      return 10;
    }

    if (product == 1) {
      return 1;
    }

    for (int divisor = 9; divisor > 1; divisor--) {
      while (product % divisor == 0) {
        product /= divisor;
        answerDigits.add(divisor);
      }
    }

    if (product > 1) {
      return -1;
    }

    for (int i = answerDigits.size() - 1; i >= 0; i--) {
      answer = 10 * answer + answerDigits.get(i);
    }
    return answer;
  }

  List<Integer> fibonacciSum(int n) {
    List<Integer> ls = new ArrayList<>();
    int x0 = 1;
    int x1 = 1;
    int x2 = 0;
    ls.add(x0);
    ls.add(x1);
    while (x2 < n) {
      x2 = x0 + x1;
      ls.add(x2);
      x0 = x1;
      x1 = x2;
    }
    List<Integer> lsSum = new ArrayList<>();
    for (int i = ls.size() - 1; i >= 0; i--) {
      int x = ls.get(i);
      if (n >= x) {
        n -= x;
        lsSum.add(x);
      }
      if (n == 0)
        break;
    }
    List<Integer> lsResult = new ArrayList<>();
    for (int i = lsSum.size() - 1; i >= 0; i--) {
      lsResult.add(lsSum.get(i));
    }
    return lsResult;
  }

  boolean isOneSwapEnough(String inputString) {
    if (inputString.length() == 1)
      return true;
    char[] c = inputString.toCharArray();
    for (int i = 0; i < inputString.length() - 1; i++) {
      for (int j = i + 1; j < inputString.length(); j++) {
        swap(c, i, j);
        if (isPalindrome(c)) {
          return true;
        } else {
          swap(c, i, j);
        }
      }
    }
    return false;
  }

  boolean isPalindrome(char[] s) {
    int L = s.length;
    for (int i = 0; i <= L / 2; i++) {
      if (s[i] != s[L - 1 - i])
        return false;
    }
    return true;
  }

  void swap(char[] chars, int i, int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

  public static void main(String[] args) {
    Tour1018 t = new Tour1018();
    int[] values = {3, 2, 1};
    int k = IntStream.of(values).reduce(1, (a, b) -> a * b);
    System.out.println(k);
  }
}
