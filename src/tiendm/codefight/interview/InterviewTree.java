package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewTree {

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
    List<Tree<Integer>> lsPrev = new ArrayList<>();
    lsPrev.add(t);
    while (true) {
      List<Tree<Integer>> lsCheck = new ArrayList<>();
      int countNull = 0;
      for (Tree<Integer> node : lsPrev) {
        if (node != null) {
          if (node.left == null)
            countNull++;
          if (node.right == null)
            countNull++;
          lsCheck.add(node.left);
          lsCheck.add(node.right);
        }
      }
      if (lsCheck.size() == 0 || lsCheck.size() == countNull) {
        return true;
      }
      if (lsCheck.size() % 2 != 0)
        return false;
      int i = lsCheck.size() / 2 - 1;
      int j = lsCheck.size() / 2;
      while (i >= 0) {
        Tree<Integer> l = lsCheck.get(i--);
        Tree<Integer> r = lsCheck.get(j++);
        if (l == null && r == null) {
          continue;
        }
        if ((l == null && r != null) || (l != null && r == null) || !l.value.equals(r.value)) {
          return false;
        }
      }
      lsPrev = lsCheck;
    }
  }

  // -------findProfession
  String findProfession(int level, int pos) {
    if (level == 1)
      return "Engineer";
    if (pos % 2 == 0) {
      return findProfession(level - 1, pos / 2).equals("Engineer") ? "Doctor" : "Engineer";
    } else {
      return findProfession(level - 1, (pos + 1) / 2);
    }
  }

  public static void main(String[] args) {
    InterviewTree i = new InterviewTree();
    System.out.println(i.findProfession(3, 3));
  }
}
