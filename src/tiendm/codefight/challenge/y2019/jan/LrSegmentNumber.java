package tiendm.codefight.challenge.y2019.jan;

public class LrSegmentNumber {
  int lrSegmentNumber(int l, int r) {
    String s = "";
    for (int i = l; i <= r; i++) {
      s += i;
    }
    return Integer.parseInt(s);
  }

}
