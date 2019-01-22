package tiendm.codefight.challenge.y2019.jan;

public class KStepMaximization {
  int kStepMaximization(int n, int k) {
    if (k <= 0) {
      return n;
    }
    int a = kStepMaximization(n + 1, k - 1);
    int b = kStepMaximization(n * 2, k - 1);
    int c = kStepMaximization(rotate(n), k - 1);
    return Math.max(Math.max(a, b), c);
  }

  int rotate(int n) {
    int result = 0;
    while (n > 0) {
      result = result * 10 + rotateDigit(n % 10);
      n /= 10;
    }
    return result;
  }

  int rotateDigit(int x) {
    switch (x) {
      case 0:
        return 0;
      case 1:
        return 1;
      case 2:
        return 2;
      case 5:
        return 5;
      case 6:
        return 9;
      case 8:
        return 8;
      case 9:
        return 6;
      default:
        return -1;
    }
  }
}
