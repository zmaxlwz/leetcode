package combinationSum3;

import java.util.*;

public class Solution {

	public List<List<Integer>> combinationSum3(int k, int n){
		//use k numbers from 1~9 to add up to n
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		dfs(result, temp, 1, k, n);

		return result;

	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, int number, int k, int n){
		if(k==0){
			if(n==0){
				result.add(new ArrayList<Integer>(temp));	
			}
			return;
		}
		if(n<=0){
			return;
		}
		for(int i=number;i<10;i++){
			temp.add(i);
			dfs(result, temp, i+1, k-1, n-i);
			temp.remove(temp.size()-1);
		}
		return;
	}

	public List<List<Integer>> combinationSum3Again(int k, int n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		dfsAgain(result, temp, k, n, 1);
		return result;	
	}

	public void dfsAgain(List<List<Integer>> result, List<Integer> temp, int k, int n, int start){
		if(k==0){
			if(n==0){
				result.add(new ArrayList<Integer>(temp));
			}
			return;		
		}
		if(start>n){
			return;
		}
		for(int i =start; i<10;i++){
			temp.add(i);
			dfsAgain(result, temp, k-1,n-i, i+1);
			temp.remove(temp.size()-1);
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int k = 3;
		int n = 9;
		Solution sol = new Solution();
		System.out.println(sol.combinationSum3Again(k, n));

	}

}
