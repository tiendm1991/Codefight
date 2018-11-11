package tiendm.codefight.tournament.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1111 {
	int equidistantTriples(int[] coordinates) {

		int ans = 0;
		for (int i = 1; i < coordinates.length - 1; i++) {
			int left = i - 1;
			int right = i + 1;
			while (left >= 0 && right < coordinates.length) {
				int distL = coordinates[i] - coordinates[left];
				int distR = coordinates[right] - coordinates[i];
				if (distL == distR) {
					ans++;
					left--;
					right++;
				} else if (distL < distR) {
					left--;
				} else {
					right++;
				}
			}
		}

		return ans;
	}

	int firstMultiple(int[] divisors, int start) {

		for (int answer = start;; answer++) {
			boolean correct = true;
			for (int i = 0; i < divisors.length; i++) {
				if (answer % divisors[i] != 0) {
					correct = false;
				}
			}
			if (correct) {
				return answer;
			}
		}
	}

	int largestDistance(int[] a) {

		int[] mx = new int[] { a[2], a[3] };
		int[] mn = new int[] { a[0], a[1] };
		for (int i = 0; i < a.length; i++) {
			int k = i % 2;
			if (a[i] > mx[k]) {
				mx[k] = a[i];
			} else if (a[i] < mn[k]) {
				mn[k] = a[i];
			}
		}
		return Math.max(mx[0] - mn[0], mx[1] - mn[1]);
	}

	boolean orthogonalLines(int[] line1, int[] line2) {
		return line1[0] * line2[0] + line1[1] * line2[1] == 0;
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
			if (inputArray[i] <= inputArray[pos]) {
				left.add(inputArray[i]);
			} else {
				right.add(inputArray[i]);
			}
		}

		Helper h = new Helper();

		if (right.size() >= k) {
			return arrayKthGreatestQuick(h.listToArray(right), k);
		}
		return arrayKthGreatestQuick(h.listToArray(left), k - right.size());
	}

	int maximumSubsetProduct(int[] a) {
		if (a.length == 1)
			return 1;
		Arrays.sort(a);
		int positive = 0;
		for (int i : a) {
			if (i < 0)
				positive++;
		}
		if (positive % 2 == 0) {
			return 1;
		}
		for (int i = 1; i < a.length; i++) {
			if (i == a.length - 1 && a[i] < 0)
				return a[i];
			if (a[i] >= 0)
				return a[i - 1];
		}
		return a[0];
	}

	int piecesOfDistinctLengths(int strawLength) {
		int s = 0, i = 1;
		while (s + i <= strawLength) {
			s += i;
			i++;
		}
		return i - 1;
	}

	int bfsDistancesUnweightedGraph2(boolean[][] matrix, int vertex1, int vertex2) {

		boolean[] visited = new boolean[matrix.length];
		LinkedList<Integer> queue = new LinkedList<>();
		int[] distance = new int[matrix.length];

		visited[vertex1] = true;
		queue.add(vertex1);
		while (queue.size() > 0) {
			int currentVertex = queue.pop();
			visited[currentVertex] = true;
			for (int nextVertex = 0; nextVertex < matrix.length; nextVertex++) {
				if (matrix[currentVertex][nextVertex] && !visited[nextVertex]) {
					visited[nextVertex] = true;
					distance[nextVertex] = distance[currentVertex] + 1;
					queue.add(nextVertex);
				}
			}
		}

		return distance[vertex2];
	}

	int arrayKthGreatest(int[] inputArray, int k) {

		for (int i = 0; i < k; i++) {
			int indexOfMaximum = i, tmp = inputArray[i];

			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] > inputArray[indexOfMaximum]) {
					indexOfMaximum = j;
				}
			}

			inputArray[i] = inputArray[indexOfMaximum];
			inputArray[indexOfMaximum] = tmp;
		}

		return inputArray[k - 1];
	}

	public static void main(String[] args) {
		Tour1111 t = new Tour1111();
		int[] values = { 1, 6, 7 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t);
	}
}
