package tiendm.codefight.tournament.y2018.nov;

public class Tour1115 {
  boolean isTandemRepeat(String inputString) {

    int len = inputString.length();
    if (len % 2 == 1) {
      return false;
    }
    for (int i = 0; i < len / 2; i++) {
      if (inputString.charAt(i) != inputString.charAt(i + len / 2)) {
        return false;
      }
    }

    return true;
  }

  int nextPrime(int n) {

    for (int i = n + 1;; i++) {
      boolean isPrime = true;
      for (int divisor = 2; divisor * divisor <= i; divisor++) {
        if (i % divisor == 0) {
          isPrime = false;
        }
      }
      if (isPrime) {
        return i;
      }
    }
  }

  int[] alternatingSums(int[] a) {
    int[] r = new int[2];
    for (int i = 0; i < a.length; i++) {
      if (i % 2 == 0) {
        r[0] += a[i];
      } else {
        r[1] += a[i];
      }
    }
    return r;
  }

  int divisorsSubset(int[] subset, int n) {

    int res = 0;

    for (int i = 1; i <= n; i++) {
      boolean correct = true;
      for (int j = 0; j < subset.length; j++) {
        if (i % subset[j] != 0) {
          correct = false;
        }
      }
      if (correct) {
        res++;
      }
    }

    return res;
  }

  int greatestCommonPrimeDivisor(int a, int b) {

    int gcd = -1;
    for (int divisor = 2; a > 1 && b > 1; divisor++) {
      if (a % divisor == 0 && b % divisor == 0) {
        gcd = divisor;
      }
      while (a % divisor == 0) {
        a /= divisor;
      }
      while (b % divisor == 0) {
        b /= divisor;
      }
    }

    return gcd;
  }

  String knapsackLight2(int weight1, int weight2, int maxW) {

    if (weight1 + weight2 <= maxW) {
      return "both";
    }
    if (Math.min(weight1, weight2) > maxW) {
      return "none";
    }
    if (Math.max(weight1, weight2) <= maxW) {
      return "either";
    }
    if (weight1 <= maxW) {
      return "first";
    }
    return "second";
  }

  public static void main(String[] args) {
    Tour1115 t = new Tour1115();
    int[] values = {1, 6, 7};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t.greatestCommonPrimeDivisor(12, 18));
  }
}
