package maxSizeSubarraySum;

import java.util.*;

public class Solution {
	
	public int maxSubArrayLen(int[] nums, int k) {
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		
		int length = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLength = 0;
		int sum = 0;
		for(int i=0;i<length;i++){
			sum += nums[i];
			if(sum == k){
				maxLength = i+1;
			}
			else if(map.containsKey(sum-k)){
				int len = i-map.get(sum-k);
				if(len > maxLength){
					maxLength = len;
				}
			}
			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		
		return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int[] nums = {1, -1, 5, -2, 3};
		//int k = 3;
		int[] nums = {-2, -1, 2, 1};
		int k = 1;
		
		System.out.println(sol.maxSubArrayLen(nums, k));

	}

}
