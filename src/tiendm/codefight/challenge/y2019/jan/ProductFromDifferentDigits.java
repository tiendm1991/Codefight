package tiendm.codefight.challenge.y2019.jan;

import java.util.ArrayList;
import java.util.List;

public class ProductFromDifferentDigits {
  int productFromDifferentDigits(int n) {
    if (n > 152) {
      return -1;
    }
    if (n <= 10) {
      return n;
    }
    int count = 11;
    int num = 10;
    while (count <= n) {
      num++;
      if (isProductNum(num, 0)) {
        count++;
      }
    }
    return num;
  }

  boolean isProductNum(int n, int max) {
    if (n < 10) {
      return n > max;
    }
    int start = (max == 0) ? 2 : max + 1;
    for (int i = start; i <= 9; i++) {
      if (n % i == 0) {
        boolean check = isProductNum(n / i, i);
        if (check) {
          return true;
        } else {
          max = i;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ProductFromDifferentDigits p = new ProductFromDifferentDigits();
    List<Integer> ls = new ArrayList<>();
    System.out.println(p.isProductNum(50, 0));
    System.out.println(ls);
     System.out.println(p.productFromDifferentDigits(39));
  }
}
