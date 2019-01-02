package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterviewDynamicPrograming {

  // ----------climbingStairs
  int climbingStairs(int n) {
    if (n <= 2)
      return n;
    int x1 = 1, x2 = 2, x3 = 0;
    int i = 3;
    while (i <= n) {
      x3 = x1 + x2;
      x1 = x2;
      x2 = x3;
      i++;
    }
    return x3;
  }

  int climbingStairsRecursive(int n) {
    if (n <= 2)
      return n;
    return climbingStairsRecursive(n - 1) + climbingStairsRecursive(n - 2);
  }

  // ----------climbingStairs
  int houseRobber(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    }
    return dp[dp.length - 1];
  }

  // -----composeRanges
  List<String> composeRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if (nums.length == 0) {
      return result;
    }
    if (nums.length == 1) {
      result.add(nums[0] + "");
      return result;
    }
    String strCur = nums[0] + "";
    int cur = nums[0];
    boolean single = true;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == cur + 1) {
        if (i == nums.length - 1) {
          strCur += "->" + nums[i];
          result.add(strCur);
          break;
        }
        cur = nums[i];
        single = false;
      } else {
        if (single) {
          result.add(strCur);
        } else {
          strCur += "->" + cur;
          result.add(strCur);
        }
        cur = nums[i];
        strCur = cur + "";
        single = true;
        if (i == nums.length - 1) {
          result.add(cur + "");
        }
      }
    }
    return result;
  }

  int mapDecoding(String message) {
    String[] arr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
        "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};
    List<String> legal = Stream.of(arr).map(e -> e).collect(Collectors.toList());
    if (message.length() == 1 && !legal.contains(message)) {
      return 0;
    }
    if (message.length() == 0 || (message.length() == 1 && legal.contains(message))) {
      return 1;
    }
    int MAX = (int) (Math.pow(10, 9) + 7);
    char idx0 = message.charAt(message.length() - 1);
    char idx1 = message.charAt(message.length() - 2);
    int x0 = legal.contains(idx0 + "") ? 1 : 0;
    int x1 = idx1 == '0' ? 0 : legal.contains(idx1 + "" + idx0) ? 1 + x0 : x0;
    int x2 = x1;
    int i = message.length() - 3;
    while (i >= 0) {
      idx0 = message.charAt(i);
      idx1 = message.charAt(i + 1);
      if (idx0 == '0') {
        x2 = 0;
        x0 = x1;
        x1 = x2;
      } else if (legal.contains(idx0 + "" + idx1)) {
        x2 = (x1 + x0) % MAX;
        x0 = x1;
        x1 = x2;
      } else {
        x2 = x1;
        x0 = x1;
        x1 = x2;
      }
      i--;
    }
    return x2;
  }

  // ----mapDecoding revursive
  private int map(String message, List<String> legal, Map<String, Integer> cache, final int MAX) {
    if (message.length() == 0 || (message.length() == 1 && legal.contains(message))) {
      cache.put(message, 1);
      return 1;
    }
    if (message.startsWith("0")) {
      cache.put(message, 0);
      return 0;
    }
    Integer value = cache.get(message);
    if (value != null) {
      return value;
    }
    String s = message.substring(0, 2);
    String s1 = message.substring(1);
    String s2 = message.substring(2);
    if (legal.contains(s)) {
      Integer x2 = map(s2, legal, cache, MAX) % MAX;
      Integer x1 = map(s1, legal, cache, MAX) % MAX;
      cache.put(message, (x1 + x2) % MAX);
      return (x1 + x2) % MAX;
    } else {
      Integer x1 = map(s1, legal, cache, MAX) % MAX;
      cache.put(message, x1);
      return x1 % MAX;
    }
  }

  // ---------fillingBlocks
  int fillingBlocks(int n) {
    if (n == 1) {
      return 1;
    }
    if (n == 2) {
      return 5;
    }
  }


  public static void main(String[] args) {
    InterviewDynamicPrograming i = new InterviewDynamicPrograming();
    int[] x = {0, 1};
    System.out.println(i.mapDecoding(
        "1221112111122221211221221212212212111221222212122221222112122212121212221212122221211112212212211211"));
  }

}
