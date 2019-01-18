package tiendm.codefight.tournament.y2019.jan;

public class Tour0118 {
  boolean almostIncreasingSequence(int[] sequence) {
    int mask = -1;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i] <= sequence[i - 1]) {
        mask = i - 1;
        break;
      }
    }
    if (mask == -1) {
      return true;
    }
    boolean check1 = true, check2 = true;
    int pre = mask == 0 ? Integer.MIN_VALUE : sequence[mask - 1];
    for (int i = mask + 1; i < sequence.length; i++) {
      if (sequence[i] <= pre) {
        check1 = false;
        break;
      }
      pre = sequence[i];
    }
    pre = sequence[mask];
    for (int i = mask + 2; i < sequence.length; i++) {
      if (sequence[i] <= pre) {
        check2 = false;
        break;
      }
      pre = sequence[i];
    }
    return check1 || check2;
  }

  int matrixElementsSum(int[][] matrix) {
    int s = 0;
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] == 0) {
          break;
        }
        s += matrix[i][i];
      }
    }
    return s;
  }

  public static void main(String[] args) {
    Tour0118 t = new Tour0118();
    System.out.println(t);
  }
}
