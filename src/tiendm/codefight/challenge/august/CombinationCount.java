package tiendm.codefight.challenge.august;

import java.util.Arrays;

public class CombinationCount {
  int combinationCount(int[] array1, int[] array2, int[] array3) {
    Arrays.sort(array1);
    Arrays.sort(array2);
    Arrays.sort(array3);
    int count = 0;
    for (int i = 0; i < array1.length; i++) {
      int n1 = array1[i];
      int check2 = searchMinLarger(n1, array2, 0, array2.length - 1);
      if (check2 > -1) {
        for (int j = check2; j < array2.length; j++) {
          int n2 = array2[j];
          int check3 = searchMinLarger(n2, array3, 0, array3.length - 1);
          if (check3 > -1) {
            count += array3.length - check3;
          }
        }
      }
    }
    return count;
  }

  int searchMinLarger(int value, int[] arr, int left, int right) {
    if (arr[right] <= value)
      return -1;
    if (left == right)
      return left;
    if (left + 1 == right)
      return arr[left] > value ? left : right;
    int mid = (left + right) / 2;
    if (arr[mid] <= value)
      return searchMinLarger(value, arr, mid, right);
    return searchMinLarger(value, arr, left, mid);
  }

  public static void main(String[] args) {
    CombinationCount c = new CombinationCount();
    int[] a1 = {12, 6, 8, 3};
    int[] a2 = {1, 3, 5, 8};
    int[] a3 = {9, 15, 7, 5};
    System.out.println(c.combinationCount(a1, a2, a3));
  }
}
