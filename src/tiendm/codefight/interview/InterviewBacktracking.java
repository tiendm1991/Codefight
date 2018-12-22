package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewBacktracking {

  List<ArrayList<Integer>> climbingStaircase(int n, int k) {
    List<ArrayList<Integer>> result = new ArrayList<>();
    if (n == 0 || k == 0) {
      result.add(new ArrayList<>());
      return result;
    }
    ArrayList<Integer> first = new ArrayList<>();
    climbingBacktrack(first, result, 0, n, k);
    return result;
  }

  void climbingBacktrack(ArrayList<Integer> cur, List<ArrayList<Integer>> result, int idx, int n,
      int k) {
    for (int i = 1; i <= k; i++) {
      ArrayList<Integer> clone = clone(cur);
      clone.add(idx, i);
      int sum = sum(clone);
      if (sum == n) {
        result.add(clone);
      } else if (sum < n) {
        climbingBacktrack(clone, result, idx + 1, n, k);
      } else {
        break;
      }
    }
  }

  int sum(ArrayList<Integer> list) {
    int s = 0;
    for (int x : list) {
      s += x;
    }
    return s;
  }

  ArrayList<Integer> clone(ArrayList<Integer> list) {
    if (list.isEmpty()) {
      return new ArrayList<>();
    }
    return (ArrayList<Integer>) list.stream().map(e -> e).collect(Collectors.toList());
  }

  public static void main(String[] args) {
    InterviewBacktracking i = new InterviewBacktracking();
    System.out.println(i.climbingStaircase(4, 2));
  }
}
