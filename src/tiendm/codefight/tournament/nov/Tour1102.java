package tiendm.codefight.tournament.nov;

import java.util.ArrayList;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1102 {
  int commonPoints(int l1, int r1, int l2, int r2) {
    int result = Math.min(r1, r2) - Math.max(l1, l2) - 1;
    if (result < 0) {
      return 0;
    }
    return result;
  }

  int absoluteValuesSumMinimization(int[] a) {

    int indexOfMinimum = -1;
    int minimalSum = Integer.MAX_VALUE;

    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = 0; j < a.length; j++) {
        sum += Math.abs(a[j] - a[i]);
      }
      if (sum < minimalSum) {
        minimalSum = sum;
        indexOfMinimum = i;
      }
    }

    return a[indexOfMinimum];
  }

  int countIncreasingSequences(int n, int k) {

    /*
     * vector dp (short for dynamic programming) is used for storing the interim values.
     */
    int[] line = new int[k + 1];
    int[][] dp = new int[n + 1][line.length];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) {
        for (int q = 0; q < j; q++) {
          dp[i][j] += dp[i - 1][q];
        }
      }
    }

    int sum = 0;
    for (int j = 1; j <= k; j++) {
      sum += dp[n][j];
    }

    return sum;
  }

  ArrayList<Integer> splitByValue(int k, ArrayList<Integer> elements) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < elements.size(); i++) {
      if (elements.get(i) < k) {
        result.add(elements.get(i));
      }
    }
    for (int i = 0; i < elements.size(); i++) {
      if (elements.get(i) >= k) {
        result.add(elements.get(i));
      }
    }
    return result;
  }

  int[] quickSort(int[] a, int l, int r) {

    if (l >= r) {
      return a;
    }

    int x = a[l];
    int i = l;
    int j = r;

    while (i <= j) {
      while (a[i] < x) {
        i++;
      }
      while (a[j] > x) {
        j--;
      }
      if (i <= j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        i++;
        j--;
      }
    }

    quickSort(a, l, j);
    quickSort(a, i, r);

    return a;
  }

  boolean areIsomorphic(int[][] array1, int[][] array2) {

    if (array1.length != array2.length) {
      return false;
    }

    for (int i = 0; i < array1.length; i++) {
      if (array1[i].length != array2[i].length) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Tour1102 t = new Tour1102();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
