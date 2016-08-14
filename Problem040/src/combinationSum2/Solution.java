package combinationSum2;

import java.util.*;

public class Solution {

	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		//there may be duplicates in candidates
		//each element in candidates can be used only once
		//find combinations that sum up to target

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(candidates == null || candidates.length == 0)
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
			if(i>startIndex && candidates[i]==candidates[i-1]){
				continue;
			}
			if(candidates[i]<=target){
				temp.add(candidates[i]);
				dfs(result, temp, candidates, i+1, target-candidates[i]);
				temp.remove(temp.size()-1);
			}
			else{
				break;
			}
		}

		return;
	}

	public List<List<Integer>> combinationSum3(int[] candidates, int target){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.sort(candidates);
		dfs2(result, set, temp, candidates, 0, target);
		return result;
	}
	public void dfs2(List<List<Integer>> result, HashSet<List<Integer>> set, List<Integer> temp, int[] candidates, int index, int target){
		if(target == 0){
			if(!set.contains(temp)){
				set.add(new ArrayList<Integer>(temp));
				result.add(new ArrayList<Integer>(temp));
			}			
			return;
		}	
		if(index>=candidates.length){
			return;
		}
		if(candidates[index]>target){
			return;
		}
		dfs2(result, set, temp, candidates, index+1, target);
		temp.add(candidates[index]);
		dfs2(result, set, temp, candidates, index+1, target-candidates[index]);
		temp.remove(temp.size()-1);
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {10,1,2,7,6,1,5};
		int target = 8;

		Solution sol = new Solution();
		List<List<Integer>> result = sol.combinationSum3(nums, target);
		System.out.println(result);
	}

}
