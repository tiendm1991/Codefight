package tiendm.codefight.tournament.nov;

import java.util.regex.Pattern;

public class Tour1117 {
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

	boolean latinLettersSearchRegExp(String input) {
		return Pattern.compile("[A-Za-z]").matcher(input).find();
	}

	int summaryProficiency(int[] a, int n, int m) {

		int result = 0;
		for (int i = 0; n > 0; i++) {
			if (a[i] >= m) {
				result += a[i];
				n--;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Tour1117 t = new Tour1117();
		int[] values = { 2, 1, 3, 5, 3, 2 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t);
	}
}