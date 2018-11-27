package tiendm.codefight.tournament.nov;

import java.util.ArrayList;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1101 {
  ArrayList<String> generatePalindromes(String charactersSet) {

    class Helper {
      int N;
      char[] palindrome;
      int[] letterCnt;
      ArrayList<String> result = new ArrayList<>();

      Helper(String charactersSet) {
        N = charactersSet.length();
        palindrome = new char[N];
        letterCnt = new int[26];
        for (int i = 0; i < N; i++) {
          letterCnt[charactersSet.charAt(i) - 'a']++;
        }
        if (N % 2 == 1) {
          for (int i = 0; i < 26; i++) {
            if (letterCnt[i] % 2 == 1) {
              letterCnt[i]--;
              palindrome[N / 2] = (char) ('a' + i);
              break;
            }
          }
        }
      }

      void generate(int idx) {
        if (idx >= N / 2) {
          result.add(new String(palindrome));
          return;
        }
        for (int i = 0; i < 26; i++) {
          if (letterCnt[i] >= 2) {
            letterCnt[i] -= 2;
            palindrome[idx] = (char) ('a' + i);
            palindrome[N - idx - 1] = (char) ('a' + i);
            generate(idx + 1);
            letterCnt[i] += 2;
          }
        }
      }
    }
    Helper h = new Helper(charactersSet);

    h.generate(0);
    return h.result;
  }

  int equidistantTriples(int[] coordinates) {

    int ans = 0;
    for (int i = 1; i < coordinates.length - 1; i++) {
      int left = i - 1;
      int right = i + 1;
      while (left >= 0 && right < coordinates.length) {
        int distL = coordinates[i] - coordinates[left];
        int distR = coordinates[right] - coordinates[i];
        if (distL == distR) {
          ans++;
          left--;
          right++;
        } else if (distL < distR) {
          left--;
        } else {
          right++;
        }
      }
    }

    return ans;
  }

  int countTriangles(int[] x, int[] y) {

    int result = 0;
    for (int i = 0; i < x.length; i++) {
      for (int j = i + 1; j < x.length; j++) {
        for (int k = j + 1; k < x.length; k++) {
          int doubleArea = (x[i] - x[j]) * (y[i] - y[k]) - (x[i] - x[k]) * (y[i] - y[j]);
          if (doubleArea != 0) {
            result++;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Tour1101 t = new Tour1101();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
