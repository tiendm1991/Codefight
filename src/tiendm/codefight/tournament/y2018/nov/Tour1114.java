package tiendm.codefight.tournament.y2018.nov;

import java.util.ArrayList;
import java.util.List;

public class Tour1114 {
  int[] nextSecond(int[] currentTime) {

    if (currentTime[2] == 59) {
      currentTime[2] = 0;
      if (currentTime[1] == 59) {
        currentTime[1] = 0;
        currentTime[0] = (currentTime[0] + 1) % 24;
      } else {
        currentTime[1]++;
      }
    } else {
      currentTime[2]++;
    }

    return currentTime;
  }

  int[] fractionSum(int[] a, int[] b) {

    class Helper {
      int gcdEuclid(int a, int b) {
        if (a == 0) {
          return b;
        }
        return gcdEuclid(b % a, a);
      }
    }
    Helper h = new Helper();

    int[] c = {a[0] * b[1] + a[1] * b[0], a[1] * b[1]};
    int gcd = h.gcdEuclid(c[0], c[1]);

    c[0] /= gcd;
    c[1] /= gcd;

    return c;
  }

  boolean whitespaceSearchRegExp(String input) {

    return java.util.regex.Pattern.compile("\\s").matcher(input).find();
  }

  boolean isPangram(String sentence) {
    boolean[] found = new boolean[26];
    boolean result = true;
    for (int i = 0; i < sentence.length(); i++) {
      int code = (int) sentence.charAt(i);
      if ((int) 'A' <= code && code <= (int) 'Z') {
        code += (int) 'a' - (int) 'A';
      }
      if ((int) 'a' <= code && code <= (int) 'z') {
        found[code - 'a'] = true;
      }
    }

    for (int i = 0; i < 26; i++) {
      if (!found[i]) {
        result = false;
      }
    }

    return result;
  }

  boolean bettingGame(int[] l) {

    int s = 0;
    for (int i = 0; i < l.length; i++) {
      s += l[i];
    }
    if (s == 0) {
      return false;
    }

    return s % l.length == 0;
  }

  int[] subtractionByRegrouping(int minuend, int subtrahend) {
    List<Integer> ls = new ArrayList<>();
    int borrow = 0;
    while (minuend > 0) {
      int x = minuend % 10 - borrow;
      int y = subtrahend % 10;
      if (x < y) {
        ls.add(x + 10);
        borrow = 1;
      } else {
        ls.add(x);
        borrow = 0;
      }
      minuend /= 10;
      subtrahend /= 10;
    }
    return ls.stream().mapToInt(x -> x).toArray();
  }

  int rightmostRoundNumber(int[] inputArray) {
    for (int i = inputArray.length - 1; i >= 0; i--) {
      if (inputArray[i] % 10 == 0) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Tour1114 t = new Tour1114();
    int[] values = {1, 6, 7};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t.subtractionByRegrouping(2024, 1234));
  }
}
