package tiendm.codefight.tournament.nov;

public class Tour1118 {
	int rangeBitCount(int a, int b) {

		int ans = 0;
		for (int i = a; i <= b; i++) {
			int t = i;
			while (t != 0) {
				ans += t % 2;
				t /= 2;
			}
		}

		return ans;
	}

	int equalPairOfBits(int n, int m) {
		return n % 2 == m % 2 ? 1 : 2 * equalPairOfBits(n / 2, m / 2);
	}

	public static void main(String[] args) {
		Tour1118 t = new Tour1118();
		int[] values = { 2, 1, 3, 5, 3, 2 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t);
	}
}