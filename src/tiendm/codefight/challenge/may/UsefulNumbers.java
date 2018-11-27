package tiendm.codefight.challenge.may;

public class UsefulNumbers {

  int usefulNumbers(int k) {
    int n = k, sum = 0, count0 = 0;
    if (k == 1)
      return 1;
    while (n > 1) {
      int bit = n % 2;
      if (n == k) {
        if (bit == 0) {
          sum += 2;
          count0++;
        } else {
          sum += 1;
        }
      } else {
        if (bit == 0) {
          count0++;
          sum += 1 << (count0 - 1);
        }
      }
      n = n >> 1;
    }
    return sum;
  }

  public static void main(String[] args) {
    UsefulNumbers test = new UsefulNumbers();
    System.out.println(test.usefulNumbers(20));
  }
}
