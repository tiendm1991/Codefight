package tiendm.codefight.challenge.may;

public class WorthyDiceSet {
	int worthyDiceSet(int n, int mod) {
		int[] s = new int[n];
		return count(s, 0, n, mod);
	}
	
	int count(int[] s, int p, int n, int mod){
		int c = 0;
		if(p == n) {
			return check(s, mod) ? 1 : 0;
		}
		for(int i = 1; i <= 6; i++){
			s[p] = i;
			c += count(s, p+1, n , mod);
		}
		return c;
	}
	
	boolean check(int[] a, int mod){
		int s = 0, p = 1;
		for(int i = 0; i < a.length; i++){
			s += a[i];
			p *= a[i];
		}
		return (s - p + mod) % mod == 0;
	}
	
	public static void main(String[] args) {
		WorthyDiceSet test = new WorthyDiceSet();
		System.out.println(test.worthyDiceSet(3,5));
	}
}
