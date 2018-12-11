package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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

  int[] bfsDistancesUnweightedGraph(boolean[][] matrix, int startVertex) {

    boolean[] visited = new boolean[matrix.length];
    LinkedList<Integer> queue = new LinkedList<>();
    int[] distance = new int[matrix.length];

    visited[startVertex] = true;
    queue.add(startVertex);
    while (queue.size() != 0) {
      int currentVertex = queue.pop();
      visited[currentVertex] = true;
      for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
        if (matrix[currentVertex][nextVertex] && !visited[nextVertex]) {
          visited[nextVertex] = true;
          distance[nextVertex] = distance[currentVertex] + 1;
          queue.add(nextVertex);
        }
      }
    }

    return distance;
  }

  int kthDivisor(int n, int k) {
    int c = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0)
        c++;
      if (c == k)
        return i;
    }
    return -1;
  }

  int commonCharacterCount(String s1, String s2) {
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    int answer = 0;
    for (int i = 0; i < s1.length(); i++) {
      char ch = s1.charAt(i);
      map1.put(ch, map1.containsKey(ch) ? (map1.get(ch) + 1) : 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      map2.put(ch, map2.containsKey(ch) ? (map2.get(ch) + 1) : 1);
    }
    for (char ch = 'a'; ch <= 'z'; ch++) {
      try {
        answer += Math.min(map1.get(ch), map2.get(ch));
      } catch (NullPointerException e) {
      }
    }
    return answer;
  }

  int largestFullBinaryTree(int[] parent) {

    class Graph {
      ArrayList<Integer>[] edges;
      int maxBinTree;

      Graph(int[] parent) {
        maxBinTree = 1;
        edges = new ArrayList[parent.length];
        for (int i = 0; i < edges.length; i++) {
          edges[i] = new ArrayList();
        }
        for (int i = 1; i < parent.length; i++) {
          edges[parent[i]].add(i);
        }
      }

      int dfs(int v) {
        int firstMax = -1;
        int secondMax = -1;
        for (int u : edges[v]) {
          int curMax = dfs(u);
          if (curMax > firstMax) {
            secondMax = firstMax;
            firstMax = curMax;
          } else if (curMax > secondMax) {
            secondMax = curMax;
          }
        }
        if (secondMax == -1) {
          return 1;
        }
        int result = 1 + firstMax + secondMax;
        if (result > maxBinTree) {
          maxBinTree = result;
        }
        return result;
      }
    }

    Graph g = new Graph(parent);
    g.dfs(0);
    return g.maxBinTree;
  }

  int commonCharacterCount2(String s1, String s2) {
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    int answer = 0;
    for (int i = 0; i < s1.length(); i++) {
      char ch = s1.charAt(i);
      map1.put(ch, map1.containsKey(ch) ? (map1.get(ch) + 1) : 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      map2.put(ch, map2.containsKey(ch) ? (map2.get(ch) + 1) : 1);
    }
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (map1.containsKey(ch) && map2.containsKey(ch)) {
        answer += Math.min(map1.get(ch), map2.get(ch));
      }
    }
    return answer;
  }

  int pagesNumbering(int n) {

    int tenPower = 1, digitsPerPage = 1, result = 0;

    while (tenPower <= n) {
      result += tenPower * 9 * digitsPerPage;
      tenPower *= 10;
      digitsPerPage++;
    }
    result += (n - tenPower + 1) * (digitsPerPage - 1);

    return result;
  }

  boolean isMonotonous(int[] sequence) {
    if (sequence.length == 1) {
      return true;
    }
    int direction = sequence[1] - sequence[0];
    for (int i = 0; i < sequence.length - 1; i++) {
      if (direction * (sequence[i + 1] - sequence[i]) <= 0) {
        return false;
      }
    }
    return true;
  }

  int[] powersOfTwo(int n) {
    ArrayList<Integer> ans = new ArrayList<>();
    int cur = 1;
    while (n > 0) {
      if (n % 2 == 1) {
        ans.add(cur);
      }
      n /= 2;
      cur *= 2;
    }

    int[] a = new int[ans.size()];
    for (int i = 0; i < a.length; i++) {
      a[i] = ans.get(i);
    }

    return a;
  }

  int maxDivisor(int left, int right, int divisor) {

    for (int i = right; i >= left; i--) {
      if (i % divisor == 0) {
        return i;
      }
    }
    return -1;
  }

  String decipher(String cipher) {

    String result = "";
    for (int i = 0; i < cipher.length();) {
      int len;
      if (cipher.charAt(i) == '1') {
        len = 3;
      } else {
        len = 2;
      }
      int code = Integer.parseInt(cipher.substring(i, i + len));
      result += (char) code;
      i += len;
    }

    return result;
  }

  String[] isDivisibleBy6(String inputString) {

    int digitSum = 0;
    char leftBound = '0', rightBound = '9';
    ArrayList<String> answer = new ArrayList<>();
    char[] mask = inputString.toCharArray();
    int asteriskPos = -1;

    for (int i = 0; i < mask.length; i++) {
      if (leftBound <= mask[i] && mask[i] <= rightBound) {
        digitSum += mask[i] - leftBound;
      } else {
        asteriskPos = i;
      }
    }

    for (int i = 0; i < 10; i++) {
      if ((digitSum + i) % 3 == 0) {
        mask[asteriskPos] = (char) (i + '0');
        if ((mask[mask.length - 1] - leftBound) % 2 == 0) {
          answer.add(String.valueOf(mask));
        }
      }
    }

    return answer.toArray(new String[0]);
  }

  ArrayList<Integer> sortedIndices(ArrayList<Integer> a) {
    ArrayList<Integer> indices = new ArrayList<>();
    for (int i = 0; i < a.size(); i++) {
      indices.add(i);
    }
    for (int i = 0; i < a.size() - 1; i++) {
      for (int j = 0; j < a.size() - i - 1; j++) {
        if (a.get(indices.get(j)) > a.get(indices.get(j + 1))) {
          int tmp = indices.get(j + 1);
          indices.set(j + 1, indices.get(j));
          indices.set(j, tmp);
        }
      }
    }
    return indices;
  }

  int countDigitsInNumber(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      n /= 10;
    }
    return count;
  }

  String caesarBoxCipherEncoding(String inputString) {
    int n = (int) Math.sqrt(inputString.length());
    String ans = "";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        ans += inputString.charAt(j * n + i);
      }
    }

    return ans;
  }

  int[][] segmentSumsMatrix2(int[] inputArray) {

    int[][] answer = new int[inputArray.length][inputArray.length];

    for (int i = 0; i < inputArray.length; i++) {
      answer[i][i] = inputArray[i];
      for (int j = i + 1; j < inputArray.length; j++) {
        answer[i][j] = answer[i][j - 1] + inputArray[j];
      }
    }

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        answer[j][i] = answer[i][j - 1] + inputArray[j];
      }
    }

    return answer;
  }

  int firstMultiple2(int[] divisors, int start) {
    for (int i = start;; i++) {
      for (int x : divisors) {
        if (i % x == 0)
          return i;
      }
    }
  }

  public static void main(String[] args) {
    Tour1026 t = new Tour1026();
    int[] values = {2, 3, 4};
    System.out.println(t.firstMultiple2(values, 13));
  }
}
