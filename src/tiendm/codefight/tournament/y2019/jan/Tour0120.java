package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;
import java.util.Arrays;

public class Tour0120 {
  int maxGCD(int[] sequence) {
    class Helper {
      int gcd(int a, int b) {
        if (b == 0) {
          return a;
        }
        return gcd(b, a % b);
      }
    };

    Helper h = new Helper();
    int bestRes = 0;

    for (int i = 0; i < sequence.length; i++) {
      int result = sequence[0];
      if (i == 0) {
        result = sequence[1];
      }
      for (int j = 0; j < sequence.length; j++) {
        if (j == i) {
          continue;
        }
        result = h.gcd(result, sequence[j]);
      }
      if (result > bestRes) {
        bestRes = result;
      }
    }

    return bestRes;
  }

  int[] eratosthenesSieve(int n) {

    ArrayList<Integer> primes = new ArrayList<>();
    boolean[] mayBePrime = new boolean[n + 1];
    Arrays.fill(mayBePrime, true);
    for (int i = 2; i <= n; i++) {
      if (mayBePrime[i]) {
        primes.add(i);
        for (int j = i; i * j <= n; j++) {
          mayBePrime[i * j] = false;
        }
      }
    }

    int[] result = new int[primes.size()];
    for (int i = 0; i < primes.size(); ++i) {
      result[i] = primes.get(i);
    }

    return result;
  }

  int deleteDigit(int n) {
    int answer = 0;
    ArrayList<Integer> digits = new ArrayList<>();
    while (n != 0) {
      digits.add(n % 10);
      n /= 10;
    }
    int number = 0;
    for (int deletedIndex = 0; deletedIndex < digits.size(); deletedIndex++) {
      number = 0;
      for (int i = digits.size() - 1; i >= 0; i--) {
        if (i != deletedIndex) {
          number = number * 10 + digits.get(i);
        }
      }
      answer = Math.max(number, answer);
    }
    return answer;
  }

  boolean isIPv4Address(String inputString) {

    int currentNumber = 0;
    boolean emptyField = true;
    int countNumbers = 0;

    inputString += '.';

    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) == '.') {
        if (emptyField) {
          return false;
        }
        countNumbers++;
        currentNumber = 0;
        emptyField = true;
      } else {
        int digit = inputString.charAt(i) - '0';
        if (digit < 0 || digit > 9) {
          return false;
        }
        emptyField = false;
        currentNumber = currentNumber * 10 + digit;
        if (currentNumber > 255) {
          return false;
        }
      }
    }
    return countNumbers == 4;
  }

  int chessBoardSquaresUnderQueenAttack(int a, int b) {

    class Helper {
      int a, b;

      int go(int x, int y, int dx, int dy) {
        if (x < 0 || x >= a || y < 0 || y >= b) {
          return 0;
        }
        return go(x + dx, y + dy, dx, dy) + 1;
      }
    };

    int res = 0;

    Helper h = new Helper();
    h.a = a;
    h.b = b;

    for (int i = 0; i < a; i++) {
      for (int j = 0; j < b; j++) {
        for (int dx = -1; dx <= 1; dx++) {
          for (int dy = -1; dy <= 1; dy++) {
            if (dx != 0 || dy != 0) {
              res += h.go(i + dx, j + dy, dx, dy);
            }
          }
        }
      }
    }

    return res;
  }

  int differentSymbolsNaive(String s) {

    int result = 0;

    for (int i = 0; i < 26; i++) {
      boolean found = false;
      for (int j = 0; j < s.length(); j++) {
        if (s.charAt(j) == 'a' + i) {
          found = true;
          break;
        }
      }
      if (found) {
        result++;
      }
    }
    return result;
  }

  int seatsInTheater(int nCols, int nRows, int col, int row) {
    return (nCols - col + 1) * (nRows - row);
  }

  int specialPolynomial(int x, int n) {
    int p = 1;
    while (true) {
      int s = 0;
      for (int i = 0; i <= p; i++) {
        s += Math.pow(x, i);
      }
      if (s > n) {
        break;
      }
      p++;
    }
    return p - 1;
  }

  int polynomialMinimum(int[] coeffs, int[] interval) {
    class Helper {
      int[] coeffs;

      Helper(int[] coeffs) {
        this.coeffs = coeffs;
      }

      int f(int x) {
        int res = 0;
        for (int c : coeffs) {
          res = res * x + c;
        }
        return res;
      }
    }

    Helper h = new Helper(coeffs);

    int l = interval[0];
    int r = interval[1];

    while (r - l >= 3) {
      int m1 = l + (r - l) / 3;
      int m2 = r - (r - l) / 3;
      if (h.f(m1) > h.f(m2)) {
        l = m1;
      } else {
        r = m2;
      }
    }

    int res = h.f(l);
    while (l <= r) {
      if (h.f(l) < res) {
        res = h.f(l);
      }
      l++;
    }

    return res;
  }

  int differentDigitsNumberSearch(int[] inputArray) {

    for (int i = 0; i < inputArray.length; i++) {
      int cur = inputArray[i];
      boolean[] was = new boolean[10];
      boolean ok = true;
      while (cur > 0) {
        if (was[cur % 10]) {
          ok = false;
          break;
        }
        was[cur % 10] = true;
        cur /= 10;
      }
      if (ok) {
        return inputArray[i];
      }
    }

    return -1;
  }

  int specialNumbers(int l, int r) {

    int ans = 0;
    for (int i = l; i <= r; i++) {
      char[] digits = String.valueOf(i).toCharArray();
      boolean ok = true;
      for (int j = 0; j < (digits.length + 1) / 2; j++) {
        if (digits[j] == '6' || digits[j] == '9') {
          ok &= digits[digits.length - 1 - j] == '9' - digits[j] + '6';
        } else if (digits[j] == '8' || digits[j] == '0') {
          ok &= digits[j] == digits[digits.length - 1 - j];
        } else {
          ok = false;
        }
      }
      if (ok) {
        ans++;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Tour0120 t = new Tour0120();
    int[] x = {1, 3, 2, 1};
  }
}
