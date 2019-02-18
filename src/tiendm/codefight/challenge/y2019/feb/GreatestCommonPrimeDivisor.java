package tiendm.codefight.challenge.y2019.feb;

public class GreatestCommonPrimeDivisor {
  int greatestCommonPrimeDivisor(int a, int b) {
    int min = Math.min(a, b);
    while (min > 1) {
      if (a % min == 0 && b % min == 0 && isPrime(min)) {
        return min;
      }
      min--;
    }
    return -1;
  }

  boolean isPrime(int x) {
    if (x == 2 || x == 3)
      return true;
    for (int i = 2; i <= x / 2; i++) {
      if (x % i == 0)
        return false;
    }
    return true;
  }
}
