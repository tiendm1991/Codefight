package tiendm.codefight.challenge.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MiracleOfChain {
	String[] miracleOfChain(String[] n) {
		ArrayList<String> r = new ArrayList<>();
		String first = "";
		int idxFirst = 0;
		for(int i = 0; i < n.length; i++){
			String f = n[i].substring(0, 1).toLowerCase();
			int count = 0;
			for(int j = 0; j < n.length; j++){
				if(i == j) continue;
				String l = n[j].substring(n[j].length()-1).toLowerCase();
				if(f.equals(l)) {
					break;
				}else {
					count++;
				}
			}
			if(count == n.length-1) {
				first = n[i];
				idxFirst = i;
			}
		}
		r.add(first);
		while (r.size() < n.length) {
			String f = first.substring(first.length()-1).toLowerCase();
			for(int i = 0; i < n.length; i++){
				if(i == idxFirst) continue;
				if(n[i].substring(0, 1).equalsIgnoreCase(f)){
					r.add(n[i]);
					idxFirst = i;
					first = n[i];
					break;
				}
			}
		}
		return r.toArray(n);
	}
	public static void main(String[] args) {
		MiracleOfChain m = new MiracleOfChain();
		String[] s = {"Raymond", 
				 "Nora", 
				 "Daniel", 
				 "Louie", 
				 "Peter", 
				 "Esteban"};
		System.out.println(Arrays.toString(m.miracleOfChain(s)));
	}
}
