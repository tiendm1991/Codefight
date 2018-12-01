package tiendm.codefight.tournament.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1201 {
  int minimalNumberOfCoins(int[] coins, int price) {

    int result = 0;

    for (int i = coins.length - 1; i >= 0; i--) {
      result += price / coins[i];
      price %= coins[i];
    }

    if (price != 0) {
      return -1;
    }
    return result;
  }

  int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 16; i++) {
      res = res * 2 + n % 2;
      n /= 2;
    }
    return res;
  }

  boolean isPangram(String sentence) {
    boolean[] found = new boolean[26];
    boolean result = true;
    for (int i = 0; i < sentence.length(); i++) {
      int code = (int) sentence.charAt(i);
      if ((int) 'A' <= code && code <= (int) 'Z') {
        code += (int) 'a' - (int) 'A';
      }
      if ((int) 'a' <= code && code <= (int) 'z') {
        found[code - (int) 'a'] = true;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (!found[i]) {
        result = false;
      }
    }

    return result;
  }

  int circleOfNumbers(int n, int firstNumber) {
    return (n / 2 + firstNumber) % n;
  }

  public static void main(String[] args) {
    Tour1201 t = new Tour1201();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
