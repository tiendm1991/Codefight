package tiendm.codefight.challenge.y2018.dec;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BetterOrderTraversal {
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
}
