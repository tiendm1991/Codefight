package tiendm.codefight.challenge.y2019.jan;

public class StringsRearrangement {
  boolean stringsRearrangement(String[] inputArray) {
    if (inputArray[0].isEmpty())
      return false;
    char[][] charInputArr = new char[inputArray.length][inputArray[0].length()];
    for (int i = 0; i < inputArray.length; i++) {
      charInputArr[i] = inputArray[i].toCharArray();
    }
    int[][] graph = buildgraph(charInputArr, inputArray);
    for (int i = 0; i < inputArray.length; i++) {
      boolean[] visited = new boolean[graph.length];
      if (checkSolution(graph, visited, i))
        return true;
    }
    return false;
  }

  boolean checkSolution(int[][] graph, boolean[] visited, int start) {
    visited[start] = true;
    if (checkAllVisit(visited))
      return true;
    else {
      for (int i = 0; i < graph.length; i++) {
        if (graph[start][i] == 1 && !visited[i]) {
          if (checkSolution(graph, visited, i))
            return true;
          else
            visited[i] = false;
        }
      }
    }
    return false;
  }

  boolean checkAllVisit(boolean[] visited) {
    for (boolean b : visited) {
      if (!b)
        return false;
    }
    return true;
  }

  int[][] buildgraph(char[][] charInputArr, String[] inputArray) {
    int[][] graph = new int[inputArray.length][inputArray.length];
    for (int i = 0; i < inputArray.length; i++) {
      for (int j = 0; j < inputArray.length; j++) {
        if (checkArrange(charInputArr, i, j))
          graph[i][j] = 1;
      }
    }
    return graph;
  }

  boolean checkArrange(char[][] charInputArr, int s1, int s2) {
    int size = charInputArr[0].length;
    int count = 0;
    for (int i = 0; i < size; i++) {
      if (charInputArr[s1][i] != charInputArr[s2][i])
        count++;
      if (count > 1)
        return false;
    }
    return count == 1;
  }


}
