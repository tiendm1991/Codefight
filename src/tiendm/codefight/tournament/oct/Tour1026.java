package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Tour1026 {
  String deleteWhitespaces(String inputStr) {
    String s = "";
    for (int i = 0; i < inputStr.length(); i++) {
      char c = inputStr.charAt(i);
      if (c != ' ') {
        s += c + "";
      }
    }
    return s;
  }

  private static int differentValuesInMultiplicationTable(int n, int m) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        set.add((i + 1) * (j + 1));
      }
    }
    return set.size();
  }

  boolean bettingGame(int[] l) {

    int s = 0;
    for (int i = 0; i < l.length; i++) {
      s += l[i];
    }
    if (s == 0) {
      return false;
    }

    return s % l.length == 0;
  }

  int squareDigitsSequence(int a0) {

    int cur = a0;
    Set<Integer> was = new HashSet<>();

    while (!was.contains(cur)) {
      was.add(cur);
      int next = 0;
      while (cur > 0) {
        next += (cur % 10) * (cur % 10);
        cur /= 10;
      }
      cur = next;
    }

    return was.size() + 1;
  }

  String[] addBorder(String[] picture) {

    List<String> answer = new ArrayList<>();
    answer.add("");

    for (int i = 0; i < picture[0].length() + 2; i++) {
      answer.set(0, answer.get(0) + "*");
    }

    for (int i = 0; i < picture.length; i++) {
      answer.add("*");
      for (int j = 0; j < picture[i].length(); j++) {
        answer.set(i + 1, answer.get(i + 1) + picture[i].charAt(j));
      }
      answer.set(i + 1, answer.get(i + 1) + "*");
    }

    answer.add(answer.get(0));

    return answer.toArray(new String[picture.length + 2]);
  }

  int[] setDifference(int[] a, int[] b) {

    Arrays.sort(a);
    Arrays.sort(b);
    ArrayList<Integer> C = new ArrayList<>();

    int pos_b = 0;
    for (int pos_a = 0; pos_a < a.length; pos_a++) {
      while (pos_b < b.length && b[pos_b] < a[pos_a]) {
        pos_b++;
      }
      if (pos_b == b.length || a[pos_a] != b[pos_b]) {
        C.add(a[pos_a]);
      }
    }

    int[] res = new int[C.size()];
    for (int i = 0; i < res.length; i++) {
      res[i] = C.get(i);
    }

    return res;
  }

  int bfsComponentSize(boolean[][] matrix) {

    ArrayList<Boolean> visited = new ArrayList<>();
    LinkedList<Integer> queue = new LinkedList<>();
    int componentSize = 0;

    for (int i = 0; i < matrix.length; i++) {
      visited.add(false);
    }

    visited.set(1, true);
    queue.add(1);

    while (queue.size() > 0) {
      int currentVertex = queue.pop();
      visited.set(currentVertex, true);
      componentSize++;
      for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
        if (matrix[currentVertex][nextVertex] && !visited.get(nextVertex)) {
          visited.set(nextVertex, true);
          queue.add(nextVertex);
        }
      }
    }

    return componentSize;
  }

  public static void main(String[] args) {
    Tour1026 t = new Tour1026();
    int[] values = {6, 2, 3, 8};
    System.out.println(t.differentValuesInMultiplicationTable(3, 2));
  }
}
