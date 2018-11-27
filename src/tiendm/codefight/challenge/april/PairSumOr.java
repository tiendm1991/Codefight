package tiendm.codefight.challenge.april;

public class PairSumOr {

  long pairSumOr(int[] arr) {
    double sum = 0L;
    double l = arr.length;
    for (int i = 0; i < 32; i++) {
      int count = 0;
      for (int j = 0; j < l; j++) {
        if (((arr[j] >> i) & 1) == 0)
          count++;
      }
      sum += (1 << i) * (l - count) * (l + count - 1) / 2;
    }
    return (long) sum;
  }

  long pairSumOr2(int[] arr) {
    long sum = 0L;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        sum += arr[i] | arr[j];
      }
    }
    return sum;
  }

  public static void main(String[] args) {
    PairSumOr pso = new PairSumOr();
    int[] x = {1, 2, 3};
    System.out.println(pso.pairSumOr(x));
  }
}
