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
    return a[(a.length - 1) / 2];
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
