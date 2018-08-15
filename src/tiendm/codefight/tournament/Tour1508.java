package tiendm.codefight.tournament;

import java.util.Arrays;

public class Tour1508 {
	boolean isPangram(String sentence) {
	    int[] occ = new int[26];
	    sentence = sentence.toUpperCase();
	    for(int i = 0; i < sentence.length(); i++){
	        occ[sentence.charAt(i) - 'A']++;
	    }
	    for(int i = 0; i < occ.length; i++){
	        if(occ[i] ==0) return false;
	    }
	    return true;
	}

	public static void main(String[] args) {
		Tour1508 t = new Tour1508();
		System.out.println(t.isPangram("abcdefghijklmnopqrstuvwxya"));
	}
}
