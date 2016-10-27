package containsDuplicate;

import java.util.*;

public class Solution {

	public boolean containsDuplicate(int[] nums){
		if(nums==null || nums.length<=1){
			return false;
		}

		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(set.contains(nums[i])){
				return true;
			}
			else{
				set.add(nums[i]);
			}
		}
		return false;
	}

	public boolean containsDuplicate2(int[] nums){
		if(nums==null || nums.length<=1){
			return false;
		}
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<length; i++ ){
			if(set.contains(nums[i])){
				return true;
			}
			else{
				set.add(nums[i]);
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,1,3,9,6,1};
		Solution sol = new Solution();
		System.out.println(sol.containsDuplicate(nums));

	}

}
