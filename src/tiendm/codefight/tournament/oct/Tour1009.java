package tiendm.codefight.tournament.oct;

import java.util.Arrays;

public class Tour1009 {
  int minimalNumberOfCoins(int[] coins, int price) {
    int count = 0;
    Arrays.sort(coins);
    int n = coins.length - 1;
    while (price > 0) {
      count += price / coins[n];
      price = price % coins[n];
      n--;
    }
    return count;
  }

  int circleOfNumbers(int n, int firstNumber) {
    return (firstNumber + (n / 2)) % n;
  }

  public static void main(String[] args) {
    Tour1009 t = new Tour1009();
    int[] toV = {3, 2, 1, 3, 2, 1, 4};
    System.out.println(t);
  }
}
