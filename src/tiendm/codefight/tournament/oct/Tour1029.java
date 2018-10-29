package tiendm.codefight.tournament.oct;

import java.util.Arrays;
import java.util.LinkedList;

public class Tour1029 {
	boolean regularBracketSequence2(String sequence) {

		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < sequence.length(); i++) {
			if (stack.size() > 0 && stack.getLast() == '(' && sequence.charAt(i) == ')') {
				stack.pollLast();
				continue;
			}
			if (stack.size() > 0 && stack.getLast() == '[' && sequence.charAt(i) == ']') {
				stack.pollLast();
				continue;
			}
			stack.addLast(sequence.charAt(i));
		}

		if (stack.size() != 0) {
			return false;
		}
		return true;
	}

	int caesarBoxCipherEncoding2(String inputString) {
		class Helper {
			String encode(String s, int n) {
				StringBuilder res = new StringBuilder();
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < s.length() / n; j++) {
						res.append(s.charAt(j * n + i));
					}
				}
				return res.toString();
			}
		}
		;

		Helper h = new Helper();

		int res = 0;
		int len = inputString.length();
		int sqrt_len = (int) Math.sqrt(len);
		for (int n = 2; n < sqrt_len + 1; n++) {
			if (len % n == 0) {
				if (h.encode(h.encode(inputString, n), n).equals(inputString)) {
					res += 2;
				}
			}
		}

		if (sqrt_len * sqrt_len == len) {
			res--;
		}

		return res;
	}

	int makeArrayConsecutive2(int[] statues) {

		int current_position = 0, answer = 0;

		Arrays.sort(statues);
		for (int i = 0; i < statues.length; i++) {
			if (statues[current_position] != statues[0] + current_position) {
				answer++;
			} else {
				current_position++;
			}
		}

		return answer;
	}

	int nearestRoundNumber(int value) {
		while (value % 10 != 0) {
			value++;
		}
		return value;
	}

	int maximalEven(int[] inputArray) {
		int max = 0;
		for (int x : inputArray) {
			if (x > max && x % 2 == 0)
				max = x;
		}
		return max;
	}

	int countDigitsInNumber(int n) {
		int count = 0;
		while (n > 0) {
			count++;
			n /= 10;
		}
		return count;
	}

	int pagesNumberingWithInk(int current, int numberOfDigits) {
		int digitsInCurrent = countDigitsInNumber(current);
		while (numberOfDigits >= digitsInCurrent) {
			numberOfDigits -= digitsInCurrent;
			current++;
			digitsInCurrent = countDigitsInNumber(current);
		}
		return current - 1;
	}

	public static void main(String[] args) {
		Tour1029 t = new Tour1029();
		int[] values = { 7, 2 };
		String[] s = { "a", "a", "ab", "ab", "abc" };
		System.out.println(t.maximalEven(values));
	}
}
