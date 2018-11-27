package tiendm.codefight.tournament.nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1108 {
  int sumOfCoprimes(int m) {

    int ans = 0;
    for (int p = 2; p <= m; p++) {
      int a = p;
      int b = m;
      while (a > 0) {
        int tmp = b % a;
        b = a;
        a = tmp;
      }

      if (b == 1) {
        ans += p;
      }
    }

    return ans;
  }

  boolean validTime(String time) {

    class Helper {
      int charToInt(char symbol) {
        return symbol - '0';
      }
    }
    Helper h = new Helper();

    int hours = h.charToInt(time.charAt(0)) * 10 + h.charToInt(time.charAt(1)),
        minutes = h.charToInt(time.charAt(3)) * 10 + h.charToInt(time.charAt(4));

    if (hours < 24 && minutes < 60) {
      return true;
    }
    return false;
  }

  int[] maximalAllowableSubarrays(int[] inputArray, int maxSum) {

    int[] right = new int[inputArray.length];
    int j = -1;
    int curSum = 0;
    for (int i = 0; i < inputArray.length; i++) {
      if (i > 0) {
        curSum -= inputArray[i - 1];
      }
      while (j + 1 < inputArray.length && curSum + inputArray[j + 1] <= maxSum) {
        curSum += inputArray[++j];
      }
      right[i] = j;
    }

    return right;
  }

  int arrayChange(int[] inputArray) {

    int result = 0;

    for (int i = 1; i < inputArray.length; i++) {
      if (inputArray[i] <= inputArray[i - 1]) {
        result += (inputArray[i - 1] - inputArray[i] + 1);
        inputArray[i] = inputArray[i - 1] + 1;
      }
    }
    return result;
  }

  boolean variableName(String name) {

    for (int i = 0; i < name.length(); i++) {
      if (!('a' <= name.charAt(i) && name.charAt(i) <= 'z'
          || 'A' <= name.charAt(i) && name.charAt(i) <= 'Z'
          || '0' <= name.charAt(i) && name.charAt(i) <= '9' || name.charAt(i) == '_')) {
        return false;
      }
    }

    if ('0' <= name.charAt(0) && name.charAt(0) <= '9') {
      return false;
    }

    return true;
  }

  int commonCharacterCount(String s1, String s2) {
    HashMap<Character, Integer> map1 = new HashMap<>();
    HashMap<Character, Integer> map2 = new HashMap<>();
    int answer = 0;
    for (int i = 0; i < s1.length(); i++) {
      char ch = s1.charAt(i);
      map1.put(ch, map1.containsKey(ch) ? (map1.get(ch) + 1) : 1);
    }
    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      map2.put(ch, map2.containsKey(ch) ? (map2.get(ch) + 1) : 1);
    }
    for (char ch = 'a'; ch <= 'z'; ch++) {
      if (map1.containsKey(ch) && map2.containsKey(ch)) {
        answer += Math.min(map1.get(ch), map2.get(ch));
      }
    }
    return answer;
  }

  int polishNotation(String[] tokens) {
    class Helper {
      boolean isNumber(String stringRepresentation) {
        return stringRepresentation.length() > 1
            || '0' <= stringRepresentation.charAt(0) && stringRepresentation.charAt(0) <= '9';
      }
    };
    List<String> myStack = new ArrayList<>();
    Helper h = new Helper();

    for (int i = 0; i < tokens.length; i++) {
      myStack.add(tokens[i]);
      while (myStack.size() > 2 && h.isNumber(myStack.get(myStack.size() - 1))
          && h.isNumber(myStack.get(myStack.size() - 2))) {
        int leftOperand = Integer.parseInt(myStack.get(myStack.size() - 2));
        int rightOperand = Integer.parseInt(myStack.get(myStack.size() - 1));
        int result = 0;
        if (myStack.get(myStack.size() - 3).equals("-")) {
          result = leftOperand - rightOperand;
        }
        if (myStack.get(myStack.size() - 3).equals("+")) {
          result = leftOperand + rightOperand;
        }
        if (myStack.get(myStack.size() - 3).equals("*")) {
          result = leftOperand * rightOperand;
        }
        myStack = myStack.subList(0, myStack.size() - 3);
        myStack.add(Integer.toString(result));
      }
    }

    return Integer.parseInt(myStack.get(0));
  }

  public static void main(String[] args) {
    Tour1108 t = new Tour1108();
    int[] values = {-1000, 0, -2, 0};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t.polishNotation(s));
  }
}
