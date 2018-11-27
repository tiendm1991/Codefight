package tiendm.codefight;

import java.util.Arrays;

public class Util {

  void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  <T> void swapObj(T[] arr, int i, int j) {
    T tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  boolean binarySearch(int[] arr, int i, int begin, int end) {
    if (begin == end) {
      return arr[begin] == i;
    }
    int mid = (begin + end) / 2;
    if (arr[mid] == i)
      return true;
    else if (arr[mid] < i) {
      return binarySearch(arr, i, mid + 1, end);
    } else {
      return binarySearch(arr, i, begin, mid);
    }
  }

  boolean isPrime(int x) {
    if (x == 2 || x == 3)
      return true;
    for (int i = 2; i <= x / 2; i++) {
      if (x % i == 0)
        return false;
    }
    return true;
  }

  int chessKnight(String cell) {
    int row = Integer.parseInt("" + cell.charAt(1)), column = cell.charAt(0) - 'a' + 1;
    int[][] steps = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    int answer = 0;

    for (int i = 0; i < steps.length; i++) {
      int tmpRow = row + steps[i][0];
      int tmpColumn = column + steps[i][1];
      if (tmpRow >= 1 && tmpRow <= 8 && tmpColumn >= 1 && tmpColumn <= 8) {
        answer++;
      }
    }

    return answer;
  }

  int countSumOfTwoRepresentations(int n, int l, int r) {
    int result = 0;
    for (int a = l; a <= r; a++) {
      for (int b = a; b <= r; b++) {
        if (a + b == n) {
          result++;
          break;
        }
      }
    }
    return result;
  }

  int countSumOfTwoRepresentations2(int n, int l, int r) {
    int c = 0;
    for (int i = l; i <= r; i++) {
      if (i <= n - i && n - i <= r)
        c++;
    }
    return c;
  }

  int countSumOfTwoRepresentations3(int n, int l, int r) {
    int result = 0;

    for (int i = 1; i <= n - i; i++) {
      if (l <= i && n - i <= r) {
        result++;
      }
    }

    return result;
  }

  int digitSum(int n) {
    int s = 0;
    while (n > 0) {
      s += n % 10;
      n /= 10;
    }
    return s;
  }

  int gcd(int a, int b) {
    while (a % b != 0) {
      int tmp = b;
      b = a % b;
      a = tmp;
    }
    return b;
  }

  int fact(int n) {
    if (n == 0)
      return 1;
    return fact(n - 1) * n;
  }

  int combine1(int k, int n) {
    return fact(n) / (fact(k) * fact(n - k));
  }

  int combine2(int k, int n) {
    if (k == 0 || k == n)
      return 1;
    if (k == 1 || k == n - 1)
      return n;
    return combine2(k - 1, n - 1) + combine2(k, n - 1);
  }

  int combine3(int n, int k) {
    if (k == 0 || k == n)
      return 1;
    if (k == 1 || k == n - 1)
      return n;
    return combine2(n - 1, k - 1) + combine2(n - 1, k);
  }

  int fibo(int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    return fibo(n - 1) + fibo(n - 2);
  }

  int fibo2(int n) {
    int x0 = 0;
    int x1 = 1;
    int x2 = x0 + x1;
    for (int i = 2; i <= n; i++) {
      x2 = x1 + x0;
      x0 = x1;
      x1 = x2;
    }
    return x2;
  }

  int arrayMinimumAboveBound(int[] inputArray, int bound) {
    Arrays.sort(inputArray);
    for (int x : inputArray) {
      if (x > bound)
        return x;
    }
    return -1;
  }

  double distance(int x1, int x2, int y1, int y2) {
    return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

  int indexOf(int[] values, int check) {
    for (int i = 0; i < values.length; i++) {
      if (values[i] == check) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Util u = new Util();
    int k = 6;
    int n = 12;
    System.out.println(u.combine1(k, n));
    System.out.println(u.combine2(k, n));
  }
}
