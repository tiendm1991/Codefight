package tiendm.codefight.interview;

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

  public static void main(String[] args) {
    InterviewDynamicPrograming i = new InterviewDynamicPrograming();
    int[] x = {2, 9, 1, 1, 6, 3, 2, 7};
    System.out.println(i.houseRobber(x));// 10
  }
}
