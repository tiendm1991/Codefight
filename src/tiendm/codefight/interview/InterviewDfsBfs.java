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
      for(Tree<Integer> tree: lsCheck) {
        if(tree.value > max) {
          max = tree.value;
        }
        if(tree.left != null) {
          lsCheckNew.add(tree.left);
        }
        if(tree.right != null) {
          lsCheckNew.add(tree.right);
        }
      }
      result.add(max);
      lsCheck = lsCheckNew;
    }
    return result.stream().mapToInt(e -> e).toArray();
  }

  public static void main(String[] args) {
    InterviewDfsBfs i = new InterviewDfsBfs();
    Tree<Integer> t0 = new Tree<Integer>(5);
    Tree<Integer> t1 = new Tree<Integer>(2);
    Tree<Integer> t2 = new Tree<Integer>(6);
    Tree<Integer> t3 = new Tree<Integer>(1);
    Tree<Integer> t4 = new Tree<Integer>(4);
    Tree<Integer> t5 = new Tree<Integer>(3);
    t0.left = t1;
    t0.right = t2;
    t1.left = t3;
    t1.right = t4;
    t4.left = t5;
    System.out.println(i.largestValuesInTreeRows(t0));
  }
}
