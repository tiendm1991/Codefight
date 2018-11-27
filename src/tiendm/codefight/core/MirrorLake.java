package tiendm.codefight.core;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MirrorLake {
  int stringsConstruction(String A, String B) {
    int[] a = new int[26];
    int[] b = new int[26];
    int min = Integer.MAX_VALUE, count = 0;
    for (int i = 0; i < A.length(); i++) {
      a[A.charAt(i) - 'a']++;
    }
    for (int i = 0; i < B.length(); i++) {
      b[B.charAt(i) - 'a']++;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != 0) {
        count = b[i] / a[i];
        if (count < min)
          min = count;
      }
    }
    return count;
  }

  boolean isSubstitutionCipher(String string1, String string2) {
    if (string1.length() != string2.length())
      return false;
    Map<Character, Character> mapCypher = new TreeMap<>();
    for (int i = 0; i < string1.length(); i++) {
      if (mapCypher.get(string1.charAt(i)) == null) {
        mapCypher.put(string1.charAt(i), string2.charAt(i));
      } else if (mapCypher.get(string1.charAt(i)) != string2.charAt(i)) {
        return false;
      }
    }
    int[] check = new int[26];
    for (Character c : mapCypher.values()) {
      check[c - 'a']++;
    }
    for (int i : check) {
      if (i > 1)
        return false;
    }

    return true;
  }

  boolean isSubstitutionCipherSolution(String string1, String string2) {
    Map<Character, Character> dict = new HashMap<>();
    char c1, c2;
    Character value;
    for (int i = 0; i < string1.length(); i++) {
      c1 = string1.charAt(i);
      c2 = string2.charAt(i);
      value = dict.get(c1);
      if (value == null) {
        if (dict.values().contains(c2)) {
          return false;
        } else {
          dict.put(c1, c2);
        }
      } else {
        if (!value.equals(c2)) {
          return false;
        }
      }
    }
    return true;
  }

  int createAnagram(String s, String t) {
    int[] occ1 = new int[26];
    int[] occ2 = new int[26];
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char c1 = s.charAt(i);
      char c2 = t.charAt(i);
      occ1[c1 - 'A']++;
      occ2[c2 - 'A']++;
    }
    for (int i = 0; i < 26; i++) {
      count += Math.abs(occ1[i] - occ2[i]);
    }
    return count / 2;
  }

  int constructSquare(String s) {
    int length = s.length();
    int[] occ = new int[26];
    for (int i = 0; i < s.length(); i++) {
      occ[s.charAt(i) - 'a']++;
    }
    List<Integer> lsCharracter = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      if (occ[i] > 0)
        lsCharracter.add(occ[i]);
    }
    Collections.sort(lsCharracter);
    String sCheck = "";
    for (Integer i : lsCharracter) {
      sCheck += i;
    }
    int min = (int) Math.pow(10, length - 1), max = (int) Math.pow(10, length);
    for (int i = max - 1; i >= min; i--) {
      int square = (int) Math.sqrt(i);
      if (square * square == i && getnum(i).equals(sCheck))
        return i;
    }
    return -1;
  }

  String getnum(int n) {
    String s = "";
    int[] occ = new int[10];
    while (n > 0) {
      int m = n % 10;
      occ[m]++;
      n /= 10;
    }
    List<Integer> lsInt = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      if (occ[i] > 0)
        lsInt.add(occ[i]);
    }
    Collections.sort(lsInt);
    for (Integer i : lsInt) {
      s += i;
    }
    return s;
  }

  int numbersGrouping(int[] a) {
    Set<Integer> set = new HashSet<>();
    for (int i : a) {
      set.add((int) ((i - 1) / Math.pow(10, 4)));
    }
    return set.size() + a.length;
  }

  int differentSquares(int[][] matrix) {
    if (matrix.length < 2 || matrix[0].length < 2)
      return 0;
    Set<String> set = new HashSet<>();
    for (int i = 0; i < matrix.length - 1; i++) {
      for (int j = 0; j < matrix[0].length - 1; j++) {
        String s = matrix[i][j] + "" + matrix[i + 1][j] + "" + matrix[i][j + 1] + ""
            + matrix[i + 1][j + 1];
        set.add(s);
      }
    }
    return set.size();
  }

  int mostFrequentDigitSum(int n) {
    if (n < 10)
      return n;
    int[] occ = new int[4];
    int max = 0, maxStep = 0;
    while (n > 0) {
      int step = sumDigit(n);
      switch (step) {
        case 9:
          occ[0]++;
          break;
        case 18:
          occ[1]++;
          break;
        case 27:
          occ[2]++;
          break;
        case 36:
          occ[3]++;
          break;
        default:
          break;
      }
      n -= step;
    }
    for (int i = 0; i < 4; i++) {
      if (occ[i] >= max) {
        max = occ[i];
        maxStep = i;
      }
    }
    return (maxStep + 1) * 9;
  }

  int sumDigit(int n) {
    int s = 0;
    while (n > 0) {
      s += n % 10;
      n /= 10;
    }
    return s;
  }

  int numberOfClans(int[] divisors, int k) {
    List<ArrayList<Integer>> clans = new ArrayList<>();
    for (int i = 0; i < k - 1; i++) {
      List<Integer> clanI = new ArrayList<>();
      clanI.add(i + 1);
      for (int j = i + 1; j < k; j++) {
        if (checkFriend(divisors, i + 1, j + 1))
          clanI.add(j + 1);
      }
      clans.add((ArrayList<Integer>) clanI);
    }
    List<Integer> clanK = new ArrayList<>();
    clanK.add(k);
    clans.add((ArrayList<Integer>) clanK);
    boolean[] visited = new boolean[10];
    int count = k;
    for (int i = 0; i < clans.size() - 1; i++) {
      for (int j = i + 1; j < clans.size(); j++) {
        if (!visited[i] && !visited[j] && checkMerge(i, j, clans, visited)) {
          count--;
        }
      }
    }
    return count;
  }

  boolean checkMerge(int i1, int i2, List<ArrayList<Integer>> clans, boolean[] visited) {
    List<Integer> clan1 = clans.get(i1);
    List<Integer> clan2 = clans.get(i2);
    List<Integer> clanGreat, clanLess;
    int visit = -1;
    if (clan1.size() > clan2.size()) {
      clanGreat = clan1;
      clanLess = clan2;
      visit = i2;
    } else {
      clanGreat = clan2;
      clanLess = clan1;
      visit = i1;
    }
    for (int i : clanLess) {
      if (!clanGreat.contains(i))
        return false;
    }
    visited[visit] = true;
    return true;
  }

  boolean checkFriend(int[] divisors, int a, int b) {
    for (int d : divisors) {
      if (a % d != b % d)
        return false;
    }
    return true;
  }

  int numberOfClans2(int[] divisors, int k) {
    // Loop from i = 1 => k
    // if i is not friend with all elemt of clans, create clans new.
    // Meaning: One clan have one element is present
    List<Integer> clans = new ArrayList<>();
    clans.add(1);
    for (int i = 2; i <= k; i++) {
      boolean check = true;
      for (Integer c : clans) {
        if (checkFriend(divisors, c, i)) {
          check = false;
          break;
        }
      }
      if (check) {
        clans.add(i);
      }
    }
    return clans.size();
  }

  int numberOfClansSolution(int[] divisors, int k) {
    Set<String> clans = new HashSet<>();

    for (int i = 1; i <= k; i++) {
      String clan = "";

      for (int div : divisors) {
        if (i % div == 0) {
          clan = clan + div + " ";
        }
      }

      clans.add(clan.trim());
    }

    return clans.size();
  }

  public static void main(String[] args) {
    MirrorLake mirrorLake = new MirrorLake();
    int[] d = {1, 3};
    System.out.println(mirrorLake.numberOfClansSolution(d, 10));
  }
}
