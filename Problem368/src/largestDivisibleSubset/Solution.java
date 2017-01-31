package largestDivisibleSubset;

import java.util.*;

public class Solution {
	
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return result;
		}
		Arrays.sort(nums);
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0;i<nums.length;i++){
			int maxCount = 1;
			List<Integer> list = null;
			for(int j=0;j<i;j++){
				if(nums[i]%nums[j] == 0){
					if(map.get(nums[j]).size()+1 > maxCount){
						maxCount = map.get(nums[j]).size()+1;
						list = map.get(nums[j]);
					}
				}
			}
			if(maxCount == 1){
				list = new ArrayList<Integer>();
			}
			else{
				list = new ArrayList<Integer>(list);
			}
			list.add(nums[i]);
			map.put(nums[i], list);
		}
		
		int maxSize = 0;
		for(Integer n: map.keySet()){
			List<Integer> list = map.get(n);
			if(list.size()>maxSize){
				maxSize = list.size();
				result = list;
			}
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int[] nums = {1,2,3};
		int[] nums = {1,2,4,8};
		System.out.println(sol.largestDivisibleSubset(nums));

	}

}
