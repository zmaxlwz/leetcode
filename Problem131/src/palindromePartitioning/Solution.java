package palindromePartitioning;

import java.util.*;

public class Solution {

	public List<List<String>> partition(String s){
		//return all possible palindrome partitioning of s
		//use dynamic programming to check if s[i,j] is palindrome -- O(n^2)
		//then use dfs to return all possible palindrome partitioning
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		if(s==null || s.length()==0){
			return result;
		}
				
		int length = s.length();
		
		//2d table for dynamic programming
		boolean[][] table = new boolean[length][length];
		for(int i=1;i<length;i++){
			table[i][i-1] = true;
		}
		for(int i=0;i<length;i++){
			table[i][i] = true;
		}
		for(int j=1;j<length;j++){
			for(int i=j-1;i>=0;i--){
				char c1 = s.charAt(i);
				char c2 = s.charAt(j);
				if(c1 == c2 && table[i+1][j-1]){
					table[i][j] = true;
				} 
				else{
					table[i][j] = false;
				}
			}
		}
		
		List<String> temp = new ArrayList<String>();
		dfs(result, temp, s, 0, table);
		
		return result;
	}
	private void dfs(List<List<String>> result, List<String> temp, String s, int start, boolean[][] table){
		if(start>=s.length()){
			result.add(new ArrayList<String>(temp));
			return;
		}
		for(int end=start;end<s.length();end++){
			if(table[start][end]){
				temp.add(s.substring(start, end+1));
				dfs(result, temp, s, end+1, table);
				temp.remove(temp.size()-1);
			}
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "aab";
		Solution sol = new Solution();
		System.out.println(sol.partition(s));

	}

}
