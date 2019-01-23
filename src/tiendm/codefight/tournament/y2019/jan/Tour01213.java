package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tour01213 {
  int numberOfTriangles(int[] sticks) {
    int res = 0;
    for (int i = 0; i < sticks.length; i++) {
      int k = i + 2;
      for (int j = i + 1; j < sticks.length; j++) {
        while (k < sticks.length && sticks[k] < sticks[i] + sticks[j]) {
          k++;
        }
        res += k - j - 1;
      }
    }
    return res;
  }


  String[] unusualLexOrder(String[] words) {
    List<String> reverse = Stream.of(words).map(e -> new StringBuilder(e).reverse().toString())
        .collect(Collectors.toList());
    Collections.sort(reverse);
    reverse = reverse.stream().map(e -> new StringBuilder(e).reverse().toString())
        .collect(Collectors.toList());
    return reverse.toArray(new String[reverse.size()]);
  }

  int kStepMaximization(int n, int k) {
    if (k <= 0) {
      return n;
    }
    int a = kStepMaximization(n + 1, k - 1);
    int b = kStepMaximization(n * 2, k - 1);
    int c = kStepMaximization(rotate(n), k - 1);
    return Math.max(Math.max(a, b), c);
  }

  int rotate(int n) {
    int result = 0;
    while (n > 0) {
      result = result * 10 + rotateDigit(n % 10);
      n /= 10;
    }
    return result;
  }

  int rotateDigit(int x) {
    switch (x) {
      case 0:
        return 0;
      case 1:
        return 1;
      case 2:
        return 2;
      case 5:
        return 5;
      case 6:
        return 9;
      case 8:
        return 8;
      case 9:
        return 6;
      default:
        return -1;
    }
  }

  List<Integer> zFunctionNaive(String s) {
    List<Integer> ls = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      ls.add(0);
      for (int j = i; j < s.length(); j++) {
        if (s.charAt(j) == s.charAt(ls.get(i))) {
          ls.set(i, ls.get(i) + 1);
        } else {
          break;
        }
      }
    }
    return ls;
  }

  public static void main(String[] args) {
    Tour01213 t = new Tour01213();
    System.out.println(t.kStepMaximization(0, 3));
  }
}
