package tiendm.codefight;

public class Util {
	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	int countSumOfTwoRepresentations(int n, int l, int r) {
		int result = 0;
		for (int a = l; a <= r; a++) {
			for (int b = a; b <= n; b++) {
				if (a + b == n) {
					result++;
				}
			}
		}
		return result;
	}

}
