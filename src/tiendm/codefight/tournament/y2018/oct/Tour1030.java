package tiendm.codefight.tournament.y2018.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tour1030 {
  int trailingZeros(int n) {
    int answer = 0;
    while (n % 2 == 0) {
      n /= 2;
      answer++;
    }
    return answer;
  }

  ArrayList<String> isDivisibleBy3(String inputString) {

    int digitSum = 0;
    int leftBound = (int) '0';
    int rightBound = (int) '9';
    ArrayList<String> answer = new ArrayList<>();
    int asteriskPos = -1;
    StringBuilder input = new StringBuilder(inputString);

    for (int i = 0; i < inputString.length(); i++) {
      if (leftBound <= (int) inputString.charAt(i) && (int) inputString.charAt(i) <= rightBound) {
        digitSum += (int) inputString.charAt(i) - leftBound;
      } else {
        asteriskPos = i;
      }
    }

    for (int i = 0; i < 10; i++) {
      if ((digitSum + i) % 3 == 0) {
        input.setCharAt(asteriskPos, (char) (leftBound + i));
        answer.add(input.toString());
      }
    }

    return answer;
  }

  int maxSubarray(int[] inputArray) {
    int currentMax = 0;
    int max = 0;

    for (int i = 0; i < inputArray.length; i++) {
      currentMax = Math.max(0, currentMax + inputArray[i]);
      max = Math.max(max, currentMax);
    }

    return max;
  }

  String[] removeDuplicateStrings(String[] inputArray) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i < inputArray.length; i++) {
      if (i + 1 < inputArray.length && inputArray[i].equals(inputArray[i + 1])) {
        continue;
      }
      result.add(inputArray[i]);
    }
    return result.toArray(new String[0]);
  }

  int largestDistance(int[] a) {
    int min1 = a[0], max1 = a[0], min2 = a[1], max2 = a[1];
    for (int i = 0; i < a.length - 1; i += 2) {
      if (a[i] < min1)
        min1 = a[i];
      if (a[i] > max1)
        max1 = a[i];
    }
    for (int i = 1; i < a.length; i += 2) {
      if (a[i] < min2)
        min2 = a[i];
      if (a[i] > max2)
        max2 = a[i];
    }
    return Math.max(max1 - min1, max2 - min2);
  }

  int[] prefixFunctionNaive(String s) {
    int[] result = new int[s.length()];
    result[0] = 0;
    for (int i = 1; i < s.length(); i++) {
      if (result[i - 1] != 0 && s.charAt(result[i - 1]) == s.charAt(i)) {
        result[i] = result[i - 1] + 1;
      } else {
        if (s.charAt(i) == s.charAt(0)) {
          result[i] = 1;
        } else {
          result[i] = 0;
        }
      }
    }
    return result;
  }

  boolean isLowerTriangularMatrix(int[][] matrix) {

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < i; j++) {
        if (matrix[j][i] != 0) {
          return false;
        }
      }
    }
    return true;
  }

  int binarySearch(int[] inputArray, int searchElement) {

    int minIndex = -1;
    int maxIndex = inputArray.length;
    int currentIndex;
    int currentElement;

    while (minIndex < maxIndex - 1) {
      currentIndex = (minIndex + maxIndex) / 2;
      currentElement = inputArray[currentIndex];

      if (currentElement < searchElement) {
        minIndex = currentIndex;
      } else {
        maxIndex = currentIndex;
      }
    }

    if (maxIndex == inputArray.length || inputArray[maxIndex] != searchElement) {
      return -1;
    }
    return maxIndex;
  }

  String characterParity(char symbol) {
    String result = null;
    switch (symbol) {
      case '0':
      case '2':
      case '4':
      case '6':
      case '8':
        result = "even";
        break;
      case '1':
      case '3':
      case '5':
      case '7':
      case '9':
        result = "odd";
        break;
      default:
        result = "not a digit";
        break;
    }
    return result;
  }

  double arrayMedian(int[] sequence) {
    int len = sequence.length;
    Arrays.sort(sequence);

    if (len % 2 == 0) {
      return ((double) sequence[len / 2] + (double) sequence[len / 2 - 1]) / 2;
    } else {
      return sequence[(len - 1) / 2];
    }
  }

  int[] maxSumSegments(int[] inputArray) {

    int[] result = new int[inputArray.length];
    for (int i = 1; i <= inputArray.length; i++) {
      int sum = 0, mxSum = 0, index = 0;
      for (int j = 0; j < inputArray.length; j++) {
        sum += inputArray[j];
        if (j >= i) {
          sum -= inputArray[j - i];
        }
        if (j >= i - 1 && (index == -1 || sum >= mxSum)) {
          mxSum = sum;
          index = j - i + 1;
        }
      }
      result[i - 1] = index;
    }
    return result;
  }

  int leastCommonPrimeDivisor(int a, int b) {

    for (int divisor = 2; a > 1 && b > 1; divisor++) {
      if (a % divisor == 0 && b % divisor == 0) {
        return divisor;
      }
      while (a % divisor == 0) {
        a /= divisor;
      }
      while (b % divisor == 0) {
        b /= divisor;
      }
    }

    return -1;
  }

  int[] arrayPreviousLess(int[] items) {

    int[] result = new int[items.length];
    for (int i = 0; i < items.length; i++) {
      int substitute = -1;
      for (int j = 0; j < i; j++) {
        if (items[j] < items[i]) {
          substitute = items[j];
        }
      }
      result[i] = substitute;
    }

    return result;
  }

  boolean checkEqualFrequency(int[] inputArray) {

    int numberOfEqual = 1;

    Arrays.sort(inputArray);

    while (numberOfEqual < inputArray.length
        && inputArray[numberOfEqual - 1] == inputArray[numberOfEqual]) {
      numberOfEqual++;
    }

    if (inputArray.length % numberOfEqual != 0) {
      return false;
    }

    for (int i = 0; i < inputArray.length; i += numberOfEqual) {
      if (i != 0 && inputArray[i] == inputArray[i - 1]) {
        return false;
      }
      for (int j = i + 1; j < i + numberOfEqual; j++) {
        if (inputArray[j] != inputArray[j - 1]) {
          return false;
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Tour1030 t = new Tour1030();
    int[] values = {1, 3, 2, 1};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t.arrayMedian(values));
  }
}
