package tiendm.codefight.challenge.y2018.may;

public class ChangeOfVowelsInCycle {
  String changeOfVowelsInCycle(int cycle, String text) {
    String sCheck = "aeiouAEIOU";
    char[] a = new StringBuilder(text).reverse().toString().toCharArray();
    for (int i = 0; i < cycle; i++) {
      int pre = a.length;
      char tmp = ' ';
      for (int j = a.length - 1; j >= 0; j--) {
        if (sCheck.indexOf(a[j]) >= 0) {
          if (pre == a.length) {
            tmp = a[j];
          } else {
            a[pre] = a[j];
          }
          pre = j;
        }
      }
      if (pre != a.length)
        a[pre] = tmp;
    }
    return new String(a);
  }

  public static void main(String[] args) {
    ChangeOfVowelsInCycle test = new ChangeOfVowelsInCycle();
    System.out.println(test.changeOfVowelsInCycle(7, "N vwls hr"));
  }
}
