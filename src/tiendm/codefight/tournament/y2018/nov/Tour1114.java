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

  boolean whitespaceSearchRegExp(String input) {

    return java.util.regex.Pattern.compile("\\s").matcher(input).find();
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
