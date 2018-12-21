package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;

public class InterviewBacktracking {

  List<ArrayList<Integer>> climbingStaircase(int n, int k) {
    List<ArrayList<Integer>> result = new ArrayList<>();
    if (n == 0 || k == 0) {
      result.add(new ArrayList<>());
      return result;
    }
    ArrayList<Integer> first = new ArrayList<>();
    climbingBacktrack(first, result, n, k);
    return result;
  }

  void climbingBacktrack(ArrayList<Integer> cur, List<ArrayList<Integer>> result, int n, int k) {
    for (int i = 1; i <= k; i++) {
      int s = sum(cur);
      if (s + i > n) {
        break;
      } else {
        cur.add(i);
        if (s + i == n) {
          result.add(cur);
        }
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

  public static void main(String[] args) {
    InterviewBacktracking i = new InterviewBacktracking();
    System.out.println(i.climbingStaircase(4, 2));
  }
}
