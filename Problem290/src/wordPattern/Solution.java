package wordPattern;

import java.util.*;

public class Solution {
	
	public boolean wordPattern(String pattern, String str) {
		int length = pattern.length();
		String[] words = str.split(" ");
		if(words.length != length){
			//System.out.println("not equal length.");
			return false;
		}
		HashMap<Character, String> map1 = new HashMap<Character, String>();
		HashMap<String, Character> map2 = new HashMap<String, Character>();
		
		for(int i=0;i<length;i++){
			char c = pattern.charAt(i);
			String s = words[i];
			if(!map1.containsKey(c)){
				map1.put(c, s);
			}
			else{
				if(!map1.get(c).equals(s)){
					return false;
				}
			}
			if(!map2.containsKey(s)){
				map2.put(s, c);
			}
			else{
				if(map2.get(s) != c){
					return false;
				}
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String pattern = "abba";
		String pattern = "aaaa";
		String str = "dog cat cat dog";
		//String str = "dog cat cat fish";
		//String str = "dog dog dog dog";
		System.out.println(sol.wordPattern(pattern, str));

	}

}
