package tiendm.codefight.tournament.y2018.dec;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1220 {
  int binarySearch(int[] inputArray, int searchElement) {

    int minIndex = -1;
    int maxIndex = inputArray.length;
    int currentIndex;
    int currentElement;

    while (minIndex < maxIndex - 1) {
      currentIndex = (minIndex + maxIndex) / 2;
      currentElement = inputArray[currentIndex];

      if (currentElement < searchElement) {
        minIndex = currentIndex;
      } else {
        maxIndex = currentIndex;
      }
    }

    if (maxIndex == inputArray.length || inputArray[maxIndex] != searchElement) {
      return -1;
    }
    return maxIndex;
  }

  ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {

    for (int i = permutation.size() - 2; i >= 0; i--) {
      if (permutation.get(i) < permutation.get(i + 1)) {
        int index = i + 1, t = permutation.get(i);
        for (int j = i + 1; j < permutation.size(); j++) {
          if (permutation.get(j) > t && permutation.get(j) < permutation.get(index)) {
            index = j;
          }
        }
        permutation.set(i, permutation.get(index));
        permutation.set(index, t);
        ArrayList<Integer> suffix = new ArrayList<>(permutation.subList(i + 1, permutation.size()));
        Collections.reverse(suffix);
        permutation.subList(i + 1, permutation.size()).clear();
        permutation.addAll(suffix);
        return permutation;
      }
    }

    Collections.sort(permutation);
    return permutation;
  }

  boolean patternMatching(String input, String pattern) {

    boolean[][] dp = new boolean[input.length() + 1][pattern.length() + 1];

    dp[0][0] = true;
    for (int i = 0; i <= input.length(); i++) {
      for (int j = 0; j < pattern.length(); j++) {
        if (!dp[i][j]) {
          continue;
        }
        if (i < input.length()
            && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
          dp[i + 1][j + 1] = true;
        }
        if (pattern.charAt(j) == '*') {
          for (int k = 0; i + k <= input.length(); k++) {
            dp[i + k][j + 1] = true;
          }
        }
      }
    }

    return dp[input.length()][pattern.length()];
  }

  int smallestUnusualNumber(String a) {
    if (a.indexOf('0') >= 0)
      return 0;
    int s = 0;
    int p = 1;
    for (int i = 0; i < a.length(); i++) {
      s = s + (a.charAt(i) - '0');
      p = p * (a.charAt(i) - '0');
      if (p > 1000000)
        return 10 - a.charAt(a.length() - 1) + '0';
    }
    if (s > p)
      return 0;
    else
      return 10 - a.charAt(a.length() - 1) + '0';
  }

  public static void main(String[] args) {
    Tour1220 t = new Tour1220();
    int[] values = {4, 3, 1, 1, 0, 0};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
