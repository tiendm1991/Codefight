package tiendm.codefight.challenge.y2019.jan;

import java.util.ArrayList;
import java.util.List;

public class TriangularSorting {
  static class ListNode<T> {
    ListNode(T x) {
      value = x;
    }

    T value;
    ListNode<T> next;
  }

  ListNode<Integer> triangularSorting(ListNode<Integer> list) {
    List<Integer> ls = new ArrayList<>();
    ListNode<Integer> cur = list;
    while (cur != null) {
      ls.add(cur.value);
      cur = cur.next;
    }
    int L = ls.size();
    if (L <= 2) {
      return list;
    }
    ListNode<Integer> result = new ListNode<Integer>(list.value);
    int n = L / 2;
    while (n > 1) {
      if (n * (n + 1) == L) {
        break;
      }
      n--;
    }
    List<Integer> lsNew = new ArrayList<>();
    int startLeft = 0;
    int startRight = n * n;
    while (n > 0) {
      for (int i = 0; i < n; i++) {
        lsNew.add(ls.get(startLeft + i));
      }
      for (int i = 0; i < n; i++) {
        lsNew.add(ls.get(startRight + i));
      }
      n--;
      startLeft += (n+1);
      startRight -= n;
    }
    cur = result;
    for (int i = 1; i < lsNew.size(); i++) {
      ListNode<Integer> node = new ListNode<Integer>(lsNew.get(i));
      cur.next = node;
      cur = node;
    }
    return result;
  }

  public static void main(String[] args) {
    TriangularSorting t = new TriangularSorting();
    ListNode<Integer> x = new ListNode<Integer>(8);
    ListNode<Integer> x1 = new ListNode<Integer>(9);
    ListNode<Integer> x2 = new ListNode<Integer>(11);
    ListNode<Integer> x3 = new ListNode<Integer>(1);
    ListNode<Integer> x4 = new ListNode<Integer>(1);
    ListNode<Integer> x5 = new ListNode<Integer>(1);
    ListNode<Integer> x6 = new ListNode<Integer>(45);
    ListNode<Integer> x7 = new ListNode<Integer>(3);
    ListNode<Integer> x8 = new ListNode<Integer>(2);
    ListNode<Integer> x9 = new ListNode<Integer>(4);
    ListNode<Integer> x10 = new ListNode<Integer>(13);
    ListNode<Integer> x11 = new ListNode<Integer>(13);
    x.next = x1;
    x1.next = x2;
    x2.next = x3;
    x3.next = x4;
    x4.next = x5;
    x5.next = x6;
    x6.next = x7;
    x7.next = x8;
    x8.next = x9;
    x9.next = x10;
    x10.next = x11;
    System.out.println(t.triangularSorting(x));
  }
}
