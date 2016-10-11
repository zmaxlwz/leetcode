package repeatedDNASequences;

import java.util.*;

public class Solution {

	public List<String> findRepeatedDnaSequences(String s){
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		List<String> result = new ArrayList<String>();
		if(s == null || s.length() < 10){
			return result;
		}

		int length = s.length();
		for(int i=0;i<=length-10;i++){
			String substr = s.substring(i, i+10);
			if(!map.containsKey(substr)){
				map.put(substr, 1);
			}
			else{
				if(map.get(substr) == 1){
					result.add(substr);
				}
				map.put(substr, map.get(substr)+1);
			}
		}

		return result;
	}

	public List<String> findRepeatedDnaSequences2(String s){
		List<String> result = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		HashSet<String> addSet = new HashSet<String>();
		if(s == null || s.length()<=10){
			return result;
		}
		int length = s.length();
		for(int i=0;i<=length-10;i++){
			String s1 = s.substring(i, i+10);
			if(!set.contains(s1)){
				set.add(s1);
			}
			else if(!addSet.contains(s1)){
				result.add(s1);
				addSet.add(s1);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		Solution sol = new Solution();
		System.out.println(sol.findRepeatedDnaSequences2(s));

	}

}
