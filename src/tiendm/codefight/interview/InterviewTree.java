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
    List<Tree<Integer>> lsTree = new ArrayList<>();
    Queue<Tree<Integer>> q = new LinkedList<>();
    q.add(t);
    lsTree.add(t);
    while (!q.isEmpty()) {
      Tree<Integer> cur = q.poll();
      if (cur != null) {
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
            || !treeL.value.equals(treeR.value))
          return false;
      }

    }
    return true;
  }

  public static void main(String[] args) {
    InterviewTree i = new InterviewTree();
    Tree<Integer> t0 = new Tree<Integer>(-883);
    Tree<Integer> t1 = new Tree<Integer>(-382);
    Tree<Integer> t2 = new Tree<Integer>(-382);
    t0.left = t1;
    t0.right = t2;
    Tree<Integer> t3 = new Tree<Integer>(229);
    Tree<Integer> t4 = new Tree<Integer>(493);
    Tree<Integer> t5 = new Tree<Integer>(493);
    Tree<Integer> t6 = new Tree<Integer>(229);
    t1.left = t3;
    t1.right = t4;
    t2.left = t5;
    t2.right = t6;
    Tree<Integer> t7 = new Tree<Integer>(-835);
    Tree<Integer> t8 = new Tree<Integer>(-793);
    Tree<Integer> t9 = new Tree<Integer>(424);
    Tree<Integer> t10 = new Tree<Integer>(93);
    Tree<Integer> t11 = new Tree<Integer>(93);
    Tree<Integer> t12 = new Tree<Integer>(424);
    Tree<Integer> t13 = new Tree<Integer>(-793);
    Tree<Integer> t14 = new Tree<Integer>(-835);
    t3.left = t7;
    t3.right = t8;
    t4.left = t9;
    t4.right = t10;
    t5.left = t11;
    t5.right = t12;
    t6.left = t13;
    t6.right = t14;
    Tree<Integer> t15 = new Tree<Integer>(-702);
    Tree<Integer> t16 = new Tree<Integer>(609);
    Tree<Integer> t17 = new Tree<Integer>(889);
    Tree<Integer> t18 = new Tree<Integer>(-724);
    Tree<Integer> t19 = new Tree<Integer>(212);
    Tree<Integer> t20 = new Tree<Integer>(212);
    Tree<Integer> t21 = new Tree<Integer>(-724);
    Tree<Integer> t22 = new Tree<Integer>(889);
    Tree<Integer> t23 = new Tree<Integer>(609);
    Tree<Integer> t24 = new Tree<Integer>(-702);
    t7.left = t15;
    t7.right = t16;
    t8.left = t17;
    t10.left = t18;
    t10.right = t19;
    t11.left = t20;
    t11.right = t21;
    t13.right = t22;
    t14.left = t23;
    t14.right = t24;
    Tree<Integer> t25 = new Tree<Integer>(800);
    Tree<Integer> t26 = new Tree<Integer>(1000);
    Tree<Integer> t27 = new Tree<Integer>(-261);
    Tree<Integer> t28 = new Tree<Integer>(-967);
    Tree<Integer> t29 = new Tree<Integer>(-367);
    Tree<Integer> t30 = new Tree<Integer>(748);
    Tree<Integer> t31 = new Tree<Integer>(-870);
    Tree<Integer> t32 = new Tree<Integer>(-12);
    Tree<Integer> t33 = new Tree<Integer>(-482);
    Tree<Integer> t34 = new Tree<Integer>(-482);
    Tree<Integer> t35 = new Tree<Integer>(-12);
    Tree<Integer> t36 = new Tree<Integer>(-870);
    Tree<Integer> t37 = new Tree<Integer>(748);
    Tree<Integer> t38 = new Tree<Integer>(-367);
    Tree<Integer> t39 = new Tree<Integer>(-966);
    Tree<Integer> t40 = new Tree<Integer>(-261);
    Tree<Integer> t41 = new Tree<Integer>(1000);
    Tree<Integer> t42 = new Tree<Integer>(800);
    t15.left = t25;
    t15.right = t26;
    t16.left = t27;
    t16.right = t28;
    t17.left = t29;
    t17.right = t30;
    t18.left = t31;
    t18.right = t32;
    t19.left = t33;
    t20.right = t34;
    t21.left = t35;
    t21.right = t36;
    t22.left = t37;
    t22.right = t38;
    t23.left = t39;
    t23.right = t40;
    t24.left = t41;
    t24.right = t42;
    System.out.println(i.isTreeSymmetric(t0));
  }
}
