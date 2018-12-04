package tiendm.codefight.tournament.dec;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1204 {
  boolean validTime(String time) {

    class Helper {
      int charToInt(char symbol) {
        return symbol - '0';
      }
    }
    Helper h = new Helper();

    int hours = h.charToInt(time.charAt(0)) * 10 + h.charToInt(time.charAt(1)),
        minutes = h.charToInt(time.charAt(3)) * 10 + h.charToInt(time.charAt(4));

    if (hours < 24 && minutes < 60) {
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Tour1204 t = new Tour1204();
    int[] values = {7, 6, 6, 8, 1, 2, 8, 6};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println();
  }
}
