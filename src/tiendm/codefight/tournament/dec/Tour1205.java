package tiendm.codefight.tournament.dec;

import java.util.Arrays;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1205 {
  boolean isInfiniteProcess(int a, int b) {
    return a > b || (b - a) % 2 == 1;
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

  public static void main(String[] args) {
    Tour1205 t = new Tour1205();
    int[] values = {4, 3, 1, 1, 0, 0};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t.boxPiles(values));
  }
}
