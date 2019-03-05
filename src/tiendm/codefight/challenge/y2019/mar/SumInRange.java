package tiendm.codefight.challenge.y2019.mar;

public class SumInRange {
  int sumInRange(int[] nums, int[][] queries) {
    int mod = (int) (Math.pow(10, 9) + 7);
    int s = 0;
    int[] count = new int[nums.length];
    for (int[] q : queries) {
      for (int i = q[0]; i <= q[1]; i++) {
        count[i]++;
      }
    }
    for (int i = 0; i < count.length; i++) {
      s = (s + count[i] * nums[i]) % mod;
    }
    return (s + mod) % mod;
  }
}
