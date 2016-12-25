package longestSubstringKDistinctChars;

import java.util.*;

public class Solution {
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		
		if(s == null){
			return 0;
		}
		
		if(s.length() <= k){
			return s.length();
		}
		
		if(k <= 0){
			return 0;
		}
		
		int length = s.length();
		int startIndex = 0;
		int maxLength = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<length;i++){
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, i);
			}
			else if(map.size()<k){
				map.put(c, i);
			}
			else{
				//cannot add this char to the substring
				if(i-startIndex > maxLength){
					maxLength = i-startIndex;
				}
				char chMin = ' ';
				int minIndex = Integer.MAX_VALUE;
				for(Character ch: map.keySet()){
					if(map.get(ch) < minIndex){
						minIndex = map.get(ch);
						chMin = ch;
					}
				}
				map.remove(chMin);
				startIndex = minIndex+1;
				map.put(c, i);
			}
		}
		
		if(length-startIndex > maxLength){
			maxLength = length-startIndex;
		}
		
		return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		String s = "eceba";
		int k = 2;
		
		System.out.println(sol.lengthOfLongestSubstringKDistinct(s, k));

	}

}
