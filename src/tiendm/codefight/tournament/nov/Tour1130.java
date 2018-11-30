package tiendm.codefight.tournament.nov;

public class Tour1130 {
  boolean isPermutation(int n, int[] inputArray) {

    int[] countOccurences = new int[n];

    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] - 1 < 0 || inputArray[i] - 1 >= n) {
        return false;
      }
      countOccurences[inputArray[i] - 1]++;
    }

    for (int i = 0; i < n; i++) {
      if (countOccurences[i] != 1) {
        return false;
      }
    }
    return true;
  }

  boolean checkPalindrome(String inputString) {

    boolean isPalindrome = true;
    for (int i = 0; i < inputString.length(); i++) {
      if (inputString.charAt(i) != inputString.charAt(inputString.length() - i - 1)) {
        isPalindrome = false;
        break;
      }
    }

    return isPalindrome;
  }

  int josephusProblem(int n, int k) {
    int removed = 0;
    int cur = 0;
    boolean[] p = new boolean[n];
    while (removed < n - 1) {
      p[(cur + k - 1) % n] = true;
      cur = (cur + k) % n;
      removed++;
    }
    for (int i = 0; i < p.length; i++) {
      if (!p[i])
        return i + 1;
    }
    return 0;
  }


  public static void main(String[] args) {
    Tour1130 t = new Tour1130();
    int[] values = {2, 1, 3, 5, 3, 2};
    String[] s = {"*", "-", "5", "6", "7"};
    int[] a = {3, -3};
    int[] b = {-3, 3};
    int[] c = {-1, 0};
    int[] d = {2, 1};
    System.out.println(t);
  }
}
