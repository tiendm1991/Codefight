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

    return result;
  }

  public static void main(String[] args) {
    InterviewBacktracking i = new InterviewBacktracking();
    System.out.println(i.climbingStaircase(4, 2));
  }
}
