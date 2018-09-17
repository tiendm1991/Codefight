package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.List;

public class MultiplyToSingleDigit {
	List<Integer> multiplyToSingleDigit(int addend, int limit) {
		List<Integer> lsResult = new ArrayList<>();
		List<Integer> lsFalse = new ArrayList<>();
		if(addend == 0 || limit < 10) return new ArrayList<>();
		for(int i = 10; i <= limit; i++){
			if(isDangerous(i,addend,limit, lsResult, lsFalse)) {
				lsResult.add(i);
			}else{
				lsFalse.add(i);
			}
		}
		return lsResult;
	}


	private boolean isDangerous(int number,int added, int limit, List<Integer> lsResult, List<Integer> lsFalse) {
		String s = "";
		while(true){
			s = number + "";
			int product = 1;
			for(int i = 0; i < s.length(); i++){
				product *= ((s.charAt(i) - '0') + added);
			}
			if(product == number || product > limit || lsResult.contains(product)) return true;
			if(product < 10 || lsFalse.contains(product)) return false;
			number = product;
		}
	}

	public static void main(String[] args) {
		MultiplyToSingleDigit p = new MultiplyToSingleDigit();
		System.out.println(p.multiplyToSingleDigit(2, 21));
	}
}
