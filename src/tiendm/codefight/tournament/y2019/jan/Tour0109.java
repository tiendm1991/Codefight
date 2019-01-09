package tiendm.codefight.tournament.y2019.jan;

import java.util.ArrayList;

public class Tour0109 {
  ArrayList<String> fileNaming(String[] names) {
    class HashMapElement {
      String element;
      int hash;
      int version; // the smallest possible integer to use with this name

      HashMapElement(String a, int b, int c) {
        element = a;
        hash = b;
        version = c;
      }
    };

    class Helper {
      /*
       * Information about the string in the hash map is stored in the following way: [string
       * itself, its hash, the smallest possible integer to use with this name]
       */
      int hashMapSize;
      HashMapElement[] hashMap;

      Helper(int halfSize) {
        hashMapSize = halfSize * 2;
        hashMap = new HashMapElement[hashMapSize];
        for (int i = 0; i < hashMapSize; i++) {
          hashMap[i] = new HashMapElement("", -1, 0);
        }
      }

      int calculateHash(String inputString) {
        final int P = 997;
        final int M = 28001;
        int hashValue = 0;
        for (int i = 0; i < inputString.length(); i++) {
          hashValue = (hashValue * P + (int) inputString.charAt(i)) % M;
        }
        return hashValue;
      }

      int searchHM(int position, int hash) {
        while (hashMap[position].element != "" && hashMap[position].hash != hash) {
          position = (position + 1) % hashMapSize;
        }
        return position;
      }
    };

    ArrayList<String> result = new ArrayList<>();
    Helper h = new Helper(names.length);

    for (int i = 0; i < names.length; i++) {
      int hash = h.calculateHash(names[i]);
      int startPos = h.searchHM(hash % h.hashMapSize, hash);
      if (h.hashMap[startPos].element == "") {
        h.hashMap[startPos] = new HashMapElement(names[i], hash, 1);
        result.add(names[i]);
      } else {
        String newName = names[i] + "(" + Integer.toString(h.hashMap[startPos].version) + ")";
        int newNameHash = h.calculateHash(newName);
        int position = h.searchHM(newNameHash % h.hashMapSize, newNameHash);

        while (h.hashMap[position].element != "") {
          h.hashMap[startPos].version++;
          newName = names[i] + "(" + Integer.toString(h.hashMap[startPos].version) + ")";
          newNameHash = h.calculateHash(newName);
          position = h.searchHM(newNameHash % h.hashMapSize, newNameHash);
        }
        h.hashMap[position] = new HashMapElement(newName, newNameHash, 1);
        result.add(newName);
        h.hashMap[startPos].version++;
      }
    }
    return result;
  }

  int countWays(int n, int k) {
    final int MOD = (int) 1e9 + 7;

    ArrayList<ArrayList<Integer>> c_nk = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
      c_nk.add(new ArrayList<Integer>());
      for (int j = 0; j <= k; j++) {
        c_nk.get(i).add(0);
      }
    }
    c_nk.get(0).set(0, 1);
    for (int i = 0; i < n; i++) {
      ArrayList<Integer> cur = c_nk.get(i);
      ArrayList<Integer> next = c_nk.get(i + 1);
      for (int j = 0; j <= k; j++) {
        if (i + 1 <= n) {
          next.set(j, (next.get(j) + cur.get(j)) % MOD);
          if (j + 1 <= k) {
            next.set(j + 1, (next.get(j + 1) + cur.get(j)) % MOD);
          }
        }
      }
    }

    return c_nk.get(n).get(k);
  }

  public static void main(String[] args) {
    Tour0109 t = new Tour0109();
    System.out.println(t.countWays(5, 2));
  }
}
