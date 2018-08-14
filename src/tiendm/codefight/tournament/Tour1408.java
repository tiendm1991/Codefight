package tiendm.codefight.tournament;

public class Tour1408 {
	int numberOfOperations(int a, int b) {
	    int min = Math.min(a,b), max = Math.max(a,b);
	    int count = 0;
	    while(max % min == 0 && min > 1){
	        count ++;
	        int t = min;
	        min = max /min;
	        max = t;
	        if(min > max){
	            int tmp = max;
	            max = min;
	            min = tmp;
	        }
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		Tour1408 t = new Tour1408();
		System.out.println(t.numberOfOperations(432, 72));
	}
}
