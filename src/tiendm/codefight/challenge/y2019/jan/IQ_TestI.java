package tiendm.codefight.challenge.y2019.jan;

public class IQ_TestI {
  int IQ_TestI(String[][] test) {
    int ROW = test.length;
    int COL = test[0].length;
    for (int x = 0; x <= 999999; x++) {
      Double result = (double) x;
      String op = "";
      for (int i = 1; i < COL; i++) {
        String s = test[0][i];
        if (getInt(s) == null) {
          op = s;
        } else {
          result = caculate(result, s, op);
          if (result == null) {
            break;
          }
        }
      }
      if (result == null) {
        continue;
      }
      for (int i = 1; i < ROW; i++) {
        String s = test[i][COL - 1];
        if (getInt(s) == null) {
          op = s;
        } else {
          result = caculate(result, s, op);
          if (result == null) {
            break;
          }
        }
      }
      if (result == null) {
        continue;
      }
      for (int i = COL - 2; i >= 0; i--) {
        String s = test[ROW - 1][i];
        if (getInt(s) == null) {
          op = s;
        } else {
          result = caculate(result, s, op);
          if (result == null) {
            break;
          }
        }
      }
      if (result == null) {
        continue;
      }
      for (int i = ROW - 2; i > 1; i--) {
        String s = test[i][0];
        if (getInt(s) == null) {
          op = s;
        } else {
          result = caculate(result, s, op);
          if (result == null) {
            break;
          }
        }
      }
      if (result == null) {
        continue;
      }
      if (result == x) {
        return x;
      }
    }
    return -1;
  }

  public Integer getInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (Exception e) {
      return null;
    }
  }

  public Double caculate(Double result, String b, String op) {
    double iB = getInt(b);
    switch (op) {
      case "+":
        return (result + iB);
      case "-":
        return (result - iB);
      case "*":
        return (result * iB);
      case "/":
        if (iB == 0) {
          return null;
        } else {
          return result / iB;
        }
      default:
        return null;
    }
  }

  public static void main(String[] args) {
    IQ_TestI i = new IQ_TestI();
    String[][] test = {{"?", "-", "3", "/", "13"}, {"=", "", "", "", "+"}, {"1", "", "", "", "2"},
        {"+", "4", "-", "9", "*"}};
    System.out.println(i.IQ_TestI(test));
  }
}
