package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tour0124 {
  String AlphabetEncode(String message) {
    String s = "";
    for (int i = 0; i < message.length(); i++) {
      char c = message.charAt(i);
      int x = c - 'a' + 1;
      if (c == 'z') {
        s += 'z';
        continue;
      }
      s += (char) ((x * x) % 26 + 96);
    }
    return s;
  }

  boolean AlphabetCheck(String letter, String word) {
    for (int i = 0; i < word.length(); i++) {
      String c = word.charAt(i) + "";
      if (!letter.contains(c)) {
        return false;
      }
    }
    return true;
  }

  boolean Overlapping(int[] arr) {
    if (arr[0] > arr[1] || arr[2] > arr[3])
      return false;
    return Math.abs(arr[2] - arr[1]) + 1 >= arr[4];
  }

  int MaximumProfit(int[] s) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length - 1; i++) {
      for (int j = i + 1; j < s.length; j++) {
        if (s[j] > s[i]) {
          max = Math.max(max, s[j] - s[i]);
        }
      }
    }
    return max;
  }

  boolean DivisionPossible(int[] arr, int division) {
    int s = 0;
    for (int i : arr) {
      s += i;
    }
    if (s % division != 0) {
      return false;
    }
    int sum = s / division;
    Arrays.sort(arr);
    if (arr[arr.length - 1] > sum) {
      return false;
    }
    List<Integer> ls = new ArrayList<>();
    for (int i : arr) {
      ls.add(i);
    }
    int[] group = new int[division];
    boolean[] passed = new boolean[arr.length];
    return check(group, arr, sum, 0, passed);
  }


  boolean check(int[] group, int[] arr, int sum, int x, boolean[] passed) {
    int d = group.length;
    if (x == d) {
      return true;
    }
    for (int i = 0; i < arr.length; i++) {
      if (passed[i]) {
        continue;
      }
      group[x] += arr[i];
      passed[i] = true;
      boolean innerCheck = false;
      if (group[x] == sum) {
        innerCheck = check(group, arr, sum, x + 1, passed);
      } else if (group[x] < sum) {
        innerCheck = check(group, arr, sum, x, passed);
      }
      if (innerCheck) {
        return true;
      }
      passed[i] = false;
      group[x] -= arr[i];
      continue;
    }
    return false;
  }

  int KaprekarsConstant(int num) {
    int count = 0;
    String s = num + "";
    while (!s.equals("6174")) {
      char[] c = s.toCharArray();
      Arrays.sort(c);
      String new1 = new String(c);
      String new2 = new StringBuilder(new1).reverse().toString();
      int i1 = Integer.parseInt(new1);
      int i2 = Integer.parseInt(new2);
      num = Math.abs(i2 - i1);
      if (num < 1000) {
        s = "0" + num;
      } else {
        s = num + "";
      }
      count++;
    }
    return count;
  }

  int CrossingTheBridge(List<Integer> times) {
    Collections.sort(times);
    if (times.size() == 3) {
      return times.get(0) + times.get(1) + times.get(2);
    }
    if (times.size() == 4) {
      return Math.min(times.get(3) + 3 * times.get(1) + times.get(0),
          times.get(3) + times.get(2) + times.get(1) + 2 * times.get(0));
    }
    List<Integer> l1 = times.subList(0, times.size() - 1);
    List<Integer> l2 = times.subList(0, times.size() - 2);
    return Math.min(times.get(0) + times.get(times.size() - 1) + CrossingTheBridge(l1),
        2 * times.get(1) + times.get(0) + times.get(times.size() - 1) + CrossingTheBridge(l2));
  }

  public static void main(String[] args) {
    Tour0124 t = new Tour0124();
    Integer[] x = {3, 4, 4, 1, 5};
    List<Integer> a = Arrays.asList(x);
    System.out.println(t.CrossingTheBridge(a));
  }
}
