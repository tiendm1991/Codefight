package tiendm.codefight.challenge.y2019.jan;

public class ArrayMaxConsecutiveSum {
  int arrayMaxConsecutiveSum(int[] inputArray, int k) {
    int max = 0;
    int cur = 0;
    for (int i = 0; i < k; i++) {
      cur += inputArray[i];
    }
    max = cur;
    for (int i = k; i < inputArray.length; i++) {
      cur += inputArray[i];
      cur -= inputArray[i - k];
      max = Math.max(cur, max);
    }
    return max;
  }

  public static void main(String[] args) {
    ArrayMaxConsecutiveSum a = new ArrayMaxConsecutiveSum();
    int[] x = {2, 3, 5, 1, 6};
    System.out.println(a.arrayMaxConsecutiveSum(x, 2));
  }
}
