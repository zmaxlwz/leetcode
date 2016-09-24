package singleNumber2;

import java.util.*;

public class Solution {

	public int singleNumber(int[] nums){
		//each number appears three times except one
		//find that unique number
		//use HashMap here, need O(n) space, linear time

		if(nums == null || nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return nums[0];
		}

		int length = nums.length;
		//key is the number, value is the times it appears
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0;i<length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}

		for(int key: map.keySet()){
			if(map.get(key) == 1){
				return key;
			}
		}

		return 0;
	}

	public int singleNumber2(int[] nums){
		
		if(nums.length==1){
			return nums[0];
		}
		
		int length = nums.length;
		int[] digits = new int[32];
		for(int i=0;i<length;i++){
			int num = nums[i];
			for(int j=0;j<32;j++){
				if((num & (1<<j)) != 0){
					digits[j]++;
				}
				
			}
		}
		
		int result = 0;
		for(int i=31;i>=0;i--){
			//System.out.print(digits[i] + " ");
			result = (result<<1) + digits[i]%3;
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {3,2,1,1,2,3,5,2,3,1};
		int[] nums = {-2,-2,-1,-2};
		//int[] nums = {-1};
		//System.out.println(1<<31);
		//System.out.println(-1 & (1<<31));
		Solution sol = new Solution();
		System.out.println(sol.singleNumber2(nums));

	}

}
