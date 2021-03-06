package combinations2;

import java.util.*;

public class Solution {

	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(k<=0 || k>n){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		dfs(result, temp, 1, n, k);
		return result;
	}
	
	public void dfs(List<List<Integer>> result, List<Integer> temp, int start, int n, int k){
		if(temp.size()>=k){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(start>n){
			return;
		}
		for(int i =start;i<=n;i++){
			temp.add(i);
			dfs(result, temp, i+1, n, k);
			temp.remove(temp.size()-1);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=4;
		int k=2;
		Solution sol = new Solution();
		System.out.println(sol.combine(n, k));

	}

}
