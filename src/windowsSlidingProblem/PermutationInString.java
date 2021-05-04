package windowsSlidingProblem;

import java.util.ArrayList;
import java.util.List;

public class PermutationInString {

	static List<Character> list = new ArrayList();

	public static void main(String[] args) {
		String data = "aaacb";
		String pattern = "abc";
		resetMap(pattern.toCharArray());
		System.out.println(containsPermutation(data.toCharArray(), pattern.toCharArray()));
	}

	public static List<Character> resetMap(char[] pattern) {
		list.clear();
		for (int i = 0; i < pattern.length; i++)
			list.add(pattern[i]);
		return list;
	}

	private static boolean containsPermutation(char[] array, char[] pattern) {
		if (pattern.length > array.length)
			return false;
		int start=0;
		for (int end = 0; end < array.length; end++) {
			if (list.contains(array[end])) {
				list.remove(list.indexOf(array[end]));
			} else {
				resetMap(pattern);
				start++;
				end = start-1;
			}
			if (list.size() == 0)
				return true;
		}
		return false;
	}

}
