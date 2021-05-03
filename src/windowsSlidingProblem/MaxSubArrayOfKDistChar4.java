package windowsSlidingProblem;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayOfKDistChar4 {

	public static void main(String[] args) {
		String data = "aabcccebi";
		int k = 1;
		char[] arr = data.toCharArray();
		System.out.println(maxSeq(k, arr));
	}

	private static int maxSeq(int k, char[] arr) {
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
