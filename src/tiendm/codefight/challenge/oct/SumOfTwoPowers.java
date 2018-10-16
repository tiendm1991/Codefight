package tiendm.codefight.challenge.oct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfTwoPowers {
	
	List<ArrayList<Integer>> sumOfTwoPowersBuffalow(int n, int k) {
		List<ArrayList<Integer>> ls = new ArrayList<>();
		for (int i = 0; i <= n / 2; i++) {
			if (checkLog(i, k) && checkLog(n - i, k)) {
				ls.add(new ArrayList<>(Arrays.asList(i, n - i)));
			}
		}
		return ls;
	}
	boolean checkLog(int n, int k) {
		int x = (int) Math.round(Math.pow((double) n, (double) 1 / k));
		return n == Math.pow(x, k);
	}

	List<ArrayList<Integer>> sumOfTwoPowers(int n, int k) {
		List<ArrayList<Integer>> ls = new ArrayList<>();
		int max = (int) Math.round(Math.pow((double) n, (double) 1 / k));
		for (int i = 0; i <= max; i++) {
			for (int j = i; j <= max; j++) {
				int x = (int) Math.pow(i, k);
				int y = (int) Math.pow(j, k);
				if (x + y == n) {
					ls.add(new ArrayList<>(Arrays.asList(x, y)));
					break;
				}
			}
		}
		return ls;
	}

	public static void main(String[] args) {
		SumOfTwoPowers s = new SumOfTwoPowers();
		System.out.println(s.sumOfTwoPowers(50, 2));
	}
}
