package tiendm.codefight.tournament.y2018.oct;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tour1015 {
  String[] splitString(String str) {
    Matcher match = Pattern.compile("\\w+\\s").matcher(str + " ");
    ArrayList<String> slicedArray = new ArrayList<String>();
    boolean hasMatch = match.find();
    if (!hasMatch) {
      return new String[] {};
    }
    while (hasMatch) {
      String matchString = match.group();
      slicedArray.add(matchString.trim());
      hasMatch = match.find();
    }
    String[] result = new String[slicedArray.size()];
    slicedArray.toArray(result);
    return result;
  }

  int countSumOfTwoRepresentations(int n, int l, int r) {
    int s = 0;
    for (int i = l; i <= r; i++) {
      if (i <= n - i && n - i <= r) {
        s++;
      }
    }
    return s;
  }

  boolean chessBoardCellColor(String cell1, String cell2) {
    int x1 = cell1.charAt(0) - 'A';
    int y1 = cell1.charAt(1) - '0';
    int x2 = cell2.charAt(0) - 'A';
    int y2 = cell2.charAt(1) - '0';
    return (x1 + y1) % 2 == (x2 + y2) % 2;
  }

  int areaOfIntersection(int[] shape1, int[] shape2) {
    int s = 0;
    int minX = Math.min(shape1[1] - shape1[0] + 1, shape2[1] - shape2[0] + 1);
    int minY = Math.min(shape1[2] - shape1[0] + 1, shape2[2] - shape2[0] + 1);
    int maxX = Math.max(shape1[1] + shape1[0] - 1, shape2[1] + shape2[0] - 1);
    int maxY = Math.max(shape1[2] + shape1[0] - 1, shape2[2] + shape2[0] - 1);
    for (int i = minX; i <= maxX; i++) {
      for (int j = minY; j <= maxY; j++) {
        if (check(shape1, i, j) && check(shape2, i, j))
          s++;
      }
    }
    return s;
  }

  boolean check(int[] shape, int x, int y) {
    int x0 = shape[1];
    int y0 = shape[2];
    int n = shape[0];
    int dy = 0;
    for (int i = x0 - n + 1; i <= x0; i++) {
      for (int j = y0 - dy; j <= y0 + dy; j++) {
        if (i == x && j == y)
          return true;
      }
      dy++;
    }
    dy--;
    for (int i = x0 + 1; i <= x0 + n - 1; i++) {
      for (int j = y0 - dy; j <= y0 + dy; j++) {
        if (i == x && j == y)
          return true;
      }
      dy--;
    }
    return false;
  }

  public static void main(String[] args) {
    Tour1015 t = new Tour1015();
    int[] toV = {3, 2, 1, 3, 2, 1, 4};
    System.out.println(t);
  }
}
