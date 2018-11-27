package tiendm.codefight.challenge.may;

public class Leftover {
  int leftover(String s) {
    int sum = 0, l = s.length();
    for (int i = 0; i < l; i++) {
      char c = s.charAt(i);
      sum += (int) c;
      // if(c >= 'a' && c <= 'z') sum += (int) c - 'a';
      // if(c >= '0' && c <= '9') sum += (int) c - '0';
    }
    return sum % l;
  }

  public static void main(String[] args) {
    Leftover test = new Leftover();
    System.out.println(test.leftover("2995"));
  }
}
