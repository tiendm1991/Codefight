package tiendm.codefight.challenge.y2019.jan;

public class BinomialCoefficient {
  long binomialCoefficient(int n, int k) {
    long limit = (long) Math.pow(2, 53);
    if (k > n / 2) {
      k = n - k;
    }
    long[][] dp = new long[k + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i <= k; i++) {
      for (int j = 0; j <= n; j++) {
        if (j < i) {
          dp[i][j] = 0;
        } else if (i == j) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
        }
        if (dp[i][j] >= limit) {
          return -1;
        }
      }
    }
    return dp[k][n];
  }

  public static void main(String[] args) {
    BinomialCoefficient b = new BinomialCoefficient();
    System.out.println(b.binomialCoefficient(93, 60));
  }

}
