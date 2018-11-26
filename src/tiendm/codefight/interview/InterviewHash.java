package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class InterviewHash {

  List<ArrayList<String>> groupingDishes(String[][] dishes) {
    Map<String, ArrayList<String>> _map = new TreeMap<>();
    for (String[] dish : dishes) {
      String dishName = dish[0];
      for (int i = 1; i < dish.length; i++) {
        String ingredient = dish[i];
        ArrayList<String> dishList = _map.get(ingredient);
        if (dishList == null) {
          dishList = new ArrayList<>();
          _map.put(ingredient, dishList);
        }
        dishList.add(dishName);
      }
    }
    List<ArrayList<String>> result = new ArrayList<>();
    for (String ingredient : _map.keySet()) {
      ArrayList<String> dishList = _map.get(ingredient);
      if (dishList.size() > 1) {
        Collections.sort(dishList);
        dishList.add(0, ingredient);
        result.add(dishList);
      }
    }
    return result;
  }

  boolean areFollowingPatterns(String[] strings, String[] patterns) {
    Map<String, String> mapString = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      String pattern = mapString.get(strings[i]);
      if (pattern == null) {
        mapString.put(strings[i], patterns[i]);
      } else {
        if (!pattern.equals(patterns[i]))
          return false;
      }
    }
    Map<String, String> mapPattern = new HashMap<>();
    for (int i = 0; i < patterns.length; i++) {
      String str = mapPattern.get(patterns[i]);
      if (str == null) {
        mapPattern.put(patterns[i], strings[i]);
      } else {
        if (!str.equals(strings[i]))
          return false;
      }
    }
    return true;
  }

  boolean containsCloseNums(int[] nums, int k) {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      ArrayList<Integer> list = map.get(nums[i]);
      if (list == null) {
        list = new ArrayList<>();
        list.add(i);
        map.put(nums[i], list);
      } else {
        list.add(i);
      }
    }
    for (Integer x : map.keySet()) {
      ArrayList<Integer> list = map.get(x);
      if (list.size() <= 1) {
        continue;
      }
      Collections.sort(list);
      for (int i = 1; i < list.size(); i++) {
        if (list.get(i) - list.get(i - 1) <= k) {
          return true;
        }
      }
    }
    return false;
  }

  int possibleSums(int[] coins, int[] quantity) {
    List<Integer> lsCoins = new ArrayList<>();
    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j < quantity[i]; j++) {
        lsCoins.add(coins[i]);
      }
    }
    Set<Integer> set = new HashSet<>();
    set.add(0);
    calculateSum(lsCoins, set);
    return set.size() - 1;
  }

  private void calculateSum(List<Integer> lsCoins, Set<Integer> set) {
    for (int element : lsCoins) {
      Set<Integer> setNew = new HashSet<>();
      for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
        int x = it.next();
        setNew.add(x + element);
      }
      set.addAll(setNew);
    }
  }

  int possibleSums2(int[] coins, int[] quantity) {
    Set<Integer> set = new HashSet<>();
    set.add(0);
    for (int i = 0; i < coins.length; i++) {
      int coint = coins[i];
      Set<Integer> setNew = new HashSet<>();
      for (Iterator<Integer> it = set.iterator(); it.hasNext();) {
        int x = it.next();
        for (int j = 0; j < quantity[i]; j++) {
          setNew.add(x + coint * (j + 1));
        }
      }
      set.addAll(setNew);
    }
    return set.size() - 1;
  }

  String swapLexOrder(String str, int[][] pairs) {
    int L = pairs.length;
    if (L == 0)
      return str;
    Map<String, Integer> _map = new TreeMap<>();
    int count = 0;
    while (!(_map.containsKey(str) && _map.get(str).intValue() == count)) {
      _map.put(str, count);
      int[] x = pairs[count % L];
      int i = x[0] - 1;
      int j = x[1] - 1;
      str = swap(str, i, j);
      count = (count + 1) % L;
    }
    List<String> ls = _map.keySet().stream().map(s -> s).collect(Collectors.toList());
    return ls.get(ls.size()-1);
  }

  String swap(String str, int i, int j) {
    char[] c = str.toCharArray();
    char tmp = c[i];
    c[i] = c[j];
    c[j] = tmp;
    return new String(c);
  }


  public static void main(String[] args) {
    InterviewHash i = new InterviewHash();
    String[] str = {"cat", "dog", "doggy"};
    String[] pat = {"a", "b", "b"};
    int[] x = {10, 50, 100};
    int[] y = {1, 2, 1};
    int[][] pairs = {{1, 3}, {6, 8}, {3, 8}, {2, 7}};
    System.out.println(i.swapLexOrder("acxrabdz", pairs));
  }
}
