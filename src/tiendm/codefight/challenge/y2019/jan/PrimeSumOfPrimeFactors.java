package tiendm.codefight.challenge.y2019.jan;

public class PrimeSumOfPrimeFactors {
  boolean primeSumOfPrimeFactors(int n) {
    if (isPrime(n)) {
      return false;
    }
    int sum = sumPrimeFactor(n);
    return isPrime(sum);
  }

  int sumPrimeFactor(int n) {
    int i;
    for (i = 2; i < n; i++) {
      if (n % i == 0) {
        return i + sumPrimeFactor(n / i);
      }
    }
    return n;
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

  public static void main(String[] args) {
    PrimeSumOfPrimeFactors p = new PrimeSumOfPrimeFactors();
    System.out.println(p.primeSumOfPrimeFactors(148));
  }
}
