package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

  // -----------betterOrderTraversal: Start
  List<Integer> betterOrderTraversal(Tree<Integer> root) {
    List<Tree<Integer>> preTreeList = new ArrayList<>();
    preTraversal(root, preTreeList);
    List<Integer> preList = preTreeList.stream().map(e -> e.value).collect(Collectors.toList());
    List<Tree<Integer>> inTreeList = new ArrayList<>();
    inTraversal(root, inTreeList);
    List<Integer> inList = inTreeList.stream().map(e -> e.value).collect(Collectors.toList());
    List<Tree<Integer>> postTreeList = new ArrayList<>();
    postTraversal(root, postTreeList);
    List<Integer> postList = postTreeList.stream().map(e -> e.value).collect(Collectors.toList());
    return max(preList, inList, postList);
  }

  List<Integer> max(List<Integer> preList, List<Integer> inList, List<Integer> postList) {
    return max(max(preList, inList), postList);
  }

  List<Integer> max(List<Integer> list1, List<Integer> list2) {
    for (int i = 0; i < list1.size(); i++) {
      int x1 = list1.get(i);
      int x2 = list2.get(i);
      if (x1 < x2)
        return list1;
      else if (x1 > x2)
        return list2;
    }
    return list1;
  }

  void preTraversal(Tree<Integer> cur, List<Tree<Integer>> preTreeList) {
    if (cur != null) {
      preTreeList.add(cur);
    }
    if (cur.left != null) {
      preTraversal(cur.left, preTreeList);
    }
    if (cur.right != null) {
      preTraversal(cur.right, preTreeList);
    }
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

  void postTraversal(Tree<Integer> cur, List<Tree<Integer>> postTreeList) {
    if (cur.left == null && cur.right == null) {
      postTreeList.add(cur);
      return;
    }
    if (cur.left != null) {
      postTraversal(cur.left, postTreeList);
    }
    if (cur.right != null) {
      postTraversal(cur.right, postTreeList);
    }
    postTreeList.add(cur);
  }
  // -----------betterOrderTraversal: End

  public static void main(String[] args) {
    InterviewTree i = new InterviewTree();
    Tree<Integer> t0 = new Tree<Integer>(-73);
    Tree<Integer> t1 = new Tree<Integer>(96);
    Tree<Integer> t2 = new Tree<Integer>(1);
    Tree<Integer> t3 = new Tree<Integer>(25);
    Tree<Integer> t4 = new Tree<Integer>(48);
    Tree<Integer> t5 = new Tree<Integer>(-31);
    Tree<Integer> t6 = new Tree<Integer>(-87);
    Tree<Integer> t7 = new Tree<Integer>(67);
    Tree<Integer> t8 = new Tree<Integer>(93);
    Tree<Integer> t9 = new Tree<Integer>(98);
    Tree<Integer> t10 = new Tree<Integer>(17);
    Tree<Integer> t11 = new Tree<Integer>(88);
    Tree<Integer> t12 = new Tree<Integer>(95);
    Tree<Integer> t13 = new Tree<Integer>(-46);
    Tree<Integer> t14 = new Tree<Integer>(-37);
    Tree<Integer> t15 = new Tree<Integer>(4);
    Tree<Integer> t16 = new Tree<Integer>(53);
    Tree<Integer> t17 = new Tree<Integer>(47);
    t0.left = t1;
    t1.left = t2;
    t2.left = t3;
    t2.right = t5;
    t3.left = t4;
    t4.left = t6;
    t6.left = t7;
    t6.right = t8;
    t7.left = t9;
    t8.right = t10;
    t9.left = t11;
    t9.right = t12;
    t10.left = t13;
    t11.right = t14;
    t12.left = t15;
    t12.right = t16;
    t14.left = t17;
    System.out.println(i.betterOrderTraversal(t0));
  }
}
