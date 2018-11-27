package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Tour1023 {
  boolean charactersRearrangement(String string1, String string2) {
    char[] c1 = string1.toCharArray();
    char[] c2 = string2.toCharArray();
    if (c1.length != c2.length)
      return false;
    Arrays.sort(c1);
    Arrays.sort(c2);
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] != c2[i])
        return false;
    }
    return true;
  }

  int distinctDistances(int[] distances) {
    if (distances[2] > distances[1] + distances[0])
      return 4;
    return 3;
  }

  int[] improperFractionToMixed(int[] a) {
    int[] b = {a[0] % a[1], 0, 0};
    b[1] = a[0] - a[1] * b[0];
    b[2] = a[1];
    return b;
  }

  String decipher(String cipher) {

    String result = "";
    for (int i = 0; i < cipher.length();) {
      int len;
      if (cipher.charAt(i) == '1') {
        len = 3;
      } else {
        len = 2;
      }
      int code = Integer.parseInt(cipher.substring(i, i + len));
      result += (char) code;
      i += len;
    }

    return result;
  }

  boolean hangman(String word, String letters) {
    char[] chars = letters.toCharArray();
    List<Character> ls = new ArrayList<>();
    for (char c : chars) {
      ls.add(c);
    }
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      int x = ls.indexOf(c);
      if (x < 0) {
        return false;
      }
    }
    return true;
  }

  boolean isInsideTheCircle(int xa, int ya, int xc, int yc, int rc) {
    int dist = (yc - ya) * (yc - ya) + (xc - xa) * (xc - xa);
    rc *= rc;
    if (dist < rc) {
      return true;
    }
    return false;
  }

  int maxDigit(int n) {
    int max = n % 10;
    n /= 10;
    while (n > 0) {
      int x = n % 10;
      if (x > max) {
        max = x;
      }
      n /= 10;
    }
    return max;
  }

  int[] bfsDistancesUnweightedGraph(boolean[][] matrix, int startVertex) {

    boolean[] visited = new boolean[matrix.length];
    LinkedList<Integer> queue = new LinkedList<>();
    int[] distance = new int[matrix.length];

    visited[startVertex] = true;
    queue.add(startVertex);
    while (queue.size() != 0) {
      int currentVertex = queue.pop();
      visited[currentVertex] = true;
      for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
        if (matrix[currentVertex][nextVertex] && !visited[nextVertex]) {
          visited[nextVertex] = true;
          distance[nextVertex] = distance[currentVertex] + 1;
          queue.add(nextVertex);
        }
      }
    }

    return distance;
  }

  int countDigitsInNumber(int n) {
    int count = 0;
    while (n > 0) {
      count++;
      n /= 10;
    }
    return count;
  }

  int pagesNumberingWithInk(int current, int numberOfDigits) {
    int digitsInCurrent = countDigitsInNumber(current);
    while (numberOfDigits >= digitsInCurrent) {
      numberOfDigits -= digitsInCurrent;
      current++;
      digitsInCurrent = countDigitsInNumber(current);
    }
    return current - 1;
  }

  boolean higherVersion(String ver1, String ver2) {
    String[] v1 = ver1.split("\\.");
    String[] v2 = ver2.split("\\.");
    for (int i = 0; i < v1.length; i++) {
      if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
        return true;
      } else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
        return false;
      }
    }
    return false;
  }

  String longestWord(String text) {

    String[] s = null;
    if (text.contains(",")) {
      s = text.split(",");
    } else {
      s = text.split(" ");
    }
    String max = "";
    for (String x : s) {
      if (getLength(x) > getLength(max)) {
        max = x;
      }
    }
    return max.trim();
  }

  int getLength(String x) {
    x = x.toLowerCase().trim();
    int s = 0;
    for (int i = 0; i < x.length(); i++) {
      char c = x.charAt(i);
      if (c >= 'a' && c <= 'z') {
        s++;
      } else {
        break;
      }
    }
    return s;
  }

  int countWaysToChangeDigit(int value) {
    int answer = 0;
    while (value > 0) {
      answer += (9 - value % 10);
      value /= 10;
    }
    return answer;
  }

  boolean areIsomorphic(int[][] array1, int[][] array2) {
    if (array1.length != array2.length)
      return false;
    return IntStream.range(0, array1.length).allMatch(i -> array1[i].length == array2[i].length);
  }

  boolean checkSameElementExistence(int[] arr1, int[] arr2) {

    int i = 0;
    int j = 0;
    while (i < arr1.length && j < arr2.length) {
      if (arr1[i] == arr2[j]) {
        return true;
      }
      if (arr1[i] < arr2[j]) {
        i++;
      } else {
        j++;
      }
    }

    return false;
  }

  int sumBelowBound(int bound) {

    int left = 0, right = bound + 1;
    while (right - left > 1) {
      int middle = (left + right) / 2;
      if (middle * (middle + 1) / 2 <= bound) {
        left = middle;
      } else {
        right = middle;
      }
    }

    return left;
  }

  ArrayList<Integer> sortedIndices(ArrayList<Integer> a) {
    ArrayList<Integer> indices = new ArrayList<>();
    for (int i = 0; i < a.size(); i++) {
      indices.add(i);
    }
    for (int i = 0; i < a.size() - 1; i++) {
      for (int j = 0; j < a.size() - i - 1; j++) {
        if (a.get(indices.get(j)) > a.get(indices.get(j + 1))) {
          int tmp = indices.get(j + 1);
          indices.set(j + 1, indices.get(j));
          indices.set(j, tmp);
        }
      }
    }
    return indices;
  }

  int[] videoPart(String part, String total) {

    class Helper {

      int getSeconds(String time) {
        int h = Integer.parseInt(time.substring(0, 2)), m = Integer.parseInt(time.substring(3, 5)),
            s = Integer.parseInt(time.substring(6, 8));
        return h * 60 * 60 + m * 60 + s;
      }

      int gcd(int a, int b) {
        while (a > 0) {
          int tmp = a;
          a = b % a;
          b = tmp;
        }
        return b;
      }
    }
    Helper h = new Helper();

    int partTime = h.getSeconds(part);
    int totalTime = h.getSeconds(total);
    int divisor = h.gcd(partTime, totalTime);
    return new int[] {partTime / divisor, totalTime / divisor};
  }

  String capitalizeVowelsRegExp(String input) {
    String s = "aeiouy";
    String r = "";
    for (int i = 0; i < input.length(); i++) {
      String x = input.charAt(i) + "";
      if (s.contains(x)) {
        r += x.toUpperCase();
      } else {
        r += x;
      }
    }
    return r;
  }

  String runLengthEncoding(String inputString) {

    int repeatLength = 1;
    StringBuilder answer = new StringBuilder();
    for (int i = 1; i < inputString.length(); i++) {
      if (inputString.charAt(i) != inputString.charAt(i - 1)) {
        answer.append(repeatLength);
        answer.append(inputString.charAt(i - 1));
        repeatLength = 1;
      } else {
        repeatLength++;
      }
    }
    answer.append(repeatLength);
    answer.append(inputString.charAt(inputString.length() - 1));
    return answer.toString();
  }

  int parkingCost(String timeIn, String timeOut) {
    int diff =
        Integer.parseInt(timeOut.substring(0, 2)) * 60 + Integer.parseInt(timeOut.substring(3))
            - Integer.parseInt(timeIn.substring(0, 2)) * 60 - Integer.parseInt(timeIn.substring(3));
    if (diff <= 30) {
      return 0;
    }
    if (diff <= 120) {
      return (diff - 31) / 10 + 1;
    }
    return 9 + ((diff - 111) / 10) * 2;
  }

  char fractionComparison(int[] a, int[] b) {
    int x = a[0] * b[1];
    int y = a[1] * b[0];
    if (x == y) {
      return '=';
    } else if (x > y) {
      return '>';
    }
    return '<';
  }

  int divisorsPairs(int[] sequence) {

    int result = 0;

    for (int i = 0; i < sequence.length; i++) {
      for (int j = i + 1; j < sequence.length; j++) {
        if (sequence[i] % sequence[j] == 0 || sequence[j] % sequence[i] == 0) {
          result++;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Tour1023 t = new Tour1023();
    int[] values = {6, 2, 3, 8};
    System.out.println(t);
  }
}
