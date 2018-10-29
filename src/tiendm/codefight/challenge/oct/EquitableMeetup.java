package tiendm.codefight.challenge.oct;

public class EquitableMeetup {
	int[] equitableMeetup(int[][] friendsRoutes) {
		int[] route = new int[friendsRoutes.length];
		int[] result = new int[friendsRoutes.length];
		int[] candy = new int[friendsRoutes.length];
		for (int i = 0; i < route.length; i++) {
			route[i] = 1;
			result[i] = 1;
			candy[i] = friendsRoutes[i][0];
		}
		int minIdx = minIdx(candy);
		int maxIdx = maxIdx(candy);
		int min = candy[maxIdx] - candy[minIdx];
		while (valid(friendsRoutes, route, minIdx)) {
			if (min == 1) {
				return route;
			}
			candy[minIdx] += friendsRoutes[minIdx][route[minIdx]];
			route[minIdx]++;
			minIdx = minIdx(candy);
			maxIdx = maxIdx(candy);
			int cost = candy[maxIdx] - candy[minIdx];
			if(cost < min){
				min = cost;
				copy(route, result);
			}
		}
		return result;
	}
	
	void copy(int[] from, int[] to){
		for(int i = 0; i < from.length; i++){
			to[i] = from[i];
		}
	}

	private boolean valid(int[][] friendsRoutes, int[] route, int minIdx) {
		for (int i = 0; i < route.length; i++) {
			if (route[i] > friendsRoutes[i].length || (route[i] == friendsRoutes[i].length && minIdx == i)) {
				return false;
			}
		}
		return true;
	}

	int minIdx(int[] candy) {
		int min = candy[0], minIdx = 0;
		for (int i = 1; i < candy.length; i++) {
			if (candy[i] < min) {
				min = candy[i];
				minIdx = i;
			}
		}
		return minIdx;
	}

	int maxIdx(int[] candy) {
		int max = candy[0], maxIdx = 0;
		for (int i = 1; i < candy.length; i++) {
			if (candy[i] > max) {
				max = candy[i];
				maxIdx = i;
			}
		}
		return maxIdx;
	}

	public static void main(String[] args) {
		EquitableMeetup e = new EquitableMeetup();
		int[][] friendsRoutes = { { 1,2,1,1,1,1 }, { 5, 4, 7, 4, 5, 9 }, { 3, 3, 3, 3, 3, 3, 3, 3, 3 } };
		int[] route = e.equitableMeetup(friendsRoutes);
		System.out.println(route);
	}
}
