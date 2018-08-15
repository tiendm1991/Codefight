package tiendm.codefight;

public class Util {
	boolean isPrime(int x) {
		if (x == 2 || x == 3)
			return true;
		for (int i = 2; i < x / 2; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
	
	int chessKnight(String cell) {
		  int row = Integer.parseInt("" + cell.charAt(1)),
		      column = cell.charAt(0) - 'a' + 1;
		  int[][] steps = {
		      {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
		      {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
		  };
		  int answer = 0;

		  for (int i = 0; i < steps.length; i++) {
		    int tmpRow =  row + steps[i][0];
		    int tmpColumn = column + steps[i][1];
		    if (tmpRow >= 1 && tmpRow <= 8 &&
		        tmpColumn >= 1 && tmpColumn <= 8) {
		      answer++;
		    }
		  }

		  return answer;
		}

	int countSumOfTwoRepresentations(int n, int l, int r) {
		int result = 0;
		for (int a = l; a <= r; a++) {
			for (int b = a; b <= n; b++) {
				if (a + b == n) {
					result++;
					break;
				}
			}
		}
		return result;
	}
	
	int countSumOfTwoRepresentations2(int n, int l, int r) {
	    int c = 0;
	    for(int i = l; i <= r; i++){
	        if(i <= n-i && n-i <=r) c++;
	    }
	    return c;
	}


}
