package tiendm.codefight.tournament.sep;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Tour1709 {
	String truncateString(String s) {
		if (s.length() == 1) {
			if (Integer.parseInt(s) % 3 == 0) {
				return "";
			}
			return s;
		}
		if (getInt(s, 0) % 3 == 0)
			return truncateString(s.substring(1));
		if (getInt(s, s.length()-1) % 3 == 0)
			return truncateString(s.substring(0, s.length()-1));
		if ((getInt(s, 0) + getInt(s, s.length()-1)) % 3 == 0) {
			return truncateString(s.substring(1, s.length() - 1));
		}
		return s;
	}
	
	int getInt(String s, int idx){
		return s.charAt(idx) - '0';
	}

	public static void main(String[] args) {
		Tour1709 t = new Tour1709();
		int[] fromV = { 2, 1, 3, 4, 4, 4, 1 };
		int[] toV = { 3, 2, 1, 3, 2, 1, 4 };
		System.out.println(t.truncateString("312248"));
	}
}
