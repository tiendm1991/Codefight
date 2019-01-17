package tiendm.codefight.challenge.y2018.may;

import java.util.Arrays;

public class SuccessivePrimes {
  // int successivePrimes(int[] primes) {
  // Arrays.sort(primes);
  // for(int i = 0; i < primes.length -1; i++){
  // for(int n = primes[i]+1; n < primes[i+1]; n++){
  // boolean isP = true;
  // for( int k= 2; k <= Math.sqrt(n); k++){
  // if(n % k == 0) {
  // isP = false;
  // break;
  // }
  // }
  // if(isP) return n;
  // }
  // }
  // return -1;
  // }
  int successivePrimes(int[] p) {
    Arrays.sort(p);
    for (int i = 0; i < p.length - 1; i++) {
      for (int n = p[i] + 1; n < p[i + 1]; n++) {
        boolean b = true;
        for (int k = 2; k <= Math.sqrt(n); k++) {
          if (n % k == 0) {
            b = false;
            break;
          }
        }
        if (b)
          return n;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    SuccessivePrimes test = new SuccessivePrimes();
    System.out.println(test.successivePrimes(new int[] {11, 3, 7}));
  }
}
