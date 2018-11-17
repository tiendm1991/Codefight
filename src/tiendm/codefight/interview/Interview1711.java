package tiendm.codefight.interview;

public class Interview1711 {
	char firstNotRepeatingCharacter(String s) {
		int[] occ = new int[26];
		char r = '_';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			occ[c - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (occ[c - 'a'] == 1)
				return c;
		}
		return r;
	}

	boolean leapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	int firstDuplicate(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			for (int j = 0; j < i; j++) {
				if (a[j] == x)
					return x;
			}
		}
		return -1;
	}

	int firstDuplicate2(int[] a) {
		int[] occ = new int[a.length + 1];
		int[] min = new int[a.length + 1];
		int minIdx = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int x = a[i];
			occ[x]++;
			if (occ[x] == 2) {
				min[x] = i;
			}
		}
		for (int i = 0; i < min.length; i++) {
			if (min[i] != 0 && min[i] < minIdx) {
				minIdx = min[i];
			}
		}
		return minIdx < Integer.MAX_VALUE ? a[minIdx] : -1;
	}
}
