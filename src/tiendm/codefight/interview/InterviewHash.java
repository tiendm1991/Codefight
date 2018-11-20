package tiendm.codefight.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class InterviewHash {

	List<ArrayList<String>> groupingDishes(String[][] dishes) {
		Map<String, ArrayList<String>> _map = new TreeMap<>();
		for (String[] dish : dishes) {
			String dishName = dish[0];
			for (int i = 1; i < dish.length; i++) {
				String ingredient = dish[i];
				ArrayList<String> dishList = _map.get(ingredient);
				if (dishList == null) {
					dishList = new ArrayList<>();
					_map.put(ingredient, dishList);
				}
				dishList.add(dishName);
			}
		}
		List<ArrayList<String>> result = new ArrayList<>();
		for (String ingredient : _map.keySet()) {
			ArrayList<String> dishList = _map.get(ingredient);
			if(dishList.size() > 1){
				Collections.sort(dishList);
				dishList.add(0, ingredient);
				result.add(dishList);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		InterviewHash i = new InterviewHash();
		System.out.println(i);
	}
}
