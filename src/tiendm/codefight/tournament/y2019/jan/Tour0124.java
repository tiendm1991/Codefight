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
      int a = s[i];
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

  int CrossingTheBridge(int[] times) {
    Arrays.sort(times);
    List<Integer> pass = new ArrayList<>();
    List<Integer> remain = new ArrayList<>();
    int s = 0;
    for (int i : times) {
      remain.add(i);
      s += i;
    }
    Collections.sort(remain);
    int c = 0;
    int x1 = remain.get(0);
    int x2 = remain.get(1);
    c += x2;
    remain.remove(1);
    remain.remove(0);
    pass.add(x1);
    pass.add(x2);
    Collections.sort(pass);
    int x3 = pass.get(0);;
    c += x3;
    pass.remove(0);
    remain.add(x3);
    while (remain.size() > 2) {
      Collections.sort(remain);
      if (remain.get(remain.size() - 1) > 2 * pass.get(0)) {
        x1 = remain.get(remain.size() - 2);
        x2 = remain.get(remain.size() - 1);
        c += x2;
        remain.remove(remain.size() - 1);
        remain.remove(remain.size() - 1);
        pass.add(x1);
        pass.add(x2);
      } else {
        x1 = remain.get(0);
        x2 = remain.get(remain.size() - 1);
        c += x2;
        remain.remove(0);
        remain.remove(remain.size() - 1);
        pass.add(x1);
        pass.add(x2);
      }
      Collections.sort(pass);
      x3 = pass.get(0);;
      c += x3;
      pass.remove(0);
      remain.add(x3);
    }
    int min = Math.max(remain.get(0), remain.get(1));
    return Math.min(c + min, s + (times.length - 3) * times[0]);
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


}
