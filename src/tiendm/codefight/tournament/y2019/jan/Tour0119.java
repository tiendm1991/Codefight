package tiendm.codefight.tournament.y2019.jan;

public class Tour0119 {
  int numberOfSolutions(int n) {

    int result = 0;
    for (int a = n + 1; a < 2 * n; a++) {
      if ((a * n) % (a - n) == 0) {
        result++;
      }
    }

    return result * 2 + 1;
  }

  int sumOfCoprimes(int m) {

    int ans = 0;
    for (int p = 2; p <= m; p++) {
      int a = p;
      int b = m;
      while (a > 0) {
        int tmp = b % a;
        b = a;
        a = tmp;
      }

      if (b == 1) {
        ans += p;
      }
    }

    return ans;
  }

  void merge(int[] sequence, int left, int middle, int right) {
    int[] result = new int[right - left];
    int i, j;
    int k = 0;

    for (i = left, j = middle; i < middle && j < right;) {
      if (sequence[i] < sequence[j]) {
        result[k++] = sequence[i];
        i++;
      } else {
        result[k++] = sequence[j];
        j++;
      }
    }

    while (i < middle) {
      result[k++] = sequence[i];
      i++;
    }

    while (j < right) {
      result[k++] = sequence[j];
      j++;
    }

    for (i = left; i < right; i++) {
      sequence[i] = result[i - left];
    }
  }

  void split(int[] sequence, int left, int right) {
    if (left + 1 == right) {
      return;
    }
    int middle = (left + right) / 2;
    split(sequence, left, middle);
    split(sequence, middle, right);
    merge(sequence, left, middle, right);
  }

  int[] mergeSort(int[] sequence) {
    split(sequence, 0, sequence.length);

    return sequence;
  }

  public static void main(String[] args) {
    Tour0119 t = new Tour0119();
    System.out.println(t.sumOfCoprimes(5));
  }
}
