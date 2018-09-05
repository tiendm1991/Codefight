package tiendm.codefight.challenge.august;

import javax.crypto.spec.GCMParameterSpec;

public class PoolTable {
	int poolTableBounce(int width, int height) {
		int gcd = gcd(width, height);
		int scm = (width * height) / gcd;
		int mid = scm / 2;
		if (mid % height == 0) {
			if ((mid / height) % 2 == 1) {
				return 2;
			}
			return 5;
		}
		if (scm / width % 2 == 0) {
			if (scm / height % 2 == 0) {
				return 1;
			} else {
				return 1;
			}
		} else {
			if (scm / height % 2 == 0) {
				return 4;
			} else {
				return 3;
			}
		}
	}

	int gcd(int a, int b) {
		while (a % b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		return b;
	}

	public static void main(String[] args) {
		PoolTable p = new PoolTable();
		System.out.println(p.poolTableBounce(628, 237));
	}
}
