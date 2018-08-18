package tiendm.codefight.tournament;

public class Tour1808 {

	int[][] create2DArray(int[] lengths) {
		int[][] r = new int[lengths.length][];
		for (int i = 0; i < lengths.length; i++) {
			int x = lengths[i];
			int[] a = new int[x];
			for (int j = 0; j < x; j++) {
				a[j] = j;
			}
			r[i] = a;
		}

		return r;
	}

	int numberOfTriangles2(int[] sticks) {
		int s = 0;
		for (int i = 0; i < sticks.length - 2; i++) {
			for (int j = i + 1; j < sticks.length - 1; j++) {
				for (int k = j + 1; k < sticks.length; k++) {
					if (sticks[i] + sticks[j] > sticks[k] && sticks[j] + sticks[k] > sticks[i]
							&& sticks[i] + sticks[k] > sticks[j])
						s++;
				}
			}
		}
		return s;
	}

	public static void main(String[] args) {
		Tour1808 t = new Tour1808();
		int[] x = { 3, 5, 7, 9 };
		System.out.println(t.numberOfTriangles2(x));
	}
}
