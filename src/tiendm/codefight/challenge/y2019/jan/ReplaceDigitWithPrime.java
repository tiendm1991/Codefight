package tiendm.codefight.challenge.y2019.jan;

public class ReplaceDigitWithPrime {
  int replaceDigitWithPrime(int n) {
    if (n == 0) {
      return 2;
    }
    int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int note = 0;
    int result = 0;
    int p = 0;
    while (n > 0) {
      int mod = n % 10;
      int replace = prime[mod] + note;
      if (replace > 10) {
        note = replace / 10;
        replace = replace % 10;
      } else {
        note = 0;
      }
      result += replace * Math.pow(10, p++);
      n /= 10;
    }
    if (note > 0) {
      result += note * Math.pow(10, p++);
    }
    return result;
  }
}
