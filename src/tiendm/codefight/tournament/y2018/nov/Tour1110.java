package tiendm.codefight.tournament.y2018.nov;

import java.util.ArrayList;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1110 {
  int[][] spiralNumbers(int n) {
    int[][] m = new int[n][n];
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int currentDirectionIndex = 0;
    int currentRow = 0;
    int currentColumn = 0;
    int currentNum = 1;
    int tmpRow;
    int tmpColumn;
    for (int i = n * n; i > 0; i--) {
      m[currentRow][currentColumn] = currentNum;
      currentNum++;
      if (i > 1) {
        // Determine the next cell
        while (true) {
          tmpRow = currentRow + directions[currentDirectionIndex][0];
          tmpColumn = currentColumn + directions[currentDirectionIndex][1];
          if (tmpRow < 0 || tmpRow >= n || tmpColumn < 0 || tmpColumn >= n
              || m[tmpRow][tmpColumn] != 0) {
            currentDirectionIndex = (currentDirectionIndex + 1) % 4;
          } else {
            currentRow = tmpRow;
            currentColumn = tmpColumn;
            break;
          }
        }
      }
    }
    return m;
  }

  int dfsComponentSize(final boolean[][] matrix, int vertex) {

    class Helper {
      int componentSize = 0;

      void dfs(int currentVertex, ArrayList<Boolean> visited) {
        visited.set(currentVertex, true);
        componentSize++;
        for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
          if (matrix[currentVertex][nextVertex] && !visited.get(nextVertex)) {
            dfs(nextVertex, visited);
          }
        }
      }
    }
    Helper h = new Helper();

    ArrayList<Boolean> visited = new ArrayList<>();

    for (int i = 0; i < matrix.length; i++) {
      visited.add(false);
    }

    h.dfs(vertex, visited);

    return h.componentSize;
  }

  int fibonacciIndex(int n) {
    if (n == 1)
      return 0;
    int check = (int) Math.pow(10, n - 1);
    int x0 = 0;
    int x1 = 1;
    int x2 = 1;
    int idx = 1;
    while (x2 < check) {
      x2 = x0 + x1;
      idx++;
      x0 = x1;
      x1 = x2;
    }
    return idx;
  }

  int[] fractionMultiplication(int[] a, int[] b) {

    class Helper {
      int gcdEuclid(int a, int b) {
        if (a == 0) {
          return b;
        }
        return gcdEuclid(b % a, a);
      }
    }
    Helper h = new Helper();

    int[] c = {a[0] * b[0], a[1] * b[1]};
    int gcd = h.gcdEuclid(c[0], c[1]);

    c[0] /= gcd;
    c[1] /= gcd;

    return c;
  }

  ArrayList<Double> liquidMixing(ArrayList<Integer> densities) {
    ArrayList<Double> result = new ArrayList<>();
    result.add((double) densities.get(0));
    for (int i = 1; i < densities.size(); i++) {
      for (int j = 0; j <= i; j++) {
        if (densities.get(i) <= densities.get(j)) {
          int tmp = densities.get(i);
          for (int k = i; k > j; k--) {
            densities.set(k, densities.get(k - 1));
          }
          densities.set(j, tmp);
          if (i % 2 == 1) {
            result.add((densities.get((i + 1) / 2) + densities.get(i / 2)) / 2.0);
          } else {
            result.add((double) densities.get(i / 2));
          }
          break;
        }
      }
    }
    return result;
  }

  boolean knightsAndKnaves(int[] answers) {

    int n = answers.length;
    boolean[] isKnight = new boolean[n];
    isKnight[0] = true;
    for (int i = 1; i < n; i++) {
      isKnight[i] = (answers[0] >> i & 1) == 1;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if ((isKnight[i] == isKnight[j]) || ((answers[i] >> j & 1) == 1)) {
          return false;
        }
      }
    }

    return true;
  }

  int leastCommonPrimeDivisor(int a, int b) {

    for (int divisor = 2; a > 1 && b > 1; divisor++) {
      if (a % divisor == 0 && b % divisor == 0) {
        return divisor;
      }
      while (a % divisor == 0) {
        a /= divisor;
      }
      while (b % divisor == 0) {
        b /= divisor;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Tour1110 t = new Tour1110();
    int[] values = {1, 6, 7};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t.knightsAndKnaves(values));
  }
}
