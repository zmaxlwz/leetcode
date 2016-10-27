package containsDuplicate2;

import java.util.*;

public class Solution {

	public boolean containsNearbyDuplicate(int[] nums, int k){
		if(nums == null || nums.length<=1){
			return false;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int length = nums.length;
		for(int i=0;i<length;i++){
			if(map.containsKey(nums[i])){
				if(i-map.get(nums[i])<=k){
					return true;
				}
				else{
					map.put(nums[i], i);
				}
			}
			else{
				map.put(nums[i], i);
			}
		}
		return false;
	}

	public boolean containsNearbyDuplicate2(int[] nums, int k){
		if(nums==null || nums.length<=1){
			return false;
		}
		int length = nums.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<length;i++ ){
			if(map.containsKey(nums[i])){
				if(i-map.get(nums[i]) <= k){
					return true;
				}
				else{
					map.put(nums[i], i);
				}
				
			}
			else{
				map.put(nums[i], i);
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,1,5,6,5,2};
		int k = 3;
		Solution sol = new Solution();
		System.out.println(sol.containsNearbyDuplicate2(nums, k));

	}

}
