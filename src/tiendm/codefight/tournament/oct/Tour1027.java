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

	public static void main(String[] args) {
		Tour1027 t = new Tour1027();
		int[] values = { 2, 3, 4 };
		String[] s = { "a", "a", "ab", "ab", "abc" };
		System.out.println(t.stringsConstruction("zzz", "zzzzzzzzzzz"));
	}
}
