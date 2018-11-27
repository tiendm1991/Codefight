package tiendm.codefight.challenge.may;

import java.math.BigInteger;

public class Bits {
  long[] bits(long[] numbers) {
    long[] x = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++) {
      long l = numbers[i];
      String s = Long.toBinaryString(l);
      char[] a = s.toCharArray();
      int u = 0, v = s.length() - 1;
      while (u < v && a[u] == '1') {
        u++;
      }
      while (v > u && a[v] == '0') {
        v--;
      }
      if (u < v) {
        a[u] = '1';
        a[v] = '0';
      }
      s = new String(a);
      x[i] = new BigInteger(s, 2).longValue();
    }
    return x;
  }

  public static void main(String[] args) {
    Bits b = new Bits();
    System.out.println(b.bits(new long[] {1, 5, 9}));
    // System.out.println(b.bits(new long[]{9363, 8276, 6767}));
    // 15504, 14400, 8044
    // 13458, 12368, 7790
  }
}
