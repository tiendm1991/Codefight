package tiendm.codefight.tournament.oct;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Tour1020 {
	String myConcat(String[] strings, String separator) {
		return Arrays.asList(strings).stream().map(x -> x).collect(Collectors.joining(separator)) + separator;
	}

	int[] easyAssignmentProblem(int[][] skills) {
		int a1 = skills[0][0] + skills[1][1];
		int a2 = skills[0][1] + skills[1][0];
		if (a1 < a2) {
			return new int[] { 2, 1 };
		}
		return new int[] { 1, 2 };
	}

	int digitDegree(int n) {
		class Helper {
			int digitSum(int n) {
				int sum = 0;
				while (n != 0) {
					sum += n % 10;
					n /= 10;
				}
				return sum;
			}
		}
		Helper h = new Helper();

		int result = 0;

		while (n > 9) {
			result++;
			n = h.digitSum(n);
		}

		return result;
	}

	int[][] matrixTransposition(int[][] matrix) {

		int[][] result = new int[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				result[j][i] = matrix[j][i];
			}
		}
		return result;
	}

	int smallestMultiple(int left, int right) {
		int mul = left;
		for (int i = left + 1; i <= right; i++) {
			int g = gcd(i, mul);
			mul = mul * i / g;
		}
		return mul;
	}

	int gcd(int a, int b) {
		while (a % b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

	int cyclicString(String s) {
		for (int answer = 1; answer < s.length(); answer++) {
			boolean correct = true;
			for (int position = 0; position + answer < s.length(); position++) {
				if (s.charAt(position) != s.charAt(position + answer)) {
					correct = false;
					break;
				}
			}
			if (correct) {
				return answer;
			}
		}
		return s.length();
	}

	public static void main(String[] args) {
		Tour1020 t = new Tour1020();
		int[] values = { 1, 3, 4, 2 };
		System.out.println(t);
	}
}
