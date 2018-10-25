package tiendm.codefight.tournament.oct;

import java.util.ArrayList;

public class Tour1025 {
  int howManySundays(int n, String startDay) {

    String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int startIndex = 0;

    for (int i = 0; i < week.length; i++) {
      if (week[i].equals(startDay)) {
        startIndex = i;
        break;
      }
    }

    return (n + startIndex) / week.length;
  }

  int graphEdges(boolean[][] matrix) {
    int s = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[i][j])
          s++;
      }
    }
    return s / 2;
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
          if (letterCnt[i] > 1) {
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

  int mirrorBits(int a) {

    int b = 0;
    while (a > 0) {
      b <<= 1;
      b |= a & 1;
      a >>= 1;
    }

    return b;
  }

  int centuryFromYear(int year) {
    return (year - 1) / 100 + 1;
  }

  int arrayMaxConsecutiveSum(int[] inputArray, int k) {

    int result = 0, currentSum = 0;

    for (int i = 0; i < k - 1; i++) {
      currentSum += inputArray[i];
    }
    for (int i = k - 1; i < inputArray.length; i++) {
      currentSum += inputArray[i];
      if (currentSum > result) {
        result = currentSum;
      }
      currentSum -= inputArray[i - k + 1];
    }

    return result;
  }

  int divideAsLongAsPossible(int n, int d) {
    if (n % d != 0)
      return n;
    return divideAsLongAsPossible(n / d, d);
  }

  void merge(int[] sequence, int left, int middle, int right) {
    int[] result = new int[right - left];
    int i, j;
    int k = 0;

    for (i = left, j = middle; i < middle && j < right;) {
      if (sequence[i] < sequence[j]) {
        result[k++] = sequence[i];
        i++;
      } else {
        result[k++] = sequence[j];
        j++;
      }
    }

    while (i < middle) {
      result[k++] = sequence[i];
      i++;
    }

    while (j < right) {
      result[k++] = sequence[j];
      j++;
    }

    for (i = left; i < right; i++) {
      sequence[i] = result[i - left];
    }
  }

  void split(int[] sequence, int left, int right) {
    if (left + 1 == right) {
      return;
    }
    int middle = (left + right) / 2;
    split(sequence, left, middle);
    split(sequence, middle, right);
    merge(sequence, left, middle, right);
  }

  int[] mergeSort(int[] sequence) {
    split(sequence, 0, sequence.length);

    return sequence;
  }


  public static void main(String[] args) {
    Tour1025 t = new Tour1025();
    int[] values = {6, 2, 3, 8};
    System.out.println(t);
  }
}
