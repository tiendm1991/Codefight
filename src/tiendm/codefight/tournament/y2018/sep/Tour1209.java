package tiendm.codefight.tournament.y2018.sep;

public class Tour1209 {
  String caesarBoxCipherEncoding(String inputString) {
    int len = inputString.length();
    int x = (int) Math.sqrt(len);
    String s = "";
    for (int i = 0; i < x; i++) {
      for (int j = i; j < len; j += x) {
        s += inputString.charAt(j) + "";
      }
    }
    return s;
  }

  String reflectString(String inputString) {
    String s = "";
    for (int i = 0; i < inputString.length(); i++) {
      s += (char) ('z' - (inputString.charAt(i) - 'a')) + "";
    }
    return s;
  }

  boolean isTournament(int n, int[] fromV, int[] toV) {
    int[][] adj = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < fromV.length; j++) {
        if (i == fromV[j] - 1)
          adj[i][toV[j] - 1] = 1;
      }
    }

    for (int i = 0; i < adj.length; i++)
      for (int j = 0; j < adj.length; j++)
        if ((i != j && adj[i][j] == adj[j][i]) || (i == j && adj[i][j] == 1))
          return false;
    return true;
  }

  public static void main(String[] args) {
    Tour1209 t = new Tour1209();
    int[] fromV = {2, 1, 3, 4, 4, 4, 1};
    int[] toV = {3, 2, 1, 3, 2, 1, 4};
    System.out.println(t.isTournament(4, fromV, toV));
  }
}
