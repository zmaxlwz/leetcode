package permutations2;

import java.util.*;

public class Solution {

	public List<List<Integer>> permuteUnique(int[] nums){
		//there might be duplicates in nums
		//return all unique permutations
		//use a HashSet to check duplicate permutations

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if(nums==null || nums.length==0)
			return result;

		List<Integer> numlist = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++){
			numlist.add(nums[i]);
		}

		List<Integer> temp = new ArrayList<Integer>();

		HashSet<List<Integer>> set = new HashSet<List<Integer>>();

		dfs(result, temp, numlist, set);

		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> temp, List<Integer> numlist, HashSet<List<Integer>> set){

		if(numlist.size() == 0){
			if(!set.contains(temp)){
				List<Integer> list = new ArrayList<Integer>(temp);
				result.add(list);
				set.add(list);
			}
			return;
		}
		int num = 0;
		for(int i=0;i<numlist.size();i++){
			num = numlist.remove(i);
			temp.add(num);
			dfs(result, temp, numlist, set);
			temp.remove(temp.size()-1);
			numlist.add(i, num);			
		}
	}

	public List<List<Integer>> permuteUnique2(int[] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return result;
		}
		List<List<Integer>> input = expand(nums, 0);
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for(List<Integer> list: input){
			if(!set.contains(list)){
				result.add(list);
				set.add(list);
			}
		}
		return result;
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

		int[] nums = {1,1,2};
		Solution sol = new Solution();
		List<List<Integer>> result = sol.permuteUnique2(nums);
		System.out.println(result);
	}

}
