import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
*/

public class EX49 {
	public static void main(String[] args) {
		String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
		groupAnagrams(strs);
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> ans = new List<List<String>>();
		List<String> wordList = Arrays.asList(strs);

		for (String s : wordList) {
			System.out.println(s);
		}

		return ans;
	}
public static List<List<String>> groupAnagrams(String[] strs) {
	if (strs == null || strs.length == 0) return new ArrayList<>();
	Map<String, List<String>> map = new HashMap<>();
	for (String s : strs) {
		char[] ca = s.toCharArray();
		Arrays.sort(ca);
		String keyStr = String.valueOf(ca);
		if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
		map.get(keyStr).add(s);
	}
	return new ArrayList<>(map.values());
}
}