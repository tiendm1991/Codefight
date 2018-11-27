package tiendm.codefight.tournament.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1105 {
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

  int[] quickSort(int[] a, int l, int r) {

    if (l >= r) {
      return a;
    }

    int x = a[l];
    int i = l;
    int j = r;

    while (i <= j) {
      while (a[i] < x) {
        i++;
      }
      while (a[j] > x) {
        j--;
      }
      if (i <= j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        i++;
        j--;
      }
    }

    quickSort(a, l, i - 1);
    quickSort(a, i, r);

    return a;
  }

  int[] theJanitor(String word) {
    int[] arr = new int[26];
    ArrayList<Character> newArr = new ArrayList<>();

    for (int i = 0; i < word.length(); i++) {
      if (newArr.indexOf(word.charAt(i)) == -1)
        newArr.add(word.charAt(i));
    }

    for (Character aNewArr : newArr) {
      int tmp = aNewArr - 'a';
      arr[tmp] = word.lastIndexOf(aNewArr) - word.indexOf(aNewArr) + 1;
    }

    return arr;
  }

  ArrayList<String> generatePalindromes(String charactersSet) {

    class Helper {
      int N;
      char[] palindrome;
      int[] letterCnt;
      ArrayList<String> result = new ArrayList<>();

      Helper(String charactersSet) {
        N = charactersSet.length();
        palindrome = new char[N];
        letterCnt = new int[26];
        for (int i = 0; i < N; i++) {
          letterCnt[charactersSet.charAt(i) - 'a']++;
        }
        if (N % 2 == 1) {
          for (int i = 0; i < 26; i++) {
            if (letterCnt[i] % 2 == 1) {
              letterCnt[i]--;
              palindrome[N / 2] = (char) ('a' + i);
              break;
            }
          }
        }
      }

      void generate(int idx) {
        if (idx >= N / 2) {
          result.add(new String(palindrome));
          return;
        }
        for (int i = 0; i < 26; i++) {
          if (letterCnt[i] >= 2) {
            letterCnt[i] -= 2;
            palindrome[idx] = (char) ('a' + i);
            palindrome[N - idx - 1] = (char) ('a' + i);
            generate(idx + 1);
            letterCnt[i] += 2;
          }
        }
      }
    }
    Helper h = new Helper(charactersSet);

    h.generate(0);
    return h.result;
  }

  int lrSegmentNumber(int l, int r) {
    int result = 0;
    while (l <= r) {
      result = result * 10 + l;
      l++;
    }
    return result;
  }

  double arrayMedian(int[] sequence) {
    int len = sequence.length;
    Arrays.sort(sequence);

    if (len % 2 == 0) {
      return (sequence[len / 2] + sequence[len / 2 - 1]) / 2.0;
    } else {
      return sequence[len / 2];
    }
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

  int factorSum(int n) {

    int prevValue = 0, currentValue = 0, nextValue = n;

    do {
      int divisor = 2;
      currentValue = nextValue;
      prevValue = nextValue;
      nextValue = 0;
      while (divisor * divisor <= currentValue) {
        if (currentValue % divisor == 0) {
          currentValue /= divisor;
          nextValue += divisor;
        } else {
          divisor++;
        }
      }
      nextValue += currentValue;
    } while (nextValue != prevValue);

    return nextValue;
  }

  int champernowneDigit(int n) {

    for (int i = 1;; i++) {
      int number = i;
      ArrayList<Integer> digits = new ArrayList<>();
      while (number != 0) {
        digits.add(number % 10);
        number = number / 10;
      }
      Collections.reverse(digits);
      if (n <= digits.size()) {
        return digits.get(n - 1);
      }
      n -= digits.size();
    }
  }

  boolean isGeometricProgression(int[] sequence) {

    for (int i = 1; i < sequence.length - 1; i++) {
      if (sequence[i - 1] * sequence[i + 1] != sequence[i] * sequence[i]) {
        return false;
      }
    }
    return true;
  }

  int[] lazyFriends(int[] houses, int maxDist) {
    int[] result = new int[houses.length];
    for (int i = 0; i < houses.length; i++) {
      int c = 0;
      for (int j = 0; j < houses.length; j++) {
        if (j != i && Math.abs(houses[i] - houses[j]) <= maxDist) {
          c++;
        }
      }
      result[i] = c;
    }
    return result;
  }

  public static void main(String[] args) {
    Tour1105 t = new Tour1105();
    int[] values = {1, 2, 4, 8, 10};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    String[] split = " abc   a aa  a a ".split(" ");
    System.out.println(t.lazyFriends(values, 5));
  }
}
