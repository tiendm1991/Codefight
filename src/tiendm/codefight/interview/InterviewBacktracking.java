package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewBacktracking {
  // --------climbingStaircase
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

  // -------nQueen
  List<int[]> nQueens(int n) {
    List<int[]> result = new ArrayList<>();
    int[] cur = new int[n];
    queenBacktrack(cur, 0, result, n);
    return result;
  }

  void queenBacktrack(int[] cur, int row, List<int[]> result, int n) {
    if (row == n) {
      result.add(cloneArr(cur));
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (isSafe(cur, row, i)) {
        cur[row] = i;
        queenBacktrack(cur, row + 1, result, n);
        cur[row] = 0;
      }
    }
  }

  boolean isSafe(int[] q, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (q[i] == col) {
        return false;
      }
    }
    for (int i = 0; i < row; i++) {
      if (q[i] - i == col - row) {
        return false;
      }
    }
    for (int i = 0; i < row; i++) {
      if (q[i] + i == row + col)
        return false;
    }
    return true;
  }

  int[] cloneArr(int[] source) {
    return Arrays.copyOfRange(source, 0, source.length);
  }

  public static void main(String[] args) {
    InterviewBacktracking i = new InterviewBacktracking();
    int[] x = {1, 2, 3};
    System.out.println(i.nQueens(4));
  }
}
