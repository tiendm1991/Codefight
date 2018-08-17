package tiendm.codefight.tournament;

import java.util.HashSet;
import java.util.Set;

public class Tour1708 {

	int chessBoardSquaresUnderQueenAttack(int a, int b) {
		int s = 0;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				for (int x = 0; x < a; x++) {
					for (int y = 0; y < b; y++) {
						if (!(i == x && j == y)
								&& (x == i || y == j || Math.abs(i - j) == Math.abs(x - y) || x + y == i + j))
							s++;
					}
				}
			}
		}
		String note = "";
		note.toCharArray();
		return s;
	}
	
	String stolenLunch(String note) {
	    char[] c = note.toCharArray();
	    for(int i = 0; i < c.length; i++){
	        if(c[i] >= '0' && c[i] <= '9'){
	            c[i] = (char) ((int)'a' + c[i] - '0');
	        }else if(c[i] >= 'a' && c[i] <= 'j'){
	            c[i] = (char) ((int)'0' + c[i] - 'a');
	        }
	    }
	    return new String(c);
	}
	
	boolean bishopAndPawn(String bishop, String pawn) {
	    int x1 = bishop.charAt(0) - 'a' + 1;
	    int y1 = bishop.charAt(1) - '0';
	    int x2 = pawn.charAt(0) - 'a' + 1;
	    int y2 = pawn.charAt(1) - '0';
	    return (x1 + y1) == (x2 + y2) || Math.abs(y1-x1) == Math.abs(y2-x2);
	}

	public static void main(String[] args) {
		Tour1708 t = new Tour1708();
		int[] x = { 5, 9, 1, 2, 4 };
		System.out.println(t.bishopAndPawn("a1", "c3"));
	}
}
