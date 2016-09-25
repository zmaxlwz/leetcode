package wordBreak;

import java.util.*;

public class Solution {

	public boolean wordBreak(String s, Set<String> wordDict){
		//return true if the String s can be broke into words in wordDict set
		//use dfs -- time limit exceeded
		
		if(s == null || s.length() == 0){
			return true;
		}
					
		int maxLength = 0;
		for(String word: wordDict){
			int n = word.length();
			if(n > maxLength){
				maxLength = n;
			}
		}
		
		return dfs(wordDict, s, 0, maxLength);
	}
	
	private boolean dfs(Set<String> wordDict, String s, int start, int maxLength){
		
		if(start>=s.length()){
			return true;
		}
		
		int end = Math.min(start+maxLength-1, s.length()-1);
		
		for(int i=end;i>=start;i--){
			String subStr = s.substring(start, i+1);
			if(wordDict.contains(subStr) && dfs(wordDict, s, i+1, maxLength)){
				return true;
			}
		}
		
		return false;
	}
	
	public boolean wordBreak2(String s, Set<String> wordDict){
		//use dynamic programming
		
		if(s == null || s.length() == 0){
			return true;
		}
					
		int maxLength = 0;
		for(String word: wordDict){
			int n = word.length();
			if(n > maxLength){
				maxLength = n;
			}
		}
		
		int length = s.length();
		boolean[] table = new boolean[length+1];
		table[0] = true;
		for(int i=1;i<=length;i++){
			table[i] = false;
		}
		
		for(int j=1;j<=length;j++){
			int start = Math.max(1, j-maxLength+1);
			for(int i=start;i<=j;i++){
				if(wordDict.contains(s.substring(i-1, j)) && table[i-1]){
					table[j] = true;
				}
			}			
		}
		
		return table[length];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		Solution sol = new Solution();
		System.out.println(sol.wordBreak2(s, wordDict));

	}

}
