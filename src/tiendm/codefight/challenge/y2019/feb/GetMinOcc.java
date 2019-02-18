package tiendm.codefight.challenge.y2019.feb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GetMinOcc {
  static List<Long> getMinOcc(List<Long> ls) {
    int L = ls.size();
    for (int i = 0; i < L - 1; i++) {
      for (int j = i + 1; j < L; j++) {
        int c1 = getCount(ls, ls.get(i));
        int c2 = getCount(ls, ls.get(j));
        if (c1 > c2) {
          swap(ls, i, j);
        }
      }
    }

    List<Long> lsNotDuplicate = ls.stream().distinct().collect(Collectors.toList());
    return lsNotDuplicate;

  }

  static int getCount(List<Long> ls, long s) {
    int c = 0;
    for (long x : ls) {
      if (x == s) {
        c++;
      }
    }
    return c;
  }

  static void swap(List<Long> ls, int i, int j) {
    long tmp = ls.get(i);
    ls.set(i, ls.get(j));
    ls.set(j, tmp);
  }


  public static void main(String[] args) {
    List<Long> ll = new ArrayList<>();
    ll.add(15l);
    ll.add(16l);
    ll.add(17l);
    ll.add(15l);
    ll.add(16l);
    List<Long> ls = getMinOcc(ll);
    System.out.println(ls);
  }
}
