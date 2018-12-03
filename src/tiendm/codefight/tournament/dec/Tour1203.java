package tiendm.codefight.tournament.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1203 {
  int largestDistance(int[] a) {

    int[] mx = new int[] {a[0], a[1]};
    int[] mn = new int[] {a[0], a[1]};
    for (int i = 0; i < a.length; i++) {
      int k = i % 2;
      if (a[i] > mx[k]) {
        mx[k] = a[i];
      } else if (a[i] < mn[k]) {
        mn[k] = a[i];
      }
    }
    return Math.max(mx[0] - mn[0], mx[1] - mn[1]);
  }

  public static void main(String[] args) {
    Tour1203 t = new Tour1203();
    int[] values = {7, 6, 6, 8, 1, 2, 8, 6};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t.largestDistance(values));
  }
}
