package tiendm.codefight.tournament.y2019.jan;

public class Tour0120 {
  int maxGCD(int[] sequence) {
    class Helper {
      int gcd(int a, int b) {
        if (b == 0) {
          return a;
        }
        return gcd(b, a % b);
      }
    };

    Helper h = new Helper();
    int bestRes = 0;

    for (int i = 0; i < sequence.length; i++) {
      int result = sequence[0];
      if (i == 0) {
        result = sequence[1];
      }
      for (int j = 0; j < sequence.length; j++) {
        if (j == i) {
          continue;
        }
        result = h.gcd(result, sequence[j]);
      }
      if (result > bestRes) {
        bestRes = result;
      }
    }

    return bestRes;
  }

  public static void main(String[] args) {
    Tour0120 t = new Tour0120();
  }
}
