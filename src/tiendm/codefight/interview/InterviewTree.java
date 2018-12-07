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

  // -------kthSmallestInBST
  int kthSmallestInBST(Tree<Integer> t, int k) {
    List<Tree<Integer>> inTreeList = new ArrayList<>();
    inTraversal(t, inTreeList);
    return inTreeList.get(k - 1).value.intValue();
  }

  void inTraversal(Tree<Integer> cur, List<Tree<Integer>> inTreeList) {
    if (cur.left == null && cur.right == null) {
      inTreeList.add(cur);
      return;
    }
    if (cur.left != null) {
      inTraversal(cur.left, inTreeList);
    }
    inTreeList.add(cur);
    if (cur.right != null) {
      inTraversal(cur.right, inTreeList);
    }
  }

  // -------kthSmallestInBST
  boolean isSubtree(Tree<Integer> t1, Tree<Integer> t2) {
    if (t2 == null)
      return true;
    if (t1 == null)
      return false;
    if (isSubtreeWithRoot(t1, t2))
      return true;
    if (t1.left != null && isSubtree(t1.left, t2)) {
      return true;
    }
    if (t1.right != null && isSubtree(t1.right, t2)) {
      return true;
    }
    return false;
  }

  boolean isSubtreeWithRoot(Tree<Integer> t1, Tree<Integer> t2) {
    if (!t1.value.equals(t2.value)) {
      return false;
    }
    boolean result = true;
    if (t2.left == null && t1.left != null)
      return false;
    if (t2.right == null && t1.right != null)
      return false;
    if (t2.left != null) {
      if (t1.left == null)
        return false;
      result = result && isSubtreeWithRoot(t1.left, t2.left);
    }
    if (t2.right != null) {
      if (t1.right == null)
        return false;
      result = result && isSubtreeWithRoot(t1.right, t2.right);
    }
    return result;
  }

  Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
    Tree<Integer> root = new Tree<Integer>(preorder[0]);
    for (int i = 1; i < preorder.length; i++) {
      int v = preorder[i];
      int idxNew = indexOf(inorder, v);
      Tree<Integer> cur = root;
      while (true) {
        int idxCur = indexOf(inorder, cur.value);
        if (idxNew < idxCur) {
          if (cur.left == null) {
            cur.left = new Tree<Integer>(v);
            break;
          } else {
            cur = cur.left;
          }
        } else {
          if (cur.right == null) {
            cur.right = new Tree<Integer>(v);
            break;
          } else {
            cur = cur.right;
          }
        }
      }
    }
    return root;
  }

  int indexOf(int[] values, int check) {
    for (int i = 0; i < values.length; i++) {
      if (values[i] == check) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    InterviewTree i = new InterviewTree();
    int[] in = {4, 2, 1, 5, 3, 6};
    int[] pre = {1, 2, 4, 3, 5, 6};
    System.out.println(i.restoreBinaryTree(in, pre));
  }
}
