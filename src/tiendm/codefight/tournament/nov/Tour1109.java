package tiendm.codefight.tournament.nov;

/**
 * @author tien.dinhmanh
 *
 */
public class Tour1109 {
	String longestDigitsPrefix(String inputString) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < inputString.length(); i++) {
			if (inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
				result.append(inputString.charAt(i));
			} else {
				break;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Tour1109 t = new Tour1109();
		int[] values = { -1000, 0, -2, 0 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t);
	}
}
