package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
  
  //---------traverseTree
  int[] traverseTree(Tree<Integer> t) {
    if(t == null) return new int[0];
    List<Integer> ls = new ArrayList<>();
    Queue<Tree<Integer>> q = new LinkedList<>();
    q.add(t);
    while(!q.isEmpty()){
      Tree<Integer> cur = q.poll();
      ls.add(cur.value);
      if(cur.left != null){
        q.add(cur.left);
      }
      if(cur.right != null){
        q.add(cur.right);
      }
    }
    return ls.stream().mapToInt(e -> e).toArray();
  }
  
  int[] largestValuesInTreeRows(Tree<Integer> t) {
    
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
  }
}
