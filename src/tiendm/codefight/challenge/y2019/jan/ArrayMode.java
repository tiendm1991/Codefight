package tiendm.codefight.challenge.y2019.jan;

import java.util.Arrays;

public class ArrayMode {
  int arrayMode(int[] sequence) {
    Arrays.sort(sequence);
    int mode = sequence[0];
    int max = 1;
    int current = 1;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i] == sequence[i - 1]) {
        current++;
        if (i == sequence.length - 1 && current > max) {
          return sequence[i];
        }
      } else {
        if (current > max) {
          max = current;
          mode = sequence[i - 1];
        }
        current = 1;
      }
    }
    return mode;
  }

  public static void main(String[] args) {
    ArrayMode mode = new ArrayMode();
    int[] x = {1, 3, 3, 3, 1};
    System.out.println(mode.arrayMode(x));
  }
}
