package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    return ls.get(ls.size() - 1);
  }

  String swap(String str, int i, int j) {
    char[] c = str.toCharArray();
    char tmp = c[i];
    c[i] = c[j];
    c[j] = tmp;
    return new String(c);
  }

  String swapLexOrder2(String str, int[][] pairs) {
    if (pairs.length == 0)
      return str;
    char[] c = str.toCharArray();
    int[] parent = new int[c.length];
    for (int i = 0; i < parent.length; i++) {
      parent[i] = -1;
    }
    for (int[] pair : pairs) {
      int x = pair[0] - 1;
      int y = pair[1] - 1;
      if (parent[x] == -1) {
        parent[x] = x;
      }
      while (parent[x] != x) {
        x = parent[x];
      }
      int tmp = y;
      while (parent[y] != y && parent[y] != -1) {
        int p = parent[y];
        parent[p] = x;
        y = p;
      }
      parent[tmp] = x;
    }
    HashMap<Integer, ArrayList<Integer>> _map = new HashMap<>();
    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == -1) {
        continue;
      }
      ArrayList<Integer> component = _map.get(parent[i]);
      if (component != null) {
        component.add(i);
      } else {
        component = new ArrayList<>();
        component.add(i);
        _map.put(parent[i], component);
      }
    }

    for (Integer k : _map.keySet()) {
      ArrayList<Integer> component = _map.get(k);
      List<Character> lschar = new ArrayList<>();
      for (int i : component) {
        lschar.add(c[i]);
      }
      Collections.sort(lschar, new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
          return o2.compareTo(o1);
        }
      });
      for (int i = 0; i < component.size(); i++) {
        c[component.get(i)] = lschar.get(i);
      }
    }
    return new String(c);
  }



  public static void main(String[] args) {
    InterviewHash i = new InterviewHash();
    int[][] pairs = 
        {{8,5}, 
        {10,8}, 
        {4,18}, 
        {20,12}, 
        {5,2}, 
        {17,2}, 
        {13,25}, 
        {29,12}, 
        {22,2}, 
        {17,11}};
    // 5,7 0,2 2,7 1,6
    System.out.println(i.swapLexOrder2("fixmfbhyutghwbyezkveyameoamqoi", pairs));
    System.out.println("fixmfbhyutghwbyezkveyameoamqoi".length());
  }
}
