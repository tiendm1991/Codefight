package tiendm.codefight.tournament.y2018.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1231 {
  int kthDigit(int n, int k) {

    int numDigits = 0, number = n;
    while (number != 0) {
      numDigits++;
      number /= 10;
    }

    int indexFromLast = numDigits - k;

    while (n != 0) {
      if (indexFromLast-- == 0) {
        return n % 10;
      }
      n /= 10;
    }

    return -1;
  }

  public static void main(String[] args) {
    Tour1231 t = new Tour1231();
    int[] values = {4, 3, 1, 1, 0, 0};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
