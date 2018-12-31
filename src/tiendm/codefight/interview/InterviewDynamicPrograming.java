package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.List;

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
          result.add(cur+"");
        }
      }
    }
    return result;
  }


  public static void main(String[] args) {
    InterviewDynamicPrograming i = new InterviewDynamicPrograming();
    int[] x = {0,1};
    System.out.println(i.composeRanges(x));// 10
  }
}
