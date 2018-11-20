package tiendm.codefight.tournament.nov;

public class Tour1120 {
	int arrayPacking(int[] a) {

		int res = 0;
		for (int i = 0; i < a.length; i++) {
			res |= a[i] << (8 * i);
		}

		return res;
	}

	public static void main(String[] args) {
		Tour1120 t = new Tour1120();
		int[] values = { 2, 1, 3, 5, 3, 2 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t);
	}
}