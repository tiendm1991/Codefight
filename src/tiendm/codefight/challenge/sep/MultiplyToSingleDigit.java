package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.List;

public class MultiplyToSingleDigit {
	List<Integer> multiplyToSingleDigit(int addend, int limit) {
		List<Integer> lsResult = new ArrayList<>();
		List<Integer> lsFalse = new ArrayList<>();
		if (addend == 0 || limit < 10)
			return new ArrayList<>();
		for (int i = 10; i <= limit; i++) {
			if (isDangerous(i, addend, limit, lsResult, lsFalse)) {
				lsResult.add(i);
			} else {
				lsFalse.add(i);
			}
		}
		return lsResult;
	}

	private boolean isDangerous(int number, int added, int limit, List<Integer> lsResult, List<Integer> lsFalse) {
		String s = "";
		while (true) {
			s = number + "";
			int product = 1;
			for (int i = 0; i < s.length(); i++) {
				product *= ((s.charAt(i) - '0') + added);
			}
			if (product == number || product > limit
					|| (!lsResult.isEmpty() && binarySearch(lsResult, product, 0, lsResult.size() - 1)))
				return true;
			if (product < 10 || (!lsFalse.isEmpty() && binarySearch(lsFalse, product, 0, lsFalse.size() - 1)))
				return false;
			number = product;
		}
	}

	boolean binarySearch(List<Integer> ls, int value, int s, int e) {
		if (s == e) {
			return ls.get(s).equals(value);
		}
		int mid = (s + e) / 2;
		if (ls.get(mid).equals(value)) {
			return true;
		} else if (ls.get(mid) < value) {
			return binarySearch(ls, value, mid + 1, e);
		} else {
			return binarySearch(ls, value, s, mid);
		}
	}

	public static void main(String[] args) {
		MultiplyToSingleDigit p = new MultiplyToSingleDigit();
		System.out.println(p.multiplyToSingleDigit(2, 21));
	}
}
