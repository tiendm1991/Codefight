package tiendm.codefight.tournament.y2019.jan;

import java.util.Stack;

public class Tour0118 {
  boolean almostIncreasingSequence(int[] sequence) {
    int mask = -1;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i] <= sequence[i - 1]) {
        mask = i - 1;
        break;
      }
    }
    if (mask == -1) {
      return true;
    }
    boolean check1 = true, check2 = true;
    int pre = mask == 0 ? Integer.MIN_VALUE : sequence[mask - 1];
    for (int i = mask + 1; i < sequence.length; i++) {
      if (sequence[i] <= pre) {
        check1 = false;
        break;
      }
      pre = sequence[i];
    }
    pre = sequence[mask];
    for (int i = mask + 2; i < sequence.length; i++) {
      if (sequence[i] <= pre) {
        check2 = false;
        break;
      }
      pre = sequence[i];
    }
    return check1 || check2;
  }

  int matrixElementsSum(int[][] matrix) {
    int s = 0;
    for (int i = 0; i < matrix[0].length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        if (matrix[j][i] == 0) {
          break;
        }
        s += matrix[i][i];
      }
    }
    return s;
  }

  int shapeArea(int n) {
    return (2 * n - 1) * (2 * n - 1) - 2 * n * (n - 1);
  }

  String reverseInParentheses(String inputString) {
    String result = "";
    Stack<StringBuilder> stack = new Stack<>();
    for (int i = 0; i < inputString.length(); i++) {
      char c = inputString.charAt(i);
      if (c == '(') {
        stack.push(new StringBuilder());
      } else if (c == ')') {
        StringBuilder builder = stack.pop();
        String s = builder.reverse().toString();
        if (stack.isEmpty()) {
          result += s;
        } else {
          stack.peek().append(s);
        }
      } else {
        if (!stack.isEmpty()) {
          stack.peek().append(c);
        } else {
          result += c + "";
        }
      }
    }
    return result;
  }

  boolean palindromeRearranging(String inputString) {
    int[] count = new int[26];
    for (int i = 0; i < inputString.length(); i++) {
      count[inputString.charAt(i) - 'a']++;
    }
    int nbOdd = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] % 2 == 1)
        nbOdd++;
    }
    return nbOdd < 2;
  }

  public static void main(String[] args) {
    Tour0118 t = new Tour0118();
    System.out
        .println(t.reverseInParentheses("abc((ghi((mno((stu((xyz)wv))rqp))lkj))fed)((abcd))"));
  }
}
