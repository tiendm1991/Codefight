package tiendm.codefight.tournament.oct;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tour1027 {
	int dfsComponentSize(boolean[][] matrix, int vertex) {
		boolean[] visited = new boolean[matrix.length];
		return dfs(matrix, vertex, visited);
	}

	int dfs(boolean[][] matrix, int vertex, boolean[] visited) {
		int ans = 1;
		visited[vertex] = true;
		for (int i = 0; i < matrix.length; i++) {
			if (!visited[i] && matrix[vertex][i]) {
				ans += dfs(matrix, i, visited);
			}
		}
		return ans;
	}

	String[] removeDuplicateStrings(String[] inputArray) {
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < inputArray.length; i++) {
			if (i + 1 < inputArray.length && inputArray[i].equals(inputArray[i + 1])) {
				continue;
			}
			result.add(inputArray[i]);
		}
		return result.toArray(new String[0]);
	}

	int digitsProduct(int product) {
		ArrayList<Integer> answerDigits = new ArrayList<>();
		int answer = 0;

		if (product == 0) {
			return 10;
		}

		if (product == 1) {
			return 1;
		}

		for (int divisor = 9; divisor > 1; divisor--) {
			while (product % divisor == 0) {
				product /= divisor;
				answerDigits.add(divisor);
			}
		}

		if (product > 1) {
			return -1;
		}

		for (int i = answerDigits.size() - 1; i >= 0; i--) {
			answer = answer * 10 + answerDigits.get(i);
		}
		return answer;
	}

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

	int stringsConstruction(String A, String B) {

		class Helper {
			int[] countLetters(String s) {
				int[] cnt = new int[26];
				for (int i = 0; i < s.length(); i++) {
					cnt[s.charAt(i) - 'a']++;
				}
				return cnt;
			}
		}
		Helper h = new Helper();

		int[] cntA = h.countLetters(A);
		int[] cntB = h.countLetters(B);
		int best = -1;
		for (int i = 0; i < 26; i++) {
			if (cntA[i] == 0) {
				continue;
			}
			int cur = cntB[i] / cntA[i];
			if (best == -1 || cur < best) {
				best = cur;
			}
		}

		return best;
	}

	String properNounCorrection(String noun) {

		class Helper {
			boolean isLowerCase(char symbol) {
				if ('a' <= symbol && symbol <= 'z') {
					return true;
				}
				return false;
			}
		}
		;
		Helper h = new Helper();

		StringBuilder result = new StringBuilder();

		if (h.isLowerCase(noun.charAt(0))) {
			result.append((char) (noun.charAt(0) - 'a' + 'A'));
		} else {
			result.append(noun.charAt(0));
		}

		for (int i = 1; i < noun.length(); i++) {
			if (!h.isLowerCase(noun.charAt(i))) {
				result.append((char) (noun.charAt(i) - 'A' + 'a'));
			} else {
				result.append(noun.charAt(i));
			}
		}

		return result.toString();
	}

	boolean isIPv4Address(String inputString) {

		int currentNumber = 0;
		boolean emptyField = true;
		int countNumbers = 0;

		inputString += '.';

		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) == '.') {
				if (emptyField) {
					return false;
				}
				countNumbers++;
				currentNumber = 0;
				emptyField = true;
			} else {
				int digit = inputString.charAt(i) - '0';
				if (digit < 0 || digit > 9) {
					return false;
				}
				emptyField = false;
				currentNumber = currentNumber * 10 + digit;
				if (currentNumber > 255) {
					return false;
				}
			}
		}
		return countNumbers == 4;
	}

	String integerToStringOfFixedWidth(int number, int width) {

		StringBuffer result = new StringBuffer();

		for (int i = 0; i < width; i++) {
			result.append('0');
		}

		int position = result.length() - 1;
		while (number != 0 && position >= 0) {
			result.replace(position, position + 1, Integer.toString(number % 10));
			number /= 10;
			position--;
		}

		return result.toString();
	}

	int waterTubes(int[] water, int[] flowPerMinute) {
		int result = 0;

		for (int i = 0; i < water.length; i++) {
			int minutes = water[i] / flowPerMinute[i];
			if (water[i] % flowPerMinute[i] != 0) {
				minutes++;
			}
			if (result < minutes) {
				result = minutes;
			}
		}
		return result;
	}

	ArrayList<Double> liquidMixing(ArrayList<Integer> densities) {
		ArrayList<Double> result = new ArrayList<>();
		result.add((double) densities.get(0));
		for (int i = 1; i < densities.size(); i++) {
			for (int j = 0; j <= i; j++) {
				if (densities.get(i) <= densities.get(j)) {
					int tmp = densities.get(i);
					for (int k = i; k > j; k--) {
						densities.set(k, densities.get(k - 1));
					}
					densities.set(j, tmp);
					if (i % 2 == 1) {
						result.add((densities.get((i + 1) / 2) + densities.get(i / 2)) / 2.0);
					} else {
						result.add((double) densities.get(i / 2));
					}
					break;
				}
			}
		}
		return result;
	}

	int toAndFro(int a, int b, int t) {
		int position = a, dx;

		if (a < b) {
			dx = 1;
		} else {
			dx = -1;
		}

		for (int i = 0; i < t; i++) {
			position += dx;
			if (position == a || position == b) {
				dx = -1 * dx;
			}
		}

		return position;
	}

	public static void main(String[] args) {
		Tour1027 t = new Tour1027();
		int[] values = { 2, 3, 4 };
		String[] s = { "a", "a", "ab", "ab", "abc" };
		System.out.println(t.stringsConstruction("zzz", "zzzzzzzzzzz"));
	}
}
