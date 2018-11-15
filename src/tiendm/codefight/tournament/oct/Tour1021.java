package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.List;

public class Tour1021 {
	int fact(int n) {
		if (n == 0)
			return 1;
		return fact(n - 1) * n;
	}

	int countWays(int n, int k) {
		return fact(n) / (fact(k) * fact(n - k));
	}

	List<ArrayList<Integer>> countAwayList(int n, int k) {
		List<ArrayList<Integer>> set = new ArrayList<>();
		count(set, 1, n, k, new ArrayList<>());
		return set;
	}

	private void count(List<ArrayList<Integer>> set, int i, int n, int k, ArrayList<Integer> ls) {
		if (ls == null) {
			ls = new ArrayList<>();
		}
		if (ls.size() >= k - 1 && ls.get(ls.size() - 1) == n)
			return;
		ls.add(i);
		if (i == n) {
			set.add(ls);
			ls = new ArrayList<>(ls);
			ls.remove(ls.size() - 1);
			int x = ls.get(ls.size() - 1);
			x++;
			ls.set(ls.size() - 1, x);
			count(set, x + 1, n, k, ls);
		} else if (ls.size() == k) {
			set.add(ls);
			ls = new ArrayList<>(ls);
			ls.remove(ls.size() - 1);
			count(set, i + 1, n, k, ls);
		} else {
			count(set, i + 1, n, k, ls);
		}
	}

	int findSquareSide(int[] x, int[] y) {
		double d1 = distance(x[0], x[1], y[0], y[1]);
		double d2 = distance(x[0], x[2], y[0], y[2]);
		double d3 = distance(x[0], x[3], y[0], y[3]);
		if (d1 == d2 || d1 == d3) {
			return (int) (d1 * d1);
		}
		return (int) (d2 * d2);
	}

	double distance(int x1, int x2, int y1, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
	
	int swapNeighbouringDigits(int n) {
		String s = n + "";
		char[] c = s.toCharArray();
		for (int i = 0; i < c.length - 1; i += 2) {
			char tmp = c[i];
			c[i] = c[i + 1];
			c[i + 1] = tmp;
		}
		String newStr = new String(c);
		return Integer.parseInt(newStr);
	}

	public static void main(String[] args) {
		Tour1021 t = new Tour1021();
		int[] values = { 1, 3, 4, 2 };
		System.out.println(t.countAwayList(6, 3));
	}
}
