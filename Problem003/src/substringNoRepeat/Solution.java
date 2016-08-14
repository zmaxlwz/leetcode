package substringNoRepeat;

import java.util.*;

public class Solution {

	public int lengthOfLongestSubstring(String s){

		//assume only consider ASCII char
		boolean[] visited = new boolean[256];
		for(int i=0;i<256;i++){
			visited[i] = false;
		}
		int start = 0;
		int max_length = 0;

		int j = 0;
		int index = 0;

		//the substring is from start to j
		for(j = 0; j<s.length(); j++){
			index = (int)s.charAt(j);

			if(!visited[index]){
				//char at j is not visited before in the substring
				visited[index] = true;				
			}
			else{
				//char at j appears somewhere i in the substring between start and j-1
				//length from start to j-1 
				max_length = max_length>=j-start ? max_length:j-start;
				//reset start to i+1, and set all char before i to false
				while(s.charAt(start) != s.charAt(j)){
					visited[(int)s.charAt(start)] = false;
					start++;
				}
				start++;
			}
		}
		//compute the length from start to the end
		max_length = max_length>=s.length()-start ? max_length:s.length()-start;
		return max_length;
	}

	public int lengthOfLongestSubstring2(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		char[] array = s.toCharArray();
		int length = array.length;
		int maxLength = 0;
		int start = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int end=0;end<length;end++){
			char c = array[end];
			if(!map.containsKey(c)){
				map.put(c, end);

			}
			else{
				int index = map.get(c);
				if(end-start>maxLength){
					maxLength = end-start;
				}
				for(int i =start;i<index;i++){
					map.remove(array[i]);
				}
				map.put(c, end);
				start = index+1;
			}
		}
		if(length-start>maxLength){
			maxLength = length-start;
		}
		return maxLength;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		//String s = "abcabcbb";
		//String s = "ABDEFGABEF";
		//String s = "bbbbb";
		String s = "pwwkew";
		System.out.println(sol.lengthOfLongestSubstring2(s));
	}

}
