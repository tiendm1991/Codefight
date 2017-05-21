package tiendm.codefight.core;

import javax.swing.text.AbstractDocument.LeafElement;

public class BookMarket {
	String properNounCorrection(String noun) {
	    return noun.substring(0,1).toUpperCase()+noun.substring(1).toLowerCase();
	}
	boolean isTandemRepeat(String inputString) {
		int length = inputString.length();
	    return inputString.substring(0,length/2).equals(inputString.substring(length/2));
	}
	
	boolean isCaseInsensitivePalindrome(String inputString) {
		String strUpper = inputString.toUpperCase();
		int i = 0, j = strUpper.length()-1;
		while (i < j) {
			if(strUpper.charAt(i) != strUpper.charAt(j)) return false;
			i++;j--;
		}
		return true;
	}
	
	String findEmailDomain(String address) {
		return address.substring(address.lastIndexOf("@"));
	}
	
	String htmlEndTagByStartTag(String startTag) {
		StringBuilder builder = new StringBuilder("</");
		int i = 1;
		char c;
		do  {
			c = startTag.charAt(i);
			if(c == ' ' || c == '>') break;
			builder.append(c);
			i++;
		}while (true);
		return builder.append(">").toString();
	}
	
	boolean isUnstablePair(String filename1, String filename2) {
		int filename1_lessthan_2 = filename1.toLowerCase().compareTo(filename2);
		int filename1Upper_lessthan_2 = filename1.toUpperCase().compareTo(filename2);
		return (filename1_lessthan_2 * filename1Upper_lessthan_2 < 0);
	}

	public static void main(String[] args) {
		BookMarket test = new BookMarket();
		System.out.println(test.isUnstablePair("mehOu","mehau"));
	}
}
