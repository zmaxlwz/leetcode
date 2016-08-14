package findSubstring;

import java.util.*;

public class Solution {

	public List<Integer> findSubstring(String s, String[] words){
		
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || s.length() == 0 || words== null || words.length == 0){
			return result;
		}
		
		//word number in words
		int word_num = words.length;
		//the length of each word
		int word_len = words[0].length();
		
		if(word_num*word_len > s.length())
			return result;
		
		//put each word into the hashmap
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<words.length;i++){
			if(map.containsKey(words[i])){
				map.put(words[i], map.get(words[i])+1);
			}
			else{
				map.put(words[i], 1);
			}
		}
		
		/*
		//check the word_num*word_len char from each starting position
		for(int i=0;i <= s.length()-word_num*word_len; i++){
			
			int start = i;
			int count = 0;
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>(map);
			String checkWord;
			while(count<word_num){
				checkWord = s.substring(start+count*word_len, start+(count+1)*word_len);
				if(!currentMap.containsKey(checkWord) || currentMap.get(checkWord)==0){
					break;
				}
				else{
					currentMap.put(checkWord, currentMap.get(checkWord)-1);
					count++;
				}
			}
			if(count==word_num){
				result.add(start);
			}
									
		}
		*/
		
		int start, count;
		for(int i=0;i<word_len;i++){
			//check the first word_len starting point
			start = i;
			count = 0;
			HashMap<String, Integer> currentMap = new HashMap<String, Integer>(map);
			String checkWord;
			while(start <= s.length()-word_len*word_num){
				if(count==word_num){
					result.add(start);
					currentMap.put(s.substring(start, start+word_len), 1);
					start = start+word_len;
					if(start>s.length()-word_len*word_num)
						break;
					count--;					
				}
				checkWord = s.substring(start+count*word_len, start+(count+1)*word_len);
				if(!currentMap.containsKey(checkWord)){
					//doesn't match
					start = start+(count+1)*word_len;
					currentMap = new HashMap<String, Integer>(map);
					count = 0;
				}
				else if(currentMap.get(checkWord)<=0){
					//more checkWord than in words
					//skip the first checkWord
					int index = s.substring(start, start+count*word_len).indexOf(checkWord);
					start = start + index + word_len;
					currentMap = new HashMap<String, Integer>(map);
					count = 0;
				}
				else{
					//match
					count++;
					currentMap.put(checkWord, currentMap.get(checkWord)-1);
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String s = "foobarfoobar";
		//String[] words = {"foo", "bar"};
		
		String s = "barfoofoobarthefoobarman";
		String[] words = {"bar", "foo", "the"};
		Solution sol = new Solution();
		System.out.println(sol.findSubstring(s, words));

	}

}
