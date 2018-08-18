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

	public static void main(String[] args) {
		Tour1808 t = new Tour1808();
		System.out.println(t);
	}
}
