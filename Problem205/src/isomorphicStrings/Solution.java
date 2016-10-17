package isomorphicStrings;

import java.util.*;

public class Solution {

	public boolean isIsomorphic(String s, String t){
		if(s== null && t == null){
			return true;
		}

		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();

		int length = s.length();
		for(int i=0;i<length;i++){
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if(!map1.containsKey(cs)){
				map1.put(cs, ct);
			}
			else if(map1.get(cs) != ct){
				return false;
			}

			if(!map2.containsKey(ct)){
				map2.put(ct, cs);
			}
			else if(map2.get(ct) != cs){
				return false;
			}
		}
		return true;
	}

	public boolean isIsomorphic2(String s, String t){
		if(s.length() == 0){
			return true;
		}
		int length = s.length();
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		for(int i =0;i<length;i++){
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			if(map1.containsKey(c1)){
				if(map1.get(c1) != c2){
					return false;
				}
			}
			else{
				map1.put(c1, c2);
			}
			if(map2.containsKey(c2)){
				if(map2.get(c2)!=c1){
					return false;
				}
			}
			else{
				map2.put(c2, c1);
			}
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "paper";
		String t = "title";

		Solution sol = new Solution();
		System.out.println(sol.isIsomorphic2(s, t));

	}

}
