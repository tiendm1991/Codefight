package tiendm.codefight.challenge.may;

public class QuadZip {
	String quadZip(String one, String two, String three, String four) {
		int i = 0, a = one.length(), b = two.length(), c= three.length(), d= four.length() ;
		StringBuilder builder = new StringBuilder();
		while (true) {
			if(i < a) builder.append(one.charAt(i));
			if(i < b) builder.append(two.charAt(i));
			if(i < c) builder.append(three.charAt(i));
			if(i < d) builder.append(four.charAt(i));
			i++;
			if(i >= a && i >=b && i>=c && i>=d) break;
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		QuadZip test = new QuadZip();
		System.out.println(test.quadZip("\"", "abc", "abc", "abc"));
	}
}
