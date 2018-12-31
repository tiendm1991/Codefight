package tiendm.codefight.tournament.y2018.nov;

public class Tour1128 {
  int differentValuesInMultiplicationTable2(int n, int m) {
    boolean[] found = new boolean[n * m + 1];
    int result = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        found[i * j] = true;
      }
    }

    for (int value = 1; value <= n * m; value++) {
      if (found[value]) {
        result++;
      }
    }

    return result;
  }

  int increasingNumber(int x, int n) {
    for (int i = 1; i <= n; i++) {
      while (x % i != 0) {
        x += 1;
      }
    }
    return x;
  }

  String fromDecimal(int b, int n) {
    String s = "";
    while (n > 0) {
      s = (n % b) + "" + s;
      n /= b;
    }
    return s;
  }

  public static void main(String[] args) {
    Tour1128 t = new Tour1128();
    int[] values = {2, 1, 3, 5, 3, 2};
    String[] s = {"*", "-", "5", "6", "7"};
    int[] a = {3, -3};
    int[] b = {-3, 3};
    int[] c = {-1, 0};
    int[] d = {2, 1};
    System.out.println(t);
  }
}
