package groupAnagrams;

import java.util.*;

public class Solution {

	public List<List<String>> groupAnagrams(String[] strs){
		//pub anagrams in a group in alphabetical order

		List<List<String>> result = new ArrayList<List<String>>();

		if(strs == null || strs.length==0)
			return result;

		//key is the sorted string, value is the anagram group as a list 
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();

		String str, sortedStr;
		for(int i=0;i<strs.length;i++){
			str = strs[i];
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			sortedStr = new String(chars);
			if(!map.containsKey(sortedStr)){
				map.put(sortedStr, new ArrayList<String>());
			}
			map.get(sortedStr).add(str);
		}

		for(String key: map.keySet()){
			Collections.sort(map.get(key));
			result.add(map.get(key));
		}

		return result;
	}

	public List<List<String>> groupAnagrams2(String[] strs){
		List<List<String>> result = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0){
			return result;
		}
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for(String s: strs){
			char[] chars = s.toCharArray();
			Arrays.sort(chars);
			String s_sorted = new String(chars);
			if(!map.containsKey(s_sorted)){
				map.put(s_sorted, new ArrayList<String>());

			}
			map.get(s_sorted).add(s);
		}
		for(String s: map.keySet()){
			List<String> list = map.get(s);
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Solution sol = new Solution();
		List<List<String>> result = sol.groupAnagrams2(strs);
		System.out.println(result);

	}

}
