package tiendm.codefight.tournament;

public class Tour2208 {
	int factorSum(int n) {
		int next = 0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && isPrime(i)) {
				next += i;
				n /= i;
				i = 1;
			}
			if (i == n)
				break;
		}
		if (isPrime(next))
			return next;
		return factorSum(next);
	}

	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Tour2208 t = new Tour2208();
		System.out.println(t.factorSum(24));
	}
}
