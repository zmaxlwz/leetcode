package subsets2_again;

import java.util.*;

public class Solution {

	public List<List<Integer>> subsetsWithDup(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return result;
		}
		Arrays.sort(nums);
		List<Integer> temp = new ArrayList<Integer>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		dfs(result, set, temp, nums, 0);
		return result;
	}
	public void dfs(List<List<Integer>> result, HashSet<List<Integer>> set, List<Integer> temp, int[] nums, int index){
		if(index>=nums.length){
			if(!set.contains(temp)){
				result.add(new ArrayList<Integer>(temp));
				set.add(new ArrayList<Integer>(temp));
			}
			return;
		}
		dfs(result, set, temp, nums, index+1);
		temp.add(nums[index]);
		dfs(result, set, temp, nums, index+1);
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
