package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class InterviewDfsBfs {

  static class Tree<T> {
    Tree(T x) {
      value = x;
    }

    T value;
    Tree<T> left;
    Tree<T> right;

    @Override
    public String toString() {
      return value + "";
    }

  }

  // ---------traverseTree
  int[] traverseTree(Tree<Integer> t) {
    if (t == null) {
      return new int[0];
    }
    List<Integer> ls = new ArrayList<>();
    Queue<Tree<Integer>> q = new LinkedList<>();
    q.add(t);
    while (!q.isEmpty()) {
      Tree<Integer> cur = q.poll();
      ls.add(cur.value);
      if (cur.left != null) {
        q.add(cur.left);
      }
      if (cur.right != null) {
        q.add(cur.right);
      }
    }
    return ls.stream().mapToInt(e -> e).toArray();
  }

  /// ----------largestValuesInTreeRowsExtend
  int[] largestValuesInTreeRowsExtend(Tree<Integer> t) {
    if (t == null) {
      return new int[0];
    }
    Map<Tree<Integer>, Tree<Integer>> _mapParent = new HashMap<>();
    Tree<Integer>[] _maxTree = new Tree[1];
    int[] max = new int[1];
    max[0] = Integer.MIN_VALUE;
    treeDfsLargestValue(t, 0, max, _mapParent, _maxTree);
    Tree<Integer> cur = _maxTree[0];
    Stack<Integer> stack = new Stack<>();
    while (cur != null) {
      stack.add(cur.value);
      cur = _mapParent.get(cur);
    }
    List<Integer> ls = new ArrayList<>();
    while (!stack.isEmpty()) {
      ls.add(stack.pop());
    }
    return ls.stream().mapToInt(e -> e).toArray();
  }

  private void treeDfsLargestValue(Tree<Integer> t, int value, int[] max,
      Map<Tree<Integer>, Tree<Integer>> _mapParent, Tree<Integer>[] _maxTree) {
    value += t.value;
    if (t.left == null && t.right == null && value > max[0]) {
      max[0] = value;
      _maxTree[0] = t;
    }
    if (t.left != null) {
      _mapParent.put(t.left, t);
      treeDfsLargestValue(t.left, value, max, _mapParent, _maxTree);
    }
    if (t.right != null) {
      _mapParent.put(t.right, t);
      treeDfsLargestValue(t.right, value, max, _mapParent, _maxTree);
    }
  }

  /// ----------largestValuesInTreeRows
  int[] largestValuesInTreeRows(Tree<Integer> t) {
    if (t == null) {
      return new int[0];
    }
    List<Integer> result = new ArrayList<>();
    List<Tree<Integer>> lsCheck = new ArrayList<>();
    lsCheck.add(t);
    while (!lsCheck.isEmpty()) {
      int max = Integer.MIN_VALUE;
      List<Tree<Integer>> lsCheckNew = new ArrayList<>();
      for (Tree<Integer> tree : lsCheck) {
        if (tree.value > max) {
          max = tree.value;
        }
        if (tree.left != null) {
          lsCheckNew.add(tree.left);
        }
        if (tree.right != null) {
          lsCheckNew.add(tree.right);
        }
      }
      result.add(max);
      lsCheck = lsCheckNew;
    }
    return result.stream().mapToInt(e -> e).toArray();
  }

  /// -----------digitTreeSum
  long digitTreeSum(Tree<Integer> t) {
    long[] sum = new long[1];
    long pre = 0L;
    digitTreeSumRecursive(pre, t, sum);
    return sum[0];
  }

  private void digitTreeSumRecursive(long pre, Tree<Integer> t, long[] sum) {
    pre = pre * 10 + t.value;
    if (t.left == null && t.right == null) {
      sum[0] += pre;
    }
    if (t.left != null) {
      digitTreeSumRecursive(pre, t.left, sum);
    }
    if (t.right != null) {
      digitTreeSumRecursive(pre, t.right, sum);
    }
  }

  /// -----------longestPath
  int longestPath(String fileSystem) {
    fileSystem = fileSystem.replaceAll("\t", "!");
    fileSystem = fileSystem.replaceAll("\f", "#");
    String[] split = fileSystem.split("#");
    List<String> lsFile = new ArrayList<>();
    for (String s : split) {
      if (s.contains(".")) {
        lsFile.add(s);
      }
    }
    int maxL = 0;
    for (String max : lsFile) {
      String r = "";
      int count = -1, i = 0;
      while (i < max.length()) {
        if (max.charAt(i++) == '!') {
          count++;
        } else {
          break;
        }
      }
      r += max.replaceAll("!", "");
      int iCur = indexOf(split, max) - 1;
      while (count >= 0) {
        String prefix = genatePrefix(count--);
        for (int j = iCur; j >= 0; j--) {
          String check = split[j];
          if (check.contains(prefix) && !check.contains(prefix + "!")) {
            r = check.replaceAll("!", "") + "/" + r;
            iCur = j - 1;
            break;
          }
        }
      }
      maxL = Math.max(maxL, r.length());
    }

    return maxL;
  }

  private String genatePrefix(int count) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < count; i++) {
      builder.append("!");
    }
    return builder.toString();
  }

  int indexOf(String[] values, String check) {
    for (int i = 0; i < values.length; i++) {
      if (values[i].equals(check)) {
        return i;
      }
    }
    return -1;
  }

  /// ---------graphDistances
  int[] graphDistances(int[][] g, int s) {
    int[] dist = new int[g.length];
    boolean[] visited = new boolean[g.length];
    for (int i = 0; i < g.length; i++) {
      if (i == s) {
        dist[i] = 0;
        continue;
      }
      dist[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i < g.length - 1; i++) {
      int minIdx = minDist(dist, visited, g);
      visited[minIdx] = true;
      for (int j = 0; j < g.length; j++) {
        if (g[minIdx][j] != -1 && dist[minIdx] != Integer.MAX_VALUE
            && dist[minIdx] + g[minIdx][j] < dist[j]) {
          dist[j] = dist[minIdx] + g[minIdx][j];
        }
      }
    }
    return dist;
  }

  int minDist(int[] dist, boolean[] visited, int[][] g) {
    int minIdx = -1, min = Integer.MAX_VALUE;
    for (int i = 0; i < dist.length; i++) {
      if (!visited[i] && dist[i] <= min) {
        minIdx = i;
        min = dist[minIdx];
      }
    }
    return minIdx;
  }


  public static void main(String[] args) {
    InterviewDfsBfs i = new InterviewDfsBfs();
    String s = "a\f\tb\f\t\tc.txt\f\taaaa.txt";
    int[][] g = {{-1, 3, 2}, {2, -1, 0}, {-1, 0, -1}};
    System.out.println(i.graphDistances(g, 0));
  }
}
