package wordBreak2;

import java.util.*;

public class Solution {

	public List<String> wordBreak(String s, Set<String> wordDict){
		//return a list of space separated Strings that formed by breaking s into valid words in wordDict
		//method1: use dfs, might occur time limit exceeded
		//*******time limit exceeded*********

		List<String> result = new ArrayList<String>();

		if(s == null || s.length()==0){
			return result;
		}

		List<String> temp = new ArrayList<String>();

		int maxLength = 0;
		for(String word: wordDict){
			int n = word.length();
			if(n>maxLength){
				maxLength = n;
			}
		}

		dfs(result, temp, wordDict, s, 0, maxLength);

		return result;
	}

	private void dfs(List<String> result, List<String> temp, Set<String> wordDict, String s, int start, int maxLength){
		if(start >= s.length()){
			String sentence = temp.get(0);
			for(int i=1;i<temp.size();i++){
				sentence += " " + temp.get(i);
			}
			result.add(sentence);
			return;
		}

		int length = s.length();
		int end = Math.min(length, start+maxLength);
		for(int i=start;i<end;i++){
			String word = s.substring(start, i+1);
			if(wordDict.contains(word)){
				temp.add(word);
				dfs(result, temp, wordDict, s, i+1, maxLength);
				temp.remove(temp.size()-1);
			}
		}

		return;
	}

	public List<String> wordBreak2(String s, Set<String> wordDict){
		//use dynamic programming
		//use two 1d array, one is boolean, another is the index of the end of previous word

		List<String> result = new ArrayList<String>();

		if(s == null || s.length()==0){
			return result;
		}

		List<String> temp = new ArrayList<String>();

		int maxLength = 0;
		for(String word: wordDict){
			int n = word.length();
			if(n>maxLength){
				maxLength = n;
			}
		}

		//dynamic programming
		int length = s.length();
		boolean[] table = new boolean[length+1];
		for(int i=1;i<=length;i++){
			table[i] = false;
		}

		table[0] = true;

		List<List<Integer>> indices = new ArrayList<List<Integer>>();
		List<Integer> indexSet = new ArrayList<Integer>();
		indexSet.add(-1);
		indices.add(indexSet);

		for(int j=1;j<=length;j++){
			int start = Math.max(1, j-maxLength+1);
			indexSet = new ArrayList<Integer>();
			for(int i=start;i<=j;i++){
				String word = s.substring(i-1, j);
				if(wordDict.contains(word) && table[i-1]){
					table[j] = true;
					indexSet.add(i-1);
				}
			}
			indices.add(indexSet);
		}

		if(table[length]){
			dfsBuild(result, temp, s, indices, length);
		}

		return result;
	}

	private void dfsBuild(List<String> result, List<String> temp, String s, List<List<Integer>> indices, int end){
		if(end<=0){
			String sentence = temp.get(0);
			for(int i=1;i<temp.size();i++){
				sentence += " " + temp.get(i);
			}
			result.add(sentence);
			return;
		}

		List<Integer> indexSet = indices.get(end);
		for(int i=0;i<indexSet.size();i++){
			int index = indexSet.get(i);
			String word = s.substring(index, end);
			temp.add(0, word);
			dfsBuild(result, temp, s, indices, index);
			temp.remove(0);
		}

		return;
	}

	public List<String> wordBreak3(String s, Set<String> wordDict){
		List<String> result = new ArrayList<String>();
		int length = s.length();
		List<String>[] record = new ArrayList[length+1];
		record[0] = new ArrayList<String>();
		for(int i=0;i<length;i++){
			if(record[i] == null){
				continue;
			}
			for(String word: wordDict){
				int wordLen = word.length();
				int end = i+wordLen;
				if(end>length){
					continue;
				}
				if(s.substring(i, end).equals(word)){
					if(record[end] == null){
						record[end] = new ArrayList<String>();
					}
					record[end].add(word);
				}
			}
		}
		if(record[length] == null){
			return result;
		}
		List<String> temp = new ArrayList<String>();
		dfsCall(result, temp, s, record, length);
		return result;
	}

	private void dfsCall(List<String> result, List<String> temp, String s, List<String>[] record, int end){
		if(end<=0){
			String sentence = temp.get(0);
			for(int i=1;i<temp.size();i++){
				sentence += " " + temp.get(i);
			}
			result.add(sentence);
			return;
		}
		for(String word: record[end]){
			temp.add(0, word);
			dfsCall(result, temp, s, record, end-word.length());
			temp.remove(0);
		}
	}

	public List<String> wordBreak4(String s, Set<String> wordDict){
		List<String> result = new ArrayList<String>();
		if(s == null || s.length() == 0){
			return result;
		}
		int minLength = Integer.MAX_VALUE;
		int maxLength = 0;
		for(String str: wordDict){
			int len = str.length();
			if(len<minLength){
				minLength = len;
			}
			if(len>maxLength){
				maxLength = len;
			}
		}
		minLength = Math.max(1,minLength);
		if(maxLength == 0){
			return result;
		}
		List<String> temp = new ArrayList<String>();
		dfs(result, temp, s, 0, wordDict, minLength, maxLength);
		return result;

	}
	public void dfs(List<String> result, List<String> temp, String s, int start, Set<String> wordDict, int minLength, int maxLength){

		if(start>=s.length()){
			StringBuffer sb = new StringBuffer();	
			for(String word: temp){
				sb.append(word);
				sb.append(' ');
			}
			result.add(sb.substring(0, sb.length()-1));
			return;
		}
		System.out.println(start);
		int maxEnd = Math.min(start+maxLength, s.length());
		for(int end=start+minLength-1;end<maxEnd;end++){
			String word = s.substring(start, end+1);
			if(wordDict.contains(word)){
				temp.add(word);
				dfs(result, temp, s, end+1, wordDict, minLength, maxLength);
				temp.remove(temp.size()-1);
			}
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();
		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		*/
		
		//String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String s = "aaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaa";
		
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		
		/*
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		set.add("aaaaaaaaaa");
		*/
		
		Solution sol = new Solution();
		System.out.println(sol.wordBreak4(s, set));

	}

}
