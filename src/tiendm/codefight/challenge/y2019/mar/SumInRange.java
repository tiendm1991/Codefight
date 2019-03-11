package tiendm.codefight.challenge.y2019.mar;

import java.util.HashMap;
import java.util.Map;

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

  int sumInRange2(int[] nums, int[][] queries) {
    int mod = (int) (Math.pow(10, 9) + 7);
    int sum = 0;
    Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int s = 0;
      for (int j = i; j < nums.length; j++) {
        s = (s + nums[j]) % mod;
        map.put(i + "-" + j, s);
      }
    }
    for (int[] q : queries) {
      String key = q[0] + "-" + q[1];
      sum = (sum + map.get(key)) % mod;
    }
    return (sum + mod) % mod;
  }
}
