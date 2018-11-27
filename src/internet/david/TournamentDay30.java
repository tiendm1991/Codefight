package internet.david;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Davit on 05/07/16.
 */
public class TournamentDay30 {

  private static boolean isUppercase(char symbol) {

    if ('A' <= symbol && symbol <= 'Z') {
      return true;
    }
    return false;
  }

  private static String whoseMove(String lastPlayer, boolean win) {
    if (lastPlayer == "white") {
      if (win) {
        return "white";
      } else {
        return "black";
      }
    } else {
      if (win) {
        return "black";
      } else {
        return "white";
      }
    }
  }

  private static boolean isSuspiciousRespondent(boolean ans1, boolean ans2, boolean ans3) {
    if (ans1 && ans2 && ans3)
      return true;
    else if (!ans1 && !ans2 && !ans3)
      return true;
    return false;
  }

  private static int differentValues(int[] A, int D) {

    int best = -1;
    for (int i = 0; i < A.length; i++) {
      for (int j = i + 1; j < A.length; j++) {
        int diff = Math.abs(A[j] - A[i]);
        if (diff <= D && best < diff) {
          best = diff;
        }
      }
    }

    return best;
  }

  private static int createAnagram(String s, String t) {

    int[] cnt1 = new int[26];
    int[] cnt2 = new int[26];
    for (int i = 0; i < s.length(); i++) {
      cnt1[s.charAt(i) - 'A']++;
      cnt2[t.charAt(i) - 'A']++;
    }

    int ans = 0;
    for (int i = 0; i < 26; i++) {
      ans += Math.abs(cnt1[i] - cnt2[i]);
    }

    return ans / 2;
  }

  int calculationsWithCoins(int a, int b, int c) {
    Set<Integer> set = new HashSet<>();
    set.add(a);
    set.add(b);
    set.add(c);
    set.add(a + b);
    set.add(a + c);
    set.add(b + c);
    set.add(a + b + c);
    return set.size();
  }

  int differentDigitsNumberSearch(int[] inputArray) {

    for (int i = 0; i < inputArray.length; i++) {
      int cur = inputArray[i];
      boolean[] was = new boolean[10];
      boolean ok = true;
      while (cur > 0) {
        if (was[cur % 10]) {
          ok = false;
          break;
        }
        was[cur % 10] = true;
        cur /= 10;
      }
      if (ok) {
        return inputArray[i];
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    // System.out.println(whoseMove("black", false));
    // System.out.println(differentValues(new int[]{3, 2, 1}, 2));
    System.out.println(createAnagram("AABAA", "BBAAA"));
  }

}
