package tiendm.codefight.tournament.nov;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1102 {
  int commonPoints(int l1, int r1, int l2, int r2) {
    int result = Math.min(r1, r2) - Math.max(l1, l2) - 1;
    if (result < 0) {
      return 0;
    }
    return result;
  }

  public static void main(String[] args) {
    Tour1102 t = new Tour1102();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
