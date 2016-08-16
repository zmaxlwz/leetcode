package permutations;

import java.util.*;

public class Solution {

	public List<List<Integer>> permute(int[] nums){
		//return all the permutations of the numbers in nums

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(nums == null || nums.length==0)
			return result;

		//put elements in nums into an ArrayList
		List<Integer> numlist = new ArrayList<Integer>();
		for(int i =0;i<nums.length;i++)
			numlist.add(nums[i]);

		List<Integer> temp = new ArrayList<Integer>();

		dfs(result, temp, numlist);


		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, List<Integer> numlist){
		if(numlist.isEmpty()){
			List<Integer> list = new ArrayList<Integer>(temp);
			result.add(list);
			return;
		}
		int num = 0;
		for(int i=0;i<numlist.size();i++){
			num = numlist.remove(i);
			temp.add(num);
			dfs(result, temp, numlist);
			temp.remove(temp.size()-1);
			numlist.add(i, num);
		}
	}

	public List<List<Integer>> permute2(int[] nums){
		//return all the permutations of numbers in nums
		//use insertion method
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length==0){
			return result;
		}

		List<Integer> temp = new ArrayList<Integer>();
		dfs2(result, temp, nums, 0);
		return result;
	}

	private void dfs2(List<List<Integer>> result, List<Integer> temp, int[] nums, int start){
		//use insertion method, find the insertion point
		if(start>=nums.length){
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		int size = temp.size();
		for(int i=0;i<=size;i++){
			temp.add(i, nums[start]);
			dfs2(result, temp, nums, start+1);
			temp.remove(i);
		}
		return;
	}

	public List<List<Integer>> permute3(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return result;
		}
		return expand(nums, 0);
	}
	public List<List<Integer>> expand(int[] nums, int startIndex){
		int length = nums.length;	
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(startIndex>length-1){
			return result;
		}
		else if(startIndex == length-1){
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[startIndex]);
			result.add(list);
			return result;
		}
		else{
			List<List<Integer>> input = expand(nums, startIndex+1);
			for(List<Integer> list: input){
				for(int i =0;i<=list.size();i++){
					List<Integer> newList = new ArrayList<Integer>(list);
					newList.add(i, nums[startIndex]);
					result.add(newList);
				}
			}
			return result;
		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.remove(1);
		nums.add(1, 5);
		System.out.println(nums);
		 */

		int[] nums = {1,2,3};
		Solution sol = new Solution();
		System.out.println(sol.permute3(nums));


	}

}
