package tiendm.codefight.tournament.nov;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1113 {
  boolean robotWalk(int[] a) {
    int minX = 0;
    int minY = -1;
    int maxX = Integer.MAX_VALUE;
    int maxY = Integer.MAX_VALUE;

    int x = 0;
    int y = 0;

    for (int i = 0; i < a.length; i++) {
      switch (i % 4) {

        case 0:
          y += a[i];
          if (y >= maxY) {
            return true;
          }
          maxY = y;
          break;

        case 1:
          x += a[i];
          if (x >= maxX) {
            return true;
          }
          maxX = x;
          break;

        case 2:
          y -= a[i];
          if (y <= minY) {
            return true;
          }
          minY = y;
          break;

        case 3:
          x -= a[i];
          if (x <= minX) {
            return true;
          }
          minX = x;
          break;
      }
    }

    return false;
  }

  String getMonthName(int mo) {
    String[] months =
        {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    if (mo < 1 || mo > 12)
      return "invalid month";
    return months[mo - 1];
  }

  int[] theJanitor(String word) {

    int[] left = new int[26], right = new int[26];
    boolean[] was = new boolean[26];

    for (int i = 0; i < word.length(); i++) {
      int c = word.charAt(i) - 'a';
      if (!was[c]) {
        left[c] = i;
        was[c] = true;
      }
      right[c] = i;
    }

    int[] ans = new int[26];
    for (int i = 0; i < 26; i++) {
      ans[i] = was[i] ? right[i] - left[i] + 1 : 0;
    }
    return ans;
  }

  ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {

    for (int i = permutation.size() - 2; i >= 0; i--) {
      if (permutation.get(i) < permutation.get(i + 1)) {
        int index = i + 1, t = permutation.get(i);
        for (int j = i + 1; j < permutation.size(); j++) {
          if (t < permutation.get(j)) {
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

  int deleteDigit(int n) {
    int answer = 0;
    ArrayList<Integer> digits = new ArrayList<>();
    while (n != 0) {
      digits.add(n % 10);
      n /= 10;
    }
    int number = 0;
    for (int deletedIndex = 0; deletedIndex < digits.size(); deletedIndex++) {
      number = 0;
      for (int i = digits.size() - 1; i >= 0; i--) {
        if (i != deletedIndex) {
          number = number * 10 + digits.get(i);
        }
      }
      answer = Math.max(number, answer);
    }
    return answer;
  }

  String reflectString(String inputString) {

    StringBuilder result = new StringBuilder();
    for (int i = 0; i < inputString.length(); i++) {
      int order = (int) inputString.charAt(i) - (int) 'a', reflectedCharCode = (char) ('z' - order);
      result.append((char) reflectedCharCode);
    }

    return result.toString();
  }

  boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    return Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)
        && Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight);
  }

  public static void main(String[] args) {
    Tour1113 t = new Tour1113();
    int[] values = {1, 6, 7};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t.deleteDigit(152));
  }
}
