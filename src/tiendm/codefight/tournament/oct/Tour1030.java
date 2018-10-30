package tiendm.codefight.tournament.oct;

import java.util.ArrayList;

public class Tour1030 {
  boolean increaseNumberRoundness(int n) {

    boolean gotToSignificant = false;
    while (n > 0) {
      if (n % 10 == 0 && gotToSignificant) {
        return true;
      } else if (n % 10 != 0) {
        gotToSignificant = true;
      }
      n /= 10;
    }

    return false;
  }

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

  public static void main(String[] args) {
    Tour1030 t = new Tour1030();
    int[] values = {7, 2};
    String[] s = {"a", "a", "ab", "ab", "abc"};
    System.out.println(t);
  }
}
