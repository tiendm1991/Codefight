package tiendm.codefight.tournament.y2018.nov;

public class Tour1127 {
  String insertDashes(String inputString) {
    String[] words = inputString.split(" ");
    for (int i = 0; i < words.length; i++) {
      words[i] = words[i].replace("", "-");
      if (words[i].length() > 2) {
        words[i] = words[i].substring(1, words[i].length() - 1);
      }
    }
    String ans = "";
    for (int i = 0; i < words.length - 1; i++) {
      ans += words[i] + " ";
    }
    return ans + words[words.length - 1];
  }

  int absoluteValuesSumMinimization(int[] a) {

    int indexOfMinimum = -1;
    int minimalSum = Integer.MAX_VALUE;

    for (int i = 0; i < a.length; i++) {
      int sum = 0;
      for (int j = 0; j < a.length; j++) {
        sum += Math.abs(a[j] - a[i]);
      }
      if (sum < minimalSum) {
        minimalSum = sum;
        indexOfMinimum = i;
      }
    }

    return a[indexOfMinimum];
  }

  public static void main(String[] args) {
    Tour1127 t = new Tour1127();
    int[] values = {2, 1, 3, 5, 3, 2};
    String[] s = {"*", "-", "5", "6", "7"};
    int[] a = {3, -3};
    int[] b = {-3, 3};
    int[] c = {-1, 0};
    int[] d = {2, 1};
    System.out.println(t);
  }
}
