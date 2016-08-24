package subsets;

import java.util.*;

public class Solution {

	public List<List<Integer>> subsets(int[] nums){
		//elements in nums are distinct
		//output all subsets of elements in nums

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(nums == null || nums.length==0)
			return result;

		//first sort the numbers in nums
		Arrays.sort(nums);

		List<Integer> temp = new ArrayList<Integer>();

		dfs(result, temp, 0, nums);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, int start, int[] nums){
		if(start>= nums.length){		
			result.add(new ArrayList<Integer>(temp));
			return;
		}

		//each level only check one number in nums, whether it is in or not
		//without nums[start]
		dfs(result, temp, start+1, nums);
		//with nums[start]
		temp.add(nums[start]);
		dfs(result, temp, start+1, nums);
		temp.remove(temp.size()-1);

		return;
	}

	public List<List<Integer>> subsets2(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(nums == null || nums.length == 0){
			return result;
		}

		Arrays.sort(nums);

		List<Integer> temp = new ArrayList<Integer>();
		dfs2(result, temp, 0, nums);

		return result;
	}

	public void dfs2(List<List<Integer>> result, List<Integer> temp, int start, int[] nums){
		result.add(new ArrayList<Integer>(temp));

		if(start>=nums.length){
			return;
		}

		for(int i=start;i<nums.length;i++){
			temp.add(nums[i]);
			dfs2(result, temp, i+1, nums);
			temp.remove(temp.size()-1);
		}

		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3};
		Solution sol = new Solution();
		System.out.println(sol.subsets2(nums));

	}

}
