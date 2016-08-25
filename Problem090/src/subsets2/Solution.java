package subsets2;

import java.util.*;

public class Solution {

	public List<List<Integer>> subsetsWithDup(int[] nums){
		//nums is a collection of integers which might include duplicates
		//return all possible subsets of these integers
		//integers in each subset are in ascending order
		//no subsets are the same
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		if(nums == null || nums.length == 0)
			return result;
		
		//sort the collection
		Arrays.sort(nums);
		
		//contains the set of distinct subsets
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		
		List<Integer> temp = new ArrayList<Integer>();
		
		dfs(result, temp, set, nums, 0);
		
		return result;
	}
	
	private void dfs(List<List<Integer>> result, List<Integer> temp, HashSet<List<Integer>> set, int[] nums, int index){
		if(index >= nums.length){
			//all elements in nums have been checked
			if(!set.contains(temp)){
				result.add(new ArrayList<Integer>(temp));
				set.add(new ArrayList<Integer>(temp));
			}
			return;
		}
		
		//this level only check nums[index]
		//don't add nums[index]
		dfs(result, temp, set, nums, index+1);
		//add nums[i]
		temp.add(nums[index]);
		dfs(result, temp, set, nums, index+1);
		temp.remove(temp.size()-1);
			
		return;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,2};
		
		Solution sol = new Solution();
		System.out.println(sol.subsetsWithDup(nums));

	}

}
