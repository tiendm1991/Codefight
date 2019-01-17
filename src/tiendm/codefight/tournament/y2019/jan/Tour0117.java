package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tour0117 {
  boolean isIdentityMatrix(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j] != 1 && i == j || matrix[i][j] != 0 && i != j) {
          return false;
        }
      }
    }
    return true;
  }

  int rangeBitCount(int a, int b) {

    int ans = 0;
    for (int i = a; i <= b; i++) {
      int t = i;
      while (t != 0) {
        ans += t % 2;
        t >>= 1;
      }
    }

    return ans;
  }

  int arrayKthGreatestQuick(int[] inputArray, int k) {

    class Helper {
      int[] listToArray(List<Integer> data) {
        int[] res = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
          res[i] = data.get(i);
        }
        return res;
      }
    };

    int pos = (new Random()).nextInt(inputArray.length);
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    if (inputArray.length == 1) {
      return inputArray[0];
    }

    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] <= inputArray[pos]) {
        left.add(inputArray[i]);
      } else {
        right.add(inputArray[i]);
      }
    }

    Helper h = new Helper();

    if (right.size() >= k) {
      return arrayKthGreatestQuick(h.listToArray(right), k);
    }
    return arrayKthGreatestQuick(h.listToArray(left), k - right.size());
  }

  public static void main(String[] args) {
    Tour0117 t = new Tour0117();
    System.out.println(t);
  }
}
