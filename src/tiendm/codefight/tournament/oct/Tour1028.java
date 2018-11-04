package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tour1028 {
	boolean bettingGame(int[] l) {

		int s = 0;
		for (int i = 0; i < l.length; i++) {
			s += l[i];
		}
		if (s == 0) {
			return false;
		}

		return s % l.length == 0;
	}

	int isSumOfConsecutive2(int n) {
		int result = 0;
		for (int start = 1; start < n; start++) {
			int number = n, subtrahend = start;
			while (number > 0) {
				number -= subtrahend;
				subtrahend++;
			}
			if (number == 0) {
				result++;
			}
		}
		return result;
	}

	int kthDigit(int n, int k) {
		String s = n + "";
		if (k < 0 || k > s.length())
			return -1;
		return s.charAt(k - 1) - '0';
	}

	int dotProduct(int[] v1, int[] v2) {
		int s = 0;
		for (int i = 0; i < v1.length; i++) {
			s += v1[i] * v2[i];
		}
		return s;
	}

	String[] sortByLength(String[] inputArray) {
		List<Integer> initIndex = new ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			initIndex.add(i);
		}
		for (int i = 0; i < inputArray.length; i++) {
			int minIndex = i;
			String tmp = inputArray[i];
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j].length() < inputArray[minIndex].length()
						|| (inputArray[j].length() == inputArray[minIndex].length()
								&& initIndex.get(j) < initIndex.get(minIndex))) {
					minIndex = j;
				}
			}
			inputArray[i] = inputArray[minIndex];
			inputArray[minIndex] = tmp;
			int tmp2 = initIndex.get(minIndex);
			initIndex.set(minIndex, initIndex.get(i));
			initIndex.set(i, tmp2);
		}

		return inputArray;
	}

	String lineEncoding(String s) {

		s += "#";
		int cnt = 1;
		StringBuilder result = new StringBuilder();
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				cnt++;
			} else {
				if (cnt > 1) {
					result.append(cnt);
				}
				result.append(s.charAt(i - 1));
				cnt = 1;
			}
		}

		return result.toString();
	}

	int combs(String comb1, String comb2) {

		class Helper {
			int getMask(String comb) {
				int mask = 0;
				for (int i = 0; i < comb.length(); i++) {
					char c = comb.charAt(i);
					mask = (mask << 1) + (c == '*' ? 1 : 0);
				}
				return mask;
			}
		}
		Helper h = new Helper();

		int m1 = h.getMask(comb1);
		int m2 = h.getMask(comb2);
		int len1 = comb1.length();
		int len2 = comb2.length();
		int answer = len1 + len2;
		for (int i = -len1; i <= len2; i++) {
			int tmp, length;
			if (i < 0) {
				tmp = m2 << (-i) & m1;
				length = Math.max(-i + len2, len1);
			} else {
				tmp = m1 << i & m2;
				length = Math.max(i + len1, len2);
			}
			if (tmp == 0 && answer > length) {
				answer = length;
			}
		}

		return answer;
	}

	int[] digitalSumSort(int[] a) {

		class Helper {
			int digitalSum(int n) {
				int sum = 0;
				while (n > 0) {
					sum += n % 10;
					n /= 10;
				}
				return sum;
			}
		}
		Helper h = new Helper();

		Map<Integer, ArrayList<Integer>> buckets = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int sum = h.digitalSum(a[i]);
			if (!buckets.containsKey(sum)) {
				buckets.put(sum, new ArrayList<Integer>());
			}
			buckets.get(sum).add(a[i]);
		}

		int[] b = new int[a.length];
		int cnt = 0;
		for (int sum : buckets.keySet()) {
			ArrayList<Integer> bucket = buckets.get(sum);
			Collections.sort(bucket);
			for (int i = 0; i < bucket.size(); i++) {
				b[cnt++] = bucket.get(i);
			}
		}

		return b;
	}

	boolean regularBracketSequence1(String sequence) {

		int balance = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if (sequence.charAt(i) == '(') {
				balance++;
			} else {
				balance--;
			}
			if (balance < 0) {
				return false;
			}
		}
		return balance == 0;
	}

	int longestSequence(int[] a) {

		int best = 1;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int diff = a[j] - a[i];
				if (diff == 0) {
					continue;
				}
				int cur = 1;
				int last = a[i];
				for (int k = j; k < a.length; k++) {
					if (a[k] - last == diff) {
						cur++;
						last = a[k];
					}
				}
				if (cur > best) {
					best = cur;
				}
			}
		}

		return best;
	}

	int numberOfTriangles2(int[] sticks) {

		int ans = 0;
		for (int i = 0; i < sticks.length - 2; i++) {
			for (int j = i + 1; j < sticks.length - 1; j++) {
				int mx = sticks[i] + sticks[j];
				int l = j, r = sticks.length;
				while (r - l > 1) {
					int m = (l + r) / 2;
					if (sticks[m] >= mx) {
						r = m;
					} else {
						l = m;
					}
				}
				ans += r - j - 1;
			}
		}

		return ans;
	}

	int minimalNumberOfCoins(int[] coins, int price) {

		int result = 0;

		for (int i = coins.length - 1; i >= 0; i--) {
			result += price / coins[i];
			price %= coins[i];
		}

		if (price != 0) {
			return -1;
		}
		return result;
	}

	public static void main(String[] args) {
		Tour1028 t = new Tour1028();
		int[] values = { 2, 3, 4 };
		String[] s = { "a", "a", "ab", "ab", "abc" };
		System.out.println(t);
		System.out.println(5 << 1);
	}
}
