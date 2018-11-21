package tiendm.codefight.tournament.nov;

public class Tour1121 {
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

	int giftSafety(String gift) {
		int s = 0;
		for (int i = 0; i < gift.length() - 2; i++) {
			char x1 = gift.charAt(i);
			char x2 = gift.charAt(i + 1);
			char x3 = gift.charAt(i + 2);
			if (x1 == x2 || x2 == x3 || x1 == x3) {
				s++;
			}
		}
		return s;
	}

	int secondRightmostZeroBit(int n) {
		return (n | (n+1)) ^ ( (n | (n+1)) | ((n | (n+1))+1)) ;
	}

	public static void main(String[] args) {
		Tour1121 t = new Tour1121();
		int[] values = { 2, 1, 3, 5, 3, 2 };
		String[] s = { "*", "-", "5", "6", "7" };
		System.out.println(t.sumOfCoprimes(5));
	}
}