package tiendm.codefight.challenge.y2019.jan;

public class NaturalNumbersListing {
  int naturalNumbersListing(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2 || n == 3) {
      return 3;
    }
    int i = 2;
    int x = 2;
    int s = 3;
    while (x < n) {
      x += 2 * i;
      if (x > n) {
        break;
      } else {
        s += x;
      }
      x += 1;
      if (x > n) {
        break;
      } else {
        s += x;
      }
      i += 2;
    }
    return s;
  }

  public static void main(String[] args) {
    NaturalNumbersListing n = new NaturalNumbersListing();
    System.out.println(n.naturalNumbersListing(13));
  }
}
