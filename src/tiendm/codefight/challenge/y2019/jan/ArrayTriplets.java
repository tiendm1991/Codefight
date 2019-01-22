package tiendm.codefight.challenge.y2019.jan;

import java.util.Arrays;

public class ArrayTriplets {
  int arrayTriplets(int[] arr) {
    Arrays.sort(arr);
    int s = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int a = arr[i];
      for (int j = i + 1; j < arr.length - 1; j++) {
        int b = arr[j];
        for (int k = j + 1; k < arr.length; k++) {
          int c = arr[k];
          if (a + b > c) {
            s++;
          } else {
            break;
          }
        }
      }
    }
    return s;
  }

  public static void main(String[] args) {
    ArrayTriplets a = new ArrayTriplets();
    int[] x = {1, 2, 10, 5, 12, 8, 2};
    System.out.println(a.arrayTriplets(x));
  }
}
