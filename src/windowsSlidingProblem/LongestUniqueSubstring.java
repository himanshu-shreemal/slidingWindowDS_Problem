package windowsSlidingProblem;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

	public static void main(String[] args) {
		String data = "aabccbbabcdeeefghijk";
		System.out.println(maxUniqSubS(data.toCharArray()));
	}

	private static int maxUniqSubS(char[] arr) {
		int result = 0;
		Set<Character> set = new HashSet();
		int start = 0, end;
		for (end = 0; end < arr.length; end++) {
			while (set.contains(arr[end])) {
				set.remove(arr[start]);
				start++;
			}
			set.add(arr[end]);
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

}
