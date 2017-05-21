package tiendm.codefight.challenge.may;

public class AlienBit {
	String alienBit(String abit) {
		StringBuilder r = new StringBuilder();
		for(int i = 2; i < abit.length()-2; i+=3){
			String s = abit.substring(i,i+3);
			int x = Integer.parseInt(s);
			r.append((char)x);
		}
		return r.toString();
	}

}
