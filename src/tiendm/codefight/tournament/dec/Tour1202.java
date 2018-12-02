package tiendm.codefight.tournament.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1202 {
  String biggerWord(String w0) {

    class Helper {
      void swap(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
      }
    }
    Helper h = new Helper();

    char[] w = w0.toCharArray();
    int leftSwap = -1;
    for (int i = w.length - 2; i >= 0; i--) {
      if (w[i] < w[i + 1]) {
        leftSwap = i;
        break;
      }
    }
    if (leftSwap == -1) {
      return "no answer";
    }

    int rightSwap = w.length - 1;
    while (w[rightSwap] <= w[leftSwap]) {
      rightSwap--;
    }
    h.swap(w, leftSwap++, rightSwap);
    rightSwap = w.length - 1;
    while (leftSwap < rightSwap) {
      h.swap(w, leftSwap++, rightSwap--);
    }
    return String.valueOf(w);
  }


  public static void main(String[] args) {
    Tour1202 t = new Tour1202();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t.biggerWord("fbcedba"));
  }
}
