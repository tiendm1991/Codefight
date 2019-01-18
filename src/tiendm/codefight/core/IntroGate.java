package tiendm.codefight.core;

public class IntroGate {
  int phoneCall(int min1, int min2_10, int min11, int s) {
    if (s < min1) {
      return 0;
    } else if (s - min1 < min2_10) {
      return 1;
    } else if (s - min1 < min2_10 * 9) {
      return 1 + ((s - min1) / min2_10);
    } else {
      return 10 + (s - min1 - 9 * min2_10) / min11;
    }
  }

  int maxMultiple(int divisor, int bound) {
    return ((int) bound / divisor) * divisor;
  }

  int lateRide(int n) {
    int min = n / 60;
    int second = n % 60;
    return min % 10 + min / 10 + second / 10 + second % 10;
  }

  boolean reachNextLevel(int experience, int threshold, int reward) {
    return experience + reward >= threshold;
  }

  boolean tennisSet(int score1, int score2) {
    if ((score1 == 6 && score2 < 5) || (score2 == 6 && score1 < 5))
      return true;
    if ((score1 >= 5 && score1 < 7 && score2 == 7) || (score1 == 7 && score2 >= 5 && score2 < 7))
      return true;
    return false;
  }

  boolean willYou(boolean young, boolean beautiful, boolean loved) {
    if (young && beautiful && !loved)
      return true;
    if (loved && (!young || !beautiful))
      return true;
    return false;
  }

  int[] metroCard(int lastNumberOfDays) {
    switch (lastNumberOfDays) {
      case 30:
        return new int[] {31};
      case 31:
        return new int[] {28, 30, 31};
      case 28:
        return new int[] {31};
      default:
        return new int[0];
    }

  }

}
