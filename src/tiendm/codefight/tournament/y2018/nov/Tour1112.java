package tiendm.codefight.tournament.y2018.nov;

import java.util.ArrayList;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1112 {
  int binaryPower(int n, int k) {
    final int MOD = (int) 1e7 + 7;

    if (k == 0) {
      return 1;
    }
    if (k % 2 == 0) {
      return (int) (Math.pow(binaryPower(n, k / 2), 2) % MOD);
    }
    return (int) ((binaryPower(n, k - 1) * 1L * n) % MOD);
  }

  int countInversionsNaive(int[] inputArray) {

    int result = 0;

    for (int i = 0; i < inputArray.length; i++) {
      for (int j = i + 1; j < inputArray.length; j++) {
        if (inputArray[i] > inputArray[j]) {
          result++;
        }
      }
    }
    return result;
  }

  int applesDistribution(int apples, int boxCapacity, int maxResidue) {
    int result = 0;
    for (int i = 1; i <= boxCapacity; i++) {
      if (apples % i <= maxResidue) {
        result++;
      }
    }
    return result;
  }

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
    }
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

  int[] sortByHeight(int[] a) {
    for (int i = 0; i < a.length; i++) {
      int minIndex = -1, tmp = a[i];
      if (a[i] == -1) {
        continue;
      }
      for (int j = i; j < a.length; j++) {
        if (a[j] != -1) {
          if (minIndex == -1 || a[j] < a[minIndex]) {
            minIndex = j;
          }
        }
      }
      a[i] = a[minIndex];
      a[minIndex] = tmp;
    }
    return a;
  }

  public static void main(String[] args) {
    Tour1112 t = new Tour1112();
    int[] values = {1, 6, 7};
    String[] s = {"*", "-", "5", "6", "7"};
    System.out.println(t);
  }
}
