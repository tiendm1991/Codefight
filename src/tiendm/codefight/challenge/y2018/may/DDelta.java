package tiendm.codefight.challenge.y2018.may;

public class DDelta {
  int dDelta(int number, int base) {
    int min = base, max = 0;
    while (number > 0) {
      int m = number % base;
      if (m < min)
        min = m;
      if (m > max)
        max = m;
      number = number / base;
    }
    return max - min;
  }
}
