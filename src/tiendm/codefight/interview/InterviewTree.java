package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InterviewTree {

  static class Tree<T> {
    Tree(T x) {
      value = x;
    }

    T value;
    Tree<T> left;
    Tree<T> right;
  }

  boolean hasPathWithGivenSum(Tree<Integer> t, int s) {
    if (t == null) {
      return false;
    }
    Tree<Integer> left = t.left;
    Tree<Integer> right = t.right;
    if (left == null && right == null && t.value == s) {
      return true;
    }
    return (left != null && hasPathWithGivenSum(left, s - t.value))
        || (right != null && hasPathWithGivenSum(right, s - t.value));
  }

  boolean isTreeSymmetric(Tree<Integer> t) {
    if (t == null) {
      return true;
    }
    List<Tree<Integer>> lsTree = new ArrayList<>();
    Queue<Tree<Integer>> q = new LinkedList<>();
    q.add(t);
    lsTree.add(t);
    boolean notLeaf = true;
    while (notLeaf) {
      Tree<Integer> cur = q.poll();
      notLeaf = false;
      if (cur != null) {
        if (cur.left != null || cur.right != null) {
          notLeaf = true;
        }
        lsTree.add(cur.left);
        lsTree.add(cur.right);
        q.add(cur.left);
        q.add(cur.right);
      }
    }
    for (int i = 1; i * 2 < lsTree.size(); i = i * 2 + 1) {
      int l = i;
      int r = i * 2;
      while (l < r) {
        Tree<Integer> treeL = lsTree.get(l);
        Tree<Integer> treeR = lsTree.get(r);
        l++;
        r--;
        if (treeL == null && treeR == null)
          continue;
        if ((treeL == null && treeR != null) || (treeL != null && treeR == null)
            || treeL.value != treeR.value)
          return false;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    InterviewTree i = new InterviewTree();
    Tree<Integer> t0 = new Tree<Integer>(1);
    Tree<Integer> t1 = new Tree<Integer>(2);
    Tree<Integer> t2 = new Tree<Integer>(2);
    Tree<Integer> t4 = new Tree<Integer>(3);
    Tree<Integer> t6 = new Tree<Integer>(3);
    t0.left = t1;
    t0.right = t2;
    t1.right = t4;
    t2.right = t6;
    System.out.println(i.isTreeSymmetric(t0));
  }
}
