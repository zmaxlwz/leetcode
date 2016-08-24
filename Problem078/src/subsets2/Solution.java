package subsets2;

import java.util.*;

public class Solution {

	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			result.add(new ArrayList<Integer>());
			return result;
		}
		List<Integer> temp = new ArrayList<Integer>();
		Arrays.sort(nums);
		dfs(result, temp, nums, 0);
		return result;
	}
	public void dfs(List<List<Integer>> result, List<Integer> temp, int[] nums, int index){
		if(index>=nums.length){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		dfs(result, temp, nums, index+1);
		temp.add(nums[index]);
		dfs(result, temp, nums, index+1);
		temp.remove(temp.size()-1);
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,3};
		Solution sol = new Solution();
		System.out.println(sol.subsets(nums));


	}

}
