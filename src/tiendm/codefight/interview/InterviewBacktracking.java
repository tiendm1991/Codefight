package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
      ArrayList<Integer> clone = cloneList(cur);
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

  ArrayList<Integer> cloneList(ArrayList<Integer> list) {
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

  //// ------------sumSubsets
  List<ArrayList<Integer>> sumSubsets(int[] arr, int num) {
    List<ArrayList<Integer>> result = new ArrayList<>();
    if (num == 0 || arr == null || arr.length == 0) {
      result.add(new ArrayList<>());
      return result;
    }
    Arrays.sort(arr);
    ArrayList<Integer> first = new ArrayList<>();
    subsetSumBacktrack(first, result, 0, num, arr);
    return result;
  }

  void subsetSumBacktrack(ArrayList<Integer> cur, List<ArrayList<Integer>> result, int idx, int num,
      int[] arr) {
    for (int i = idx; i < arr.length; i++) {
      ArrayList<Integer> clone = cloneList(cur);
      clone.add(arr[i]);
      int sum = sum(clone);
      if (sum == num && !isExist(result, clone)) {
        result.add(clone);
      } else if (sum < num) {
        subsetSumBacktrack(clone, result, i + 1, num, arr);
      } else {
        break;
      }
    }
  }

  boolean isExist(List<ArrayList<Integer>> result, ArrayList<Integer> check) {
    for (ArrayList<Integer> ls : result) {
      boolean isEqual = true;
      if (ls.size() != check.size()) {
        continue;
      }
      for (int i = 0; i < ls.size(); i++) {
        if (!ls.get(i).equals(check.get(i))) {
          isEqual = false;
          break;
        }
      }
      if (isEqual) {
        return true;
      }
    }
    return false;
  }

  // -------wordBoggle
  List<String> wordBoggle(char[][] board, String[] words) {
    List<String> result = new ArrayList<>();
    if (board.length == 0 || board[0].length == 0) {
      return result;
    }
    for (String s : words) {
      if (isWordBoggle(board, s)) {
        result.add(s);
      }
    }
    Collections.sort(result);
    return result;
  }

  boolean isWordBoggle(char[][] board, String s) {
    char first = s.charAt(0);
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == first) {
          List<String> track = new ArrayList<>();
          if(isWordBoggleBAcktrack(board, track, s, 0, i, j)){
            return true;
          }
        }
      }
    }
    return false;    
  }

  boolean isWordBoggleBAcktrack(char[][] board, List<String> track, String s, int idx, int row,
      int col) {
    if (idx == s.length()) {
      return true;
    }
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
      return false;
    }
    char c = s.charAt(idx);
    if (board[row][col] != c || track.contains(row + "-" + col)) {
      return false;
    }
    track.add(row + "-" + col);
    boolean x1 = isWordBoggleBAcktrack(board, track, s, idx + 1, row - 1, col - 1);
    if (x1) {
      return true;
    }
    boolean x2 = isWordBoggleBAcktrack(board, track, s, idx + 1, row - 1, col);
    if (x2) {
      return true;
    }
    boolean x3 = isWordBoggleBAcktrack(board, track, s, idx + 1, row - 1, col + 1);
    if (x3) {
      return true;
    }
    boolean x4 = isWordBoggleBAcktrack(board, track, s, idx + 1, row, col - 1);
    if (x4) {
      return true;
    }
    boolean x5 = isWordBoggleBAcktrack(board, track, s, idx + 1, row, col + 1);
    if (x5) {
      return true;
    }
    boolean x6 = isWordBoggleBAcktrack(board, track, s, idx + 1, row + 1, col - 1);
    if (x6) {
      return true;
    }
    boolean x7 = isWordBoggleBAcktrack(board, track, s, idx + 1, row + 1, col);
    if (x7) {
      return true;
    }
    boolean x8 = isWordBoggleBAcktrack(board, track, s, idx + 1, row + 1, col + 1);
    if (x8) {
      return true;
    }
    track.remove(row + "-" + col);
    return false;
  }

  public static void main(String[] args) {
    InterviewBacktracking i = new InterviewBacktracking();
    char[][] board = {{'O','T','T','S'}, 
                      {'H','O','P','E'}, 
                      {'E','R','A','R'}, 
                      {'M','O','D','N'}};
    String[] words = {"DREAR"};
    System.out.println(i.wordBoggle(board, words));
  }
}
