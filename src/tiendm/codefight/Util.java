package tiendm.codefight;

public class Util {
	boolean isPrime(int x){
	    if(x == 2 || x == 3) return true;
	    for(int i = 2; i < x/2; i++){
	        if(x % i == 0) return false;
	    }
	    return true;
	}
}
