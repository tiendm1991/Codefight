package tiendm.codefight.tournament.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1104 {
	boolean increaseNumberRoundness(int n) {

		boolean gotToSignificant = false;
		while (n > 0) {
			if (n % 10 == 0 && gotToSignificant) {
				return true;
			} else if (n % 10 != 0) {
				gotToSignificant = true;
			}
			n /= 10;
		}

		return false;
	}

	int halvingSum(int n) {
		int sum = 0;
		for (int i = n; i > 0; i /= 2) {
			sum += i;
		}
		return sum;
	}

	int maximizeNumberRoundness(int n) {
		String s = n + "";
		int i = 0, j = s.length() - 1;
		int result = 0;
		while (i < j) {
			while (i < j && s.charAt(i) != '0') {
				i++;
			}
			while (i < j && s.charAt(j) == '0') {
				j--;
			}
			if (i < j) {
				result++;
				i++;
				j--;
			}
		}
		return result;
	}

	boolean rightTriangle(int[] sides) {

		class Helper {
			int sqr(int value) {
				return value * value;
			}
		}
		Helper h = new Helper();

		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(sides[0], sides[1], sides[2]));
		Collections.sort(list);
		if (h.sqr(list.get(0)) + h.sqr(list.get(1)) == h.sqr(list.get(2))) {
			return true;
		}
		return false;
	}

	int sumOfCoprimes(int m) {

		int ans = 0;
		for (int p = 2; p <= m; p++) {
			int a = p;
			int b = m;
			while (a > 0) {
				int tmp = b % a;
				b = a;
				a = tmp;
			}

			if (b == 1) {
				ans += p;
			}
		}

		return ans;
	}

	int hailstoneSequence(int n) {
		int s = 0;
		while (n > 1) {
			if (n % 2 == 1) {
				n = n * 3 + 1;
			} else {
				n /= 2;
			}
			s++;
		}
		return s;
	}

	int largestFullBinaryTree(int[] parent) {

		class Graph {
			ArrayList<Integer>[] edges;
			int maxBinTree;

			Graph(int[] parent) {
				maxBinTree = 1;
				edges = new ArrayList[parent.length];
				for (int i = 0; i < edges.length; i++) {
					edges[i] = new ArrayList();
				}
				for (int i = 1; i < parent.length; i++) {
					edges[parent[i]].add(i);
				}
			}

			int dfs(int v) {
				int firstMax = -1;
				int secondMax = -1;
				for (int u : edges[v]) {
					int curMax = dfs(u);
					if (curMax > firstMax) {
						secondMax = firstMax;
						firstMax = curMax;
					} else if (curMax > secondMax) {
						secondMax = curMax;
					}
				}
				if (secondMax == -1) {
					return 1;
				}
				int result = 1 + firstMax + secondMax;
				if (result > maxBinTree) {
					maxBinTree = result;
				}
				return result;
			}
		}

		Graph g = new Graph(parent);
		g.dfs(0);
		return g.maxBinTree;
	}

	int arrayKthGreatestQuick(int[] inputArray, int k) {

		class Helper {
			int[] listToArray(List<Integer> data) {
				int[] res = new int[data.size()];
				for (int i = 0; i < data.size(); i++) {
					res[i] = data.get(i);
				}
				return res;
			}
		}
		;

		int pos = (new Random()).nextInt(inputArray.length);
		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		if (inputArray.length == 1) {
			return inputArray[0];
		}

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < inputArray[pos])
				left.add(inputArray[i]);
			else
				right.add(inputArray[i]);
		}

		Helper h = new Helper();

		if (right.size() >= k) {
			return arrayKthGreatestQuick(h.listToArray(right), k);
		}
		return arrayKthGreatestQuick(h.listToArray(left), k - right.size());
	}

	int differentValuesInMultiplicationTable(int n, int m) {
		int result = 0;
		for (int value = 1; value <= n * m; value++) {
			for (int i = 1; i <= Math.min(n, m); i++) {
				if (value % i == 0 && value / i <= Math.max(n, m)) {
					result++;
					break;
				}
			}
		}
		return result;
	}

	int differentSubstringsTrie(String inputString) {

		class Helper {
			void addNode(ArrayList<int[]> lastVersion) {
				int[] line = new int[26];
				lastVersion.add(line);
			}
		}
		Helper h = new Helper();

		int nodesCount = 1;
		ArrayList<int[]> trie = new ArrayList<>();
		h.addNode(trie);

		for (int i = 0; i < inputString.length(); i++) {
			int currentNode = 0;
			for (int j = i; j < inputString.length(); j++) {
				int symbol = inputString.charAt(j) - 'a';
				if (trie.get(currentNode)[symbol] == 0) {
					h.addNode(trie);
					trie.get(currentNode)[symbol] = nodesCount;
					nodesCount++;
				}
				currentNode = trie.get(currentNode)[symbol];
			}
		}

		return nodesCount - 1;
	}

	int chessBoardSquaresUnderQueenAttack(int a, int b) {

		class Helper {
			int a, b;

			int go(int x, int y, int dx, int dy) {
				if (x < 0 || x >= a || y < 0 || y >= b) {
					return 0;
				}
				return go(x + dx, y + dy, dx, dy) + 1;
			}
		}
		;

		int res = 0;

		Helper h = new Helper();
		h.a = a;
		h.b = b;

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int dx = -1; dx <= 1; dx++) {
					for (int dy = -1; dy <= 1; dy++) {
						if (!(dx == 0 && dy == 0)) {
							res += h.go(i + dx, j + dy, dx, dy);
						}
					}
				}
			}
		}

		return res;
	}

	int evenNumbersBeforeFixed(int[] sequence, int fixedElement) {

		int result = 0;

		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] % 2 == 0 && sequence[i] != fixedElement) {
				result++;
			}
			if (sequence[i] == fixedElement) {
				return result;
			}
		}

		return -1;
	}

	boolean logicalNor(boolean a, boolean b) {
		return !(a || b);
	}

	int chartFix(int[] chart) {
		int max = 1;
		int[] dp = new int[chart.length];
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (chart[i] > chart[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		return chart.length - max;
	}

	public static void main(String[] args) {
		Tour1104 t = new Tour1104();
		int[] values = { 3, 2, 6, 4, 5, 1, 7 };
		String[] s = { "a", "a", "ab", "ab", "abc" };
		System.out.println(t.chartFix(values));
	}
}
