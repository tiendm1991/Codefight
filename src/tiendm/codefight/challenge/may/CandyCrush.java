package tiendm.codefight.challenge.may;

public class CandyCrush {
	boolean candyCrush1(char[][] gameboard) {
		int x = 0;
		for(int i = 0; i < gameboard.length; i++){
			x = 0;
			for(int j = 0; j < gameboard[0].length-1; j++){
				if(gameboard[i][j] == gameboard[i][j+1]) x++;
			}
			if(x >=2) return true;
		}
		for(int i = 0; i < gameboard[0].length; i++){
			x = 0;
			for(int j = 0; j < gameboard.length-1; j++){
				if(gameboard[j][i] == gameboard[j+1][i]) x++;
			}
			if(x >=2) return true;
		}
		return false;
	}
}
