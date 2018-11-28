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
    while(!q.isEmpty()){
      Tree<Integer> cur = q.poll();
      if(cur != null){
        lsTree.add(cur.left);
        lsTree.add(cur.right);
        q.add(cur.left);
        q.add(cur.right);
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
