package tiendm.codefight.challenge.y2019.feb;


public class FillShortestPaths {
  char[][] fillShortestPaths(char[][] plan) {
    int R = plan.length;
    int C = plan[0].length;
    int rs = 0, cs = 0;
    boolean stop = false;
    for (int i = 0; i < R; i++) {
      if (stop) {
        break;
      }
      for (int j = 0; j < C; j++) {
        if (plan[i][j] == 's') {
          rs = i;
          cs = j;
          stop = true;
          break;
        }
      }
    }
    int x1 = rs;
    int x2 = R - rs -1;
    int x3 = cs;
    int x4 = C - cs -1;
    return plan;
  }
  
  public static void main(String[] args) {
    FillShortestPaths b = new FillShortestPaths();
    char[][] c = {
        {' ', ' ', ' ', ' ', ' ', ' '}, 
        {' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' '}, 
        {' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', 's', ' ', ' ', ' '}, 
        {' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' '}, 
        {' ', ' ', ' ', ' ', ' ', ' '},};
    System.out.println(b.fillShortestPaths(c));
  }
}
