package tiendm.codefight.challenge.y2019.jan;

public class MaxFraction {
  int maxFraction(int[] numerators, int[] denominators) {
    int max = 0;
    for (int i = 1; i < numerators.length; i++) {
      if (numerators[i] * denominators[max] > numerators[max] * denominators[i]) {
        max = i;
      }
    }
    return max;
  }

}
