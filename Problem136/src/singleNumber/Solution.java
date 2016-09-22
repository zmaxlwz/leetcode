package singleNumber;

import java.util.*;

public class Solution {

	public int singleNumber(int[] nums){
		//each number appear twice except one, find the unique one number
		//method1: use HashSet, need O(n) space, linear time
		
		if(nums==null || nums.length==0){
			return 0;
		}
		
		if(nums.length==1){
			return nums[0];
		}
		
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
			else{
				set.remove(nums[i]);
			}
		}
		
		Iterator<Integer> iter = set.iterator();
		return iter.next();
	}
	
	public int singleNumber2(int[] nums){
		//method2: use XOR, need constant space, linear time
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		if(nums.length == 1){
			return nums[0];
		}
		
		int length = nums.length;
		int result = nums[0];
		for(int i=1;i<length;i++){
			result = result ^ nums[i];
		}
				
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {2,1,3,4,1,2,4};
		Solution sol = new Solution();
		System.out.println(sol.singleNumber2(nums));

	}

}
