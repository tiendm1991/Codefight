package tiendm.codefight.challenge.april;

import java.util.ArrayList;
import java.util.List;

public class CharWeight {
	String charWeight(String s) {
		s = s.toLowerCase();
		int[] f = new int[36];
		for(char c : s.toCharArray()){
			if(c >= '0' && c <= '9'){
				f[c-'0'+26]++;
			} else if(c >= 'a' && c <= 'z'){
				f[c-'a']++;
			}
		}
		int count = 0;
		for(int i : f){if(i > 0) count++;};
		String r = "";
		List<Integer> visited = new ArrayList<>();
		for(int i = 0; i < count; i++){
			int max  = 0, maxIdx = 0;
			for(int j = 0; j < f.length; j++){
				if(visited.contains(j)) continue;
				if(f[j] > max || (f[j] == max && maxIdx < 26 && j >=26)){
					max = f[j];
					maxIdx = j;
				}
			}
			if(f[maxIdx] > 0){
				if(maxIdx < 26){
					r += (char)('a' + maxIdx) + "{" +f[maxIdx] + "}";
				}else {
					r += (char)('0' + (maxIdx-26)) + "{" +f[maxIdx] + "}";
				}
			}
			visited.add(maxIdx);
		}
		return r;
	}
	
	public static void main(String[] args) {
		String s = "1abc10DefA7892164aSd";
		CharWeight c = new CharWeight();
		System.out.println(c.charWeight(s));
	}
}
