package tiendm.codefight.interview.nov;

public class Interview1118 {
	int[][] rotateImage(int[][] a) {
		int N = a.length;
		int[][] b = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				b[i][j] = a[N - 1 - j][i];
			}
		}
		return b;
	}

	boolean sudoku2(char[][] grid) {
		for (int i = 0; i < 9; i++) {
			int[] check = new int[9];
			for (int j = 0; j < 9; j++) {
				if (grid[i][j] != '.') {
					check[grid[i][j] - '1']++;
				}
			}
			for (int x : check) {
				if (x > 1)
					return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			int[] check = new int[9];
			for (int j = 0; j < 9; j++) {
				if (grid[j][i] != '.') {
					check[grid[j][i] - '1']++;
				}
			}
			for (int x : check) {
				if (x > 1)
					return false;
			}
		}
		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				int[] check = new int[9];
				for (int a = i; a < i + 3; a++) {
					for (int b = j; b < j + 3; b++) {
						if (grid[a][b] != '.') {
							check[grid[a][b] - '1']++;
						}
					}
				}
				for (int x : check) {
					if (x > 1)
						return false;
				}
			}
		}
		return true;
	}

	boolean isCryptSolution(String[] crypt, char[][] solution) {
		char[] solutionConvert = new char[26];
		for (int i = 0; i < solution.length; i++) {
			solutionConvert[solution[i][0] - 'A'] = solution[i][1];
		}
		if (!isValid(crypt[0], solutionConvert) || !isValid(crypt[1], solutionConvert)
				|| !isValid(crypt[2], solutionConvert)) {
			return false;
		}
		return getNum(crypt[0], solutionConvert) + getNum(crypt[1], solutionConvert) == getNum(crypt[2],
				solutionConvert);
	}

	private boolean isValid(String str, char[] solutionConvert) {
		return str != null && str.length() >= 1 && !(str.length() > 1 && solutionConvert[str.charAt(0) - 'A'] == '0');
	}

	double getNum(String s, char[] solutionConvert) {
		String x = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			x += solutionConvert[c - 'A'] + "";
		}
		return Double.parseDouble(x);
	}

	public static void main(String[] args) {
		Interview1118 i = new Interview1118();
		String[] crypt = { "SEND", "MORE", "MONEY" };
		char[][] solution = { { 'O', '0' }, { 'M', '1' }, { 'Y', '2' }, { 'E', '5' }, { 'N', '6' }, { 'D', '7' },
				{ 'R', '8' }, { 'S', '9' } };
		System.out.println(i.isCryptSolution(crypt, solution));
	}
}
