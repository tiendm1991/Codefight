package tiendm.codefight.tournament.y2019.Jan;

public class Tour0106 {
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

  public static void main(String[] args) {
    Tour0106 t = new Tour0106();
    System.out.println(t);
  }
}
