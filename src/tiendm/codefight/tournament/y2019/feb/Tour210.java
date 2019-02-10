package tiendm.codefight.tournament.y2019.feb;

import java.util.ArrayList;

public class Tour210 {
  ArrayList<Integer> cyclicQueue(String[] commands) {

    final int maxSize = 10;
    int[] myQueue = new int[maxSize];
    ArrayList<Integer> answer = new ArrayList<>();
    int head = 0;
    int tail = 0;
    int sum = 0;

    for (int i = 0; i < commands.length; i++) {
      if (commands[i].equals("-")) {
        sum -= myQueue[head];
        head = (head + 1) % maxSize;
      } else {
        int value = 0;
        for (int j = 1; j < commands[i].length(); j++) {
          value = value * 10 + (int) commands[i].charAt(j) - (int) '0';
        }
        sum += value;
        myQueue[tail] = value;
        tail = (tail + 1) % maxSize;
      }
      answer.add(sum);
    }

    return answer;
  }

  public static void main(String[] args) {
    Tour210 t = new Tour210();
    System.err.println(t);
  }
}
