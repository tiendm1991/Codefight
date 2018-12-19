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
    String[] max = new String[1];
    max[0] = "";
    String cur = "";
    Map<StrParent, StrParent> _map = new HashMap<>();
    longestPathRecursive(fileSystem, cur, _map, max);
    return max[0].length();
  }


  private void longestPathRecursive(String fileSystem, String cur, Map<StrParent, StrParent> _map, String[] max) {
    int idx = fileSystem.indexOf("#!");
    if (idx < 0) {
      cur += fileSystem;
      if (cur.contains("\\.") && cur.length() > max[0].length()) {
        max[0] = cur;
      }
      return;
    }
    String f = fileSystem.substring(0, idx);
    if (f.contains("\\.") && (cur + f).length() > max[0].length()) {
      max[0] = cur + f;
    } else {
      cur += "/";
    }
    longestPathRecursive(fileSystem.substring(idx + 2), cur, _map, max);
  }

  static class StrParent {
    String value;
    StrParent parent;
  }

  public static void main(String[] args) {
    InterviewDfsBfs i = new InterviewDfsBfs();
    String s = "user\f\tpictures\f\tdocuments\f\t\tnotes.txt";
    System.out.println(i.longestPath(s));
  }
}
