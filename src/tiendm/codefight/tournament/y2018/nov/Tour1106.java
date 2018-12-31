package tiendm.codefight.tournament.y2018.nov;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1106 {
  int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 16; i++) {
      res = (res * 2 + n % 2);
      n /= 2;
    }
    return res;
  }

  List<String> lrc2subRip(String[] lrcLyrics, String songLength) {
    List<String> ls = new ArrayList<>();
    for (int i = 0; i < lrcLyrics.length; i++) {
      ls.add((i + 1) + "");
      String s = lrcLyrics[i];
      int idx = s.indexOf("]");
      String time1 = convertToHour(s);
      String time2 = "";
      if (i == lrcLyrics.length - 1) {
        time2 = songLength + ",000";
      } else {
        time2 = convertToHour(lrcLyrics[i + 1]);
      }
      ls.add(time1 + " --> " + time2);
      if (s.length() > 11) {
        ls.add(s.substring(idx + 2));
      } else {
        ls.add("");
      }
      if (i != lrcLyrics.length - 1) {
        ls.add("");
      }
    }

    return ls;

  }

  String convertToHour(String s) {
    int idx1 = s.indexOf("[");
    int idx2 = s.indexOf("]");
    String[] str = s.substring(idx1 + 1, idx2).split(":");
    int minute = Integer.parseInt(str[0]);
    int hour = 0;
    if (minute >= 60) {
      hour = minute / 60;
      minute = minute % 60;
    }
    String strHour = String.format("%02d", hour);
    String strMinute = String.format("%02d", minute);
    return strHour + ":" + strMinute + ":" + str[1].replace('.', ',') + "0";
  }

  boolean isLucky(int n) {

    ArrayList<Integer> digits = new ArrayList<>();
    int sum = 0;

    while (n > 0) {
      digits.add(n % 10);
      n /= 10;
    }

    for (int i = 0; i < digits.size(); i++) {
      if (i < digits.size() / 2) {
        sum += digits.get(i);
      } else {
        sum -= digits.get(i);
      }
    }

    if (sum != 0) {
      return false;
    }
    return true;
  }

  int[] fractionSubtraction(int[] a, int[] b) {

    class Helper {
      int gcdEuclid(int a, int b) {
        if (a == 0) {
          return b;
        }
        return gcdEuclid(b % a, a);
      }
    }
    Helper h = new Helper();

    int[] c = {a[0] * b[1] - a[1] * b[0], a[1] * b[1]};
    int gcd = h.gcdEuclid(c[0], c[1]);

    c[0] /= gcd;
    c[1] /= gcd;

    return c;
  }

  int eulersTotientFunction(int n) {
    int divisor = 2, result = n;

    while (divisor * divisor <= n) {
      if (n % divisor == 0) {
        while (n % divisor == 0) {
          n /= divisor;
        }
        result -= result / divisor;
      }
      divisor++;
    }
    if (n > 1) {
      result -= result / n;
    }

    return result;
  }

  int[] maxSumSegments(int[] inputArray) {

    int[] result = new int[inputArray.length];
    for (int i = 1; i <= inputArray.length; i++) {
      int sum = 0, mxSum = 0, index = -1;
      for (int j = 0; j < inputArray.length; j++) {
        sum += inputArray[j];
        if (j >= i) {
          sum -= inputArray[j - i];
        }
        if (j >= i - 1 && (index == -1 || sum > mxSum)) {
          mxSum = sum;
          index = j - i + 1;
        }
      }
      result[i - 1] = index;
    }
    return result;
  }

  int arrayKthGreatest(int[] inputArray, int k) {

    for (int i = 0; i < k; i++) {
      int indexOfMaximum = i, tmp = inputArray[i];

      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[j] > inputArray[indexOfMaximum]) {
          indexOfMaximum = j;
        }
      }
      inputArray[i] = inputArray[indexOfMaximum];
      inputArray[indexOfMaximum] = tmp;
    }

    return inputArray[k - 1];
  }

  int additionWithoutCarrying(int param1, int param2) {
    int result = 0;
    int tenPower = 1;
    while (param1 > 0 || param2 > 0) {
      result += tenPower * ((param1 + param2) % 10);
      param1 /= 10;
      param2 /= 10;
      tenPower *= 10;
    }
    return result;
  }

  int[] primeFactors(int n) {
    ArrayList<Integer> factors = new ArrayList<>();
    int divisor = 2;

    while (n >= 2) {
      if (n % divisor == 0) {
        factors.add(divisor);
        n /= divisor;
        divisor = 2;
      } else {
        divisor++;
      }
    }

    int[] ans = new int[factors.size()];
    for (int i = 0; i < ans.length; ++i) {
      ans[i] = factors.get(i);
    }
    return ans;
  }

  String substitutionCipherDecryption(String contents, String signature,
      String encryptedSignature) {
    char[] plaintext = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char[] ciphertext = new char[plaintext.length];
    for (int i = 0; i < signature.length(); i++) {
      ciphertext[signature.charAt(i) - 'a'] = encryptedSignature.charAt(i);
    }
    int i = 0;
    for (char c : plaintext) {
      if (encryptedSignature.contains(c + "")) {
        continue;
      }
      while (ciphertext[i] >= 'a' && ciphertext[i] <= 'z') {
        i++;
      }
      ciphertext[i] = c;
      i++;
    }
    String result = "";
    String strCiphertext = new String(ciphertext);
    for (int j = 0; j < contents.length(); j++) {
      char c = contents.charAt(j);
      result += plaintext[strCiphertext.indexOf(c)];
    }
    return result;
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
            if (!(dx == 0 && dy == 0)) {
              res += h.go(i + dx, j + dy, dx, dy);
            }
          }
        }
      }
    }

    return res;
  }

  int permutationShift(int[] permutation) {
    int minShift = 0, maxShift = 0;
    for (int i = 0; i < permutation.length; i++) {
      if (permutation[i] - i > maxShift) {
        maxShift = permutation[i] - i;
      }
      if (permutation[i] - i < minShift) {
        minShift = permutation[i] - i;
      }
    }
    return maxShift - minShift;
  }

  int commonPoints(int l1, int r1, int l2, int r2) {
    int result = Math.min(r2, r1) - Math.max(l2, l1) - 1;
    if (result < 0) {
      result = 0;
    }
    return result;
  }

  String[] isDivisibleBy6(String inputString) {

    int digitSum = 0;
    char leftBound = '0', rightBound = '9';
    ArrayList<String> answer = new ArrayList<>();
    char[] mask = inputString.toCharArray();
    int asteriskPos = -1;

    for (int i = 0; i < mask.length; i++) {
      if (leftBound <= mask[i] && mask[i] <= rightBound) {
        digitSum += mask[i] - leftBound;
      } else {
        asteriskPos = i;
      }
    }

    for (int i = 0; i < 10; i++) {
      if ((digitSum + i) % 3 == 0) {
        mask[asteriskPos] = (char) (leftBound + i);
        if ((mask[mask.length - 1] - leftBound) % 2 == 0) {
          answer.add(String.valueOf(mask));
        }
      }
    }

    return answer.toArray(new String[0]);
  }

  boolean isPrime(int n) {
    int divisor = 2;
    while (n > divisor) {
      if (n % divisor == 0) {
        return false;
      } else {
        divisor++;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Tour1106 t = new Tour1106();
    int[] values = {1, 2, 4, 8, 10};
    String[] s = {};
    int h = 3;
    System.out.println(t.substitutionCipherDecryption("issomtoqmvjts", "alice", "james"));
  }
}
