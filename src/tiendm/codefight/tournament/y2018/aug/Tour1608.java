package tiendm.codefight.tournament.y2018.aug;

public class Tour1608 {

  boolean cyclicSequence(int[] a) {
    if (a.length == 1)
      return true;
    int cur = a[1], i = 1;
    while (cur >= a[i - 1]) {
      i++;
      cur = a[i];
    }
    for (int x = i + 1; x < a.length; x++) {
      if (a[x] < a[x - 1])
        return false;
    }
    return a[0] > a[a.length - 1];
  }

  boolean cyclicSequence2(int[] sequence) {

    boolean found = false;
    int st = -1;
    for (int i = 1; i < sequence.length; i++) {
      if (sequence[i - 1] == sequence[i]) {
        return false;
      }
      if (sequence[i - 1] > sequence[i]) {
        if (found) {
          return false;
        }
        found = true;
        st = i;
      }
    }
    return st == -1 || sequence[st] < sequence[(st +1) % sequence.length];
  }

  public static void main(String[] args) {
    Tour1608 t = new Tour1608();
    int[] x = {5, -4, -3, 0, 1, 3, 4, 5};
    System.out.println(t.cyclicSequence2(x));
  }
}
