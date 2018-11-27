package tiendm.codefight.tournament.oct;

public class Tour1006 {
  String reflectString(String inputString) {
    String s = "";
    for (int i = 0; i < inputString.length(); i++) {
      char c = inputString.charAt(i);
      s += (char) ('a' + 'z' - c) + "";
    }
    return s;
  }

  int divNumber(int k, int l, int r) {

    int ans = 0;
    for (int i = l; i <= r; i++) {
      int n = i;
      int divs = 1;
      for (int j = 2; j * j <= n; j++) {
        int pow = 0;
        while (n % j == 0) {
          n /= j;
          pow++;
        }
        divs *= 1 + pow;
        if (divs > k) {
          break;
        }
      }
      if (n != 1) {
        divs *= 2;
      }
      if (divs == k) {
        ans++;
      }
    }

    return ans;
  }

  int maximalEven(int[] inputArray) {

    int answer = 0;
    for (int i = 0; i < inputArray.length; i++) {
      if (inputArray[i] % 2 == 0 && inputArray[i] > answer) {
        answer = inputArray[i];
      }
    }
    return answer;
  }

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

  public static void main(String[] args) {
    Tour1006 t = new Tour1006();
    int[] fromV = {2, 1, 3, 4, 4, 4, 1};
    int[] toV = {3, 2, 1, 3, 2, 1, 4};
    System.out.println(t);
  }
}
