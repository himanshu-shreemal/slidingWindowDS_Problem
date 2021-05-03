package windowsSlidingProblem;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitToBucket {

	public static void main(String[] args) {
		char[] arr = { 'A', 'B', 'C', 'B', 'B', 'C' };
		int k = 2;
		System.out.println(maxFruits(k, arr));
	}

	private static int maxFruits(int k, char[] arr) {
		int result = 0;
		Map<Character, Integer> map = new HashMap();
		int start = 0, end, count;
		for (end = 0; end < arr.length; end++) {
			map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
			while (map.size() > k) {
				count = map.get(arr[start]);
				map.put(arr[start], --count);
				if (count == 0) {
					map.remove(arr[start]);
				}
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

}
