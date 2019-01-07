package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;

public class Tour0108 {
  boolean isTournament(int n, int[] fromV, int[] toV) {

    ArrayList<ArrayList<Boolean>> edges = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      ArrayList<Boolean> line = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        line.add(false);
      }
      edges.add(line);
    }

    for (int i = 0; i < fromV.length; i++) {
      edges.get(fromV[i] - 1).set(toV[i] - 1, true);
    }

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (edges.get(i).get(j) == edges.get(j).get(i)) {
          return false;
        }
      }
    }

    if (fromV.length != n * (n - 1) / 2) {
      return false;
    }
    return true;
  }

  int stringsCrossover(String[] inputArray, String result) {

    int answer = 0;

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        boolean correct = true;
        for (int k = 0; k < result.length(); k++) {
          if (result.charAt(k) != inputArray[i].charAt(k)
              && result.charAt(k) != inputArray[j].charAt(k)) {
            correct = false;
            break;
          }
        }
        if (correct) {
          answer++;
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Tour0108 t = new Tour0108();
    System.out.println(t);
  }
}
