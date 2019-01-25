package tiendm.codefight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

  int binomialCoefficient1(int k, int n) {
    return fact(n) / (fact(k) * fact(n - k));
  }

  int binomialCoefficient2(int k, int n) {
    if (k == 0 || k == n)
      return 1;
    if (k == 1 || k == n - 1)
      return n;
    return binomialCoefficient2(k - 1, n - 1) + binomialCoefficient2(k, n - 1);
  }

  int binomialCoefficient3(int n, int k) {
    if (k == 0 || k == n)
      return 1;
    if (k == 1 || k == n - 1)
      return n;
    return binomialCoefficient3(n - 1, k - 1) + binomialCoefficient3(n - 1, k);
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

  String AlphabetEncode(String message) {
    String s = "";
    for (int i = 0; i < message.length(); i++) {
      char c = message.charAt(i);
      int x = c - 'a' + 1;
      if (c == 'z') {
        s += 'z';
        continue;
      }
      s += (char) ((x * x) % 26 + 96);
    }
    return s;
  }

  boolean AlphabetCheck(String letter, String word) {
    for (int i = 0; i < word.length(); i++) {
      String c = word.charAt(i) + "";
      if (!letter.contains(c)) {
        return false;
      }
    }
    return true;
  }

  boolean Overlapping(int[] arr) {
    if (arr[0] > arr[1] || arr[2] > arr[3])
      return false;
    return Math.abs(arr[2] - arr[1]) + 1 >= arr[4];
  }

  int MaximumProfit(int[] s) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length - 1; i++) {
      int a = s[i];
      for (int j = i + 1; j < s.length; j++) {
        if (s[j] > s[i]) {
          max = Math.max(max, s[j] - s[i]);
        }
      }
    }
    return max;
  }

  boolean DivisionPossible(int[] arr, int division) {
    int s = 0;
    for (int i : arr) {
      s += i;
    }
    if (s % division != 0) {
      return false;
    }
    int sum = s / division;
    Arrays.sort(arr);
    if (arr[arr.length - 1] > sum) {
      return false;
    }
    List<Integer> ls = new ArrayList<>();
    for (int i : arr) {
      ls.add(i);
    }
    int[] group = new int[division];
    boolean[] passed = new boolean[arr.length];
    return check(group, arr, sum, 0, passed);
  }


  boolean check(int[] group, int[] arr, int sum, int x, boolean[] passed) {
    int d = group.length;
    if (x == d) {
      return true;
    }
    for (int i = 0; i < arr.length; i++) {
      if (passed[i]) {
        continue;
      }
      group[x] += arr[i];
      passed[i] = true;
      boolean innerCheck = false;
      if (group[x] == sum) {
        innerCheck = check(group, arr, sum, x + 1, passed);
      } else if (group[x] < sum) {
        innerCheck = check(group, arr, sum, x, passed);
      }
      if (innerCheck) {
        return true;
      }
      passed[i] = false;
      group[x] -= arr[i];
      continue;
    }
    return false;
  }

  int CrossingTheBridge(int[] times) {
    Arrays.sort(times);
    List<Integer> pass = new ArrayList<>();
    List<Integer> remain = new ArrayList<>();
    int s = 0;
    for (int i : times) {
      remain.add(i);
      s += i;
    }
    Collections.sort(remain);
    int c = 0;
    int x1 = remain.get(0);
    int x2 = remain.get(1);
    c += x2;
    remain.remove(1);
    remain.remove(0);
    pass.add(x1);
    pass.add(x2);
    Collections.sort(pass);
    int x3 = pass.get(0);;
    c += x3;
    pass.remove(0);
    remain.add(x3);
    while (remain.size() > 2) {
      Collections.sort(remain);
      if (remain.get(remain.size() - 1) > 2 * pass.get(0)) {
        x1 = remain.get(remain.size() - 2);
        x2 = remain.get(remain.size() - 1);
        c += x2;
        remain.remove(remain.size() - 1);
        remain.remove(remain.size() - 1);
        pass.add(x1);
        pass.add(x2);
      } else {
        x1 = remain.get(0);
        x2 = remain.get(remain.size() - 1);
        c += x2;
        remain.remove(0);
        remain.remove(remain.size() - 1);
        pass.add(x1);
        pass.add(x2);
      }
      Collections.sort(pass);
      x3 = pass.get(0);;
      c += x3;
      pass.remove(0);
      remain.add(x3);
    }
    int min = Math.max(remain.get(0), remain.get(1));
    return Math.min(c + min, s + (times.length - 3) * times[0]);
  }

  int KaprekarsConstant(int num) {
    int count = 0;
    String s = num + "";
    while (!s.equals("6174")) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String new1 = new String(c);
      String new2 = new StringBuilder(new1).reverse().toString();
      int i1 = Integer.parseInt(new1);
      int i2 = Integer.parseInt(new2);
      num = Math.abs(i2 - i1);
      if (num < 1000) {
        s = "0" + num;
      } else {
        s = num + "";
      }
      count++;
    }
    return count;
  }



  public static void main(String[] args) {
    Util u = new Util();
    int[] x = {8, 1, 2, 19, 2};
    System.out.println(u.Overlapping(x));
  }
}
