package combinationSum;

import java.util.*;

public class Solution {

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		//candidates is a set of integers, no duplicates
		//each element can be repeatedly selected

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length==0)
			return result;

		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<Integer>();

		dfs(result, temp, candidates, 0, target);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, int[] candidates, int startIndex, int target){
		if(target == 0){
			List<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);			
			return;
		}
		for(int i=startIndex;i<candidates.length;i++){
			if(candidates[i]<=target){
				temp.add(candidates[i]);
				dfs(result, temp, candidates, i, target-candidates[i]);
				temp.remove(temp.size()-1);
			}
			else{
				break;
			}
		}

	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		dfs2(result, temp, candidates, 0, target);
		return result;
	}
	public void dfs2(List<List<Integer>> result, List<Integer> temp, int[] candidates, int index, int target){
		if(target == 0){
			result.add(new ArrayList<Integer>(temp));
			return;
		}	
		if(index>=candidates.length){
			return;
		}
		if(candidates[index]>target){
			return;
		}
		dfs2(result, temp, candidates, index+1, target);
		temp.add(candidates[index]);
		dfs2(result, temp, candidates, index, target-candidates[index]);
		temp.remove(temp.size()-1);
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,6,7};
		int target = 7;

		Solution sol = new Solution();
		List<List<Integer>> result = sol.combinationSum2(nums, target);
		System.out.println(result);

	}

}
