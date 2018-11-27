package tiendm.codefight.core;

public class RegularHell {
  boolean isSentenceCorrect(String sentence) {
    String regex = "[A-Z]*{?}{!}{.}";
    return sentence.matches(regex);
  }

  public static void main(String[] args) {
    RegularHell test = new RegularHell();
    System.out.println(test.isSentenceCorrect("This is an example of *correct* sentence."));
  }

}
