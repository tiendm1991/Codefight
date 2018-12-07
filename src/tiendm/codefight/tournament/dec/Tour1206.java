package tiendm.codefight.tournament.dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1206 {
  int digitSumsDifference(int n) {

    int result = 0;
    while (n != 0) {
      int digit = n % 10;
      if (digit % 2 == 1) {
        result -= digit;
      } else {
        result += digit;
      }
      n /= 10;
    }

    return result;
  }

  List<String> binaryGenerator(String s) {
    char[] c = s.toCharArray();
    List<String> ls = new ArrayList<>();
    ls.add(s);
    buildGenerate(ls, c, s.length() - 1);
    Collections.sort(ls);
    return ls;
  }

  private void buildGenerate(List<String> ls, char[] c, int maxIdx) {
    int i = maxIdx;
    while(i >=0 && c[i] == '1'){
      i--;
    }
    if(i >= 0){
      char[] c2 = copy(c);
      c2[i] = '1';
      ls.add(new String(c2));
      buildGenerate(ls, c, i-1);
      buildGenerate(ls, c2, i-1);
    }
  }

  char[] copy(char[] source) {
    String s = new String(source);
    return s.toCharArray();
  }

  public static void main(String[] args) {
    Tour1206 t = new Tour1206();
    int[] values = {4, 3, 1, 1, 0, 0};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t.binaryGenerator("0001001"));
  }
}
