package tiendm.codefight.tournament.oct;

import java.util.stream.IntStream;

public class Tour1016 {
	
	int visitsOnCircularRoad(int n, int[] visitsOrder) {
	    int s = 1, sum = 0;
	    for(int i = 0; i < visitsOrder.length; i++){
	        sum += Math.min(Math.abs(visitsOrder[i] - s), 
	                        Math.abs(n - visitsOrder[i] + s));
	        s = visitsOrder[i];
	    }
	    return sum;
	}

	public static void main(String[] args) {
		Tour1016 t = new Tour1016();
		int[] values = { 3, 2, 1 };
		int k = IntStream.of(values).reduce(1, (a, b) -> a * b);
		System.out.println(k);
	}
}
