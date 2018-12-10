package tiendm.codefight.tournament.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1211 {
  boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
    if (yourLeft == friendsLeft && yourRight == friendsRight
        || yourLeft == friendsRight && friendsLeft == yourRight) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Tour1211 t = new Tour1211();
    int[] values = {4, 3, 1, 1, 0, 0};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
