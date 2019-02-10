package tiendm.codefight.challenge.y2019.feb;

public class SplitByValue {
  int[] splitByValue(int k, int[] a) {
    for (int i = 1; i < a.length; i++) {
      if (a[i] < k) {
        int j = i;
        int tmp = a[i];
        while (j > 0 && a[j-1] >= k) {
          a[j] = a[j - 1];
          j--;
        }
        a[j] = tmp;
      }
    }
    return a;
  }

  public static void main(String[] args) {
    SplitByValue s = new SplitByValue();
    int[] x = {1, 3, 5, 7, 6, 4, 2};
    System.out.println(s.splitByValue(5, x));
  }
}
