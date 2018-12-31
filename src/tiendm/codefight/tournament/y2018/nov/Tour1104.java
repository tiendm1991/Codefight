package tiendm.codefight.tournament.y2018.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1104 {
  boolean increaseNumberRoundness(int n) {

    boolean gotToSignificant = false;
    while (n > 0) {
      if (n % 10 == 0 && gotToSignificant) {
        return true;
      } else if (n % 10 != 0) {
        gotToSignificant = true;
      }
      n /= 10;
    }

    return false;
  }

  int halvingSum(int n) {
    int sum = 0;
    for (int i = n; i > 0; i /= 2) {
      sum += i;
    }
    return sum;
  }

  int maximizeNumberRoundness(int n) {
    String s = n + "";
    int i = 0, j = s.length() - 1;
    int result = 0;
    while (i < j) {
      while (i < j && s.charAt(i) != '0') {
        i++;
      }
      while (i < j && s.charAt(j) == '0') {
        j--;
      }
      if (i < j) {
        result++;
        i++;
        j--;
      }
    }
    return result;
  }

  boolean rightTriangle(int[] sides) {

    class Helper {
      int sqr(int value) {
        return value * value;
      }
    }
    Helper h = new Helper();

    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(sides[0], sides[1], sides[2]));
    Collections.sort(list);
    if (h.sqr(list.get(0)) + h.sqr(list.get(1)) == h.sqr(list.get(2))) {
      return true;
    }
    return false;
  }

  int sumOfCoprimes(int m) {

    int ans = 0;
    for (int p = 2; p <= m; p++) {
      int a = p;
      int b = m;
      while (a > 0) {
        int tmp = b % a;
        b = a;
        a = tmp;
      }

      if (b == 1) {
        ans += p;
      }
    }

    return ans;
  }

  int hailstoneSequence(int n) {
    int s = 0;
    while (n > 1) {
      if (n % 2 == 1) {
        n = n * 3 + 1;
      } else {
        n /= 2;
      }
      s++;
    }
    return s;
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

  int arrayKthGreatestQuick(int[] inputArray, int k) {

    class Helper {
      int[] listToArray(List<Integer> data) {
        int[] res = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
          res[i] = data.get(i);
        }
        return res;
      }
    };

    int pos = (new Random()).nextInt(inputArray.length);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    if (inputArray.length == 1) {
      return inputArray[0];
    }

    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] < inputArray[pos])
        left.add(inputArray[i]);
      else
        right.add(inputArray[i]);
    }

    Helper h = new Helper();

    if (right.size() >= k) {
      return arrayKthGreatestQuick(h.listToArray(right), k);
    }
    return arrayKthGreatestQuick(h.listToArray(left), k - right.size());
  }

  int differentValuesInMultiplicationTable(int n, int m) {
    int result = 0;
    for (int value = 1; value <= n * m; value++) {
      for (int i = 1; i <= Math.min(n, m); i++) {
        if (value % i == 0 && value / i <= Math.max(n, m)) {
          result++;
          break;
        }
      }
    }
    return result;
  }

  int differentSubstringsTrie(String inputString) {

    class Helper {
      void addNode(ArrayList<int[]> lastVersion) {
        int[] line = new int[26];
        lastVersion.add(line);
      }
    }
    Helper h = new Helper();

    int nodesCount = 1;
    ArrayList<int[]> trie = new ArrayList<>();
    h.addNode(trie);

    for (int i = 0; i < inputString.length(); i++) {
      int currentNode = 0;
      for (int j = i; j < inputString.length(); j++) {
        int symbol = inputString.charAt(j) - 'a';
        if (trie.get(currentNode)[symbol] == 0) {
          h.addNode(trie);
          trie.get(currentNode)[symbol] = nodesCount;
          nodesCount++;
        }
        currentNode = trie.get(currentNode)[symbol];
      }
    }

    return nodesCount - 1;
  }

  int chessBoardSquaresUnderQueenAttack(int a, int b) {

    class Helper {
      int a, b;

      int go(int x, int y, int dx, int dy) {
        if (x < 0 || x >= a || y < 0 || y >= b) {
          return 0;
        }
        return go(x + dx, y + dy, dx, dy) + 1;
      }
    };

    int res = 0;

    Helper h = new Helper();
    h.a = a;
    h.b = b;

    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        for (int dx = -1; dx <= 1; dx++) {
          for (int dy = -1; dy <= 1; dy++) {
            if (!(dx == 0 && dy == 0)) {
              res += h.go(i + dx, j + dy, dx, dy);
            }
          }
        }
      }
    }

    return res;
  }

  int evenNumbersBeforeFixed(int[] sequence, int fixedElement) {

    int result = 0;

    for (int i = 0; i < sequence.length; i++) {
      if (sequence[i] % 2 == 0 && sequence[i] != fixedElement) {
        result++;
      }
      if (sequence[i] == fixedElement) {
        return result;
      }
    }

    return -1;
  }

  boolean logicalNor(boolean a, boolean b) {
    return !(a || b);
  }

  int chartFix(int[] chart) {
    int max = 1;
    int[] dp = new int[chart.length];
    dp[0] = 1;
    for (int i = 1; i < dp.length; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (chart[i] > chart[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      if (dp[i] > max) {
        max = dp[i];
      }
    }
    return chart.length - max;
  }

  int sequencePeakElement(int[] sequence) {
    int left = 1;
    int right = sequence.length - 2;
    while (left < right) {
      int middle = (right + left) / 2;
      if (sequence[middle] > Math.max(sequence[middle - 1], sequence[middle + 1])) {
        left = right = middle;
        break;
      }
      if (sequence[middle - 1] < sequence[middle]) {
        left = middle + 1;
      } else {
        right = middle - 1;
      }
    }
    return sequence[left];
  }

  int sequenceElement(int[] a, int n) {

    final int MOD = (int) 1e5;
    List<Integer> seq = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      seq.add(a[i]);
    }

    int lastFive = a[0] * (int) 1e4 + a[1] * (int) 1e3 + a[2] * (int) 1e2 + a[3] * (int) 1e1
        + a[4] * (int) 1e0;
    Map<Integer, Integer> was = new HashMap<>();
    was.put(lastFive, 4);

    for (int i = 5;; i++) {
      seq.add((seq.get(i - 1) + seq.get(i - 2) + seq.get(i - 3) + seq.get(i - 4) + seq.get(i - 5))
          % 10);
      lastFive = (lastFive * 10 + seq.get(i)) % MOD;
      if (was.containsKey(lastFive)) {
        int last = was.get(lastFive);
        return seq.get(n % (i - last));
      } else {
        was.put(lastFive, i);
      }
    }
  }

  int crossingSum(int[][] matrix, int row, int column) {

    int result = 0;
    for (int i = 0; i < matrix.length; i++) {
      result += matrix[i][column];
    }
    for (int i = 0; i < matrix[0].length; i++) {
      result += matrix[row][i];
    }
    result -= matrix[row][column];

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
        digitSum += mask[i] - '0';
      } else {
        asteriskPos = i;
      }
    }

    for (int i = 0; i < 10; i++) {
      if ((digitSum + i) % 3 == 0) {
        mask[asteriskPos] = (char) (leftBound + i);
        if ((mask[mask.length - 1] - leftBound) % 2 == 0) {
          answer.add(String.valueOf(mask));
        }
      }
    }

    return answer.toArray(new String[0]);
  }

  String formatString(String input) {
    input = input.trim();
    String[] split = input.split(" ");
    StringBuilder formattedString = new StringBuilder();
    for (String s : split) {
      if (!s.equals(" ") && !s.equals("")) {
        formattedString.append(" ").append(s.trim());
      }
    }
    return formattedString.substring(1).toString();
  }

  String formatString2(String input) {
    input = input.trim();
    String[] split = input.split(" ");
    return Arrays.asList(split).stream().filter(x -> !x.equals(""))
        .collect(Collectors.joining(" "));
  }

  boolean regularBracketSequence(String sequence) {
    char[] chars = sequence.toCharArray();
    Stack<Character> s = new Stack<>();
    for (char c : chars) {
      if (c == '(') {
        s.push(c);
      } else if (c == ')') {
        if (s.isEmpty())
          return false;
        s.pop();
      }
    }
    return s.isEmpty();
  }

  int smallestNumber(int n) {
    return (int) Math.pow(10, n - 1);
  }

  boolean isSumOfConsecutive(int n) {
    int result = 0;
    for (int start = 1; start < n; start++) {
      int number = n, subtrahend = start;
      while (number > 0) {
        number -= subtrahend;
        subtrahend++;
      }
      if (number == 0) {
        return true;
      }
    }
    return false;
  }

  int countIncreasingSequences(int n, int k) {
    if (n == 0 || n == k)
      return 1;
    if (n == 1 || n == k - 1)
      return k;
    return countIncreasingSequences(n - 1, k - 1) + countIncreasingSequences(n, k - 1);
  }

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

  boolean checkEqualFrequency(int[] inputArray) {

    int numberOfEqual = 1;

    Arrays.sort(inputArray);

    while (numberOfEqual < inputArray.length
        && inputArray[numberOfEqual - 1] == inputArray[numberOfEqual]) {
      numberOfEqual++;
    }

    if (inputArray.length % numberOfEqual != 0) {
      return false;
    }

    for (int i = 0; i < inputArray.length; i += numberOfEqual) {
      if (i != 0 && inputArray[i] == inputArray[i - 1]) {
        return false;
      }
      for (int j = i + 1; j < i + numberOfEqual; j++) {
        if (inputArray[j] != inputArray[j - 1]) {
          return false;
        }
      }
    }

    return true;
  }

  String[] allLongestStrings(String[] inputArray) {

    ArrayList<String> answer = new ArrayList<>(Arrays.asList(inputArray[0]));
    for (int i = 1; i < inputArray.length; i++) {
      if (inputArray[i].length() == answer.get(0).length()) {
        answer.add(inputArray[i]);
      }
      if (inputArray[i].length() > answer.get(0).length()) {
        answer = new ArrayList<>(Arrays.asList(inputArray[i]));
      }
    }
    return answer.toArray(new String[0]);
  }

  int[] powersOfTwo(int n) {

    ArrayList<Integer> ans = new ArrayList<>();
    int cur = 1;
    while (n > 0) {
      if (n % 2 == 1) {
        ans.add(cur);
      }
      cur *= 2;
      n /= 2;
    }

    int[] a = new int[ans.size()];
    for (int i = 0; i < a.length; i++) {
      a[i] = ans.get(i);
    }

    return a;
  }

  int largestNumber(int n) {

    int res = 0;

    for (int i = 1; i <= n; i++) {
      res = res * 10 + 9;
    }

    return res;
  }

  int[] threeAndFour(int n) {
    ArrayList<Integer> result = new ArrayList<>();
    for (int counter = 0; counter < n; counter++) {
      if (counter % 3 == 0 && counter % 4 == 0)
        result.add(counter);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args) {
    Tour1104 t = new Tour1104();
    int[] values = {3, 2, 6, 4, 5, 1, 7};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    String[] split = " abc   a aa  a a ".split(" ");
    System.out.println(t.chartFix(values));
  }
}
