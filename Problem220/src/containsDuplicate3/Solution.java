package containsDuplicate3;

import java.util.*;

public class Solution {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
		if(nums == null || nums.length <= 1){
			return false;
		}
		int length = nums.length;
		for(int i=0;i<length-1;i++){
			for(int j=i+1;j<=i+k;j++){
				if(j>=length){
					break;
				}
				int diff = Math.abs(nums[i] - nums[j]);
				if(diff <= t){
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t){
		if(nums == null || nums.length <= 1){
			return false;
		}
		if(k<1 || t<0){
			return false;
		}
		int length = nums.length;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i=0;i<length;i++){
			Integer floor = set.floor(nums[i]);
			if(floor != null){
				//System.out.println(nums[i]);
				//System.out.println(floor);
				long diff = (long)nums[i]-floor;
				//System.out.println(diff);
				if(diff <= t)
					return true;
			}
			Integer ceiling = set.ceiling(nums[i]);
			if(ceiling != null){
				long diff = (long)ceiling - nums[i];
				if(diff <= t)
					return true;
			}
			set.add(nums[i]);
			if(i>=k){
				set.remove(nums[i-k]);
			}
		}
		return false;
	}

	public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t){
		if(nums==null || nums.length<=1){
			return false;
		}
		if(k<=0 || t<0){
		    return false;
		}
		int length = nums.length;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i =0;i<length;i++){
			if(set.contains(nums[i])){
				return true;
			}
			Integer floor = set.floor(nums[i]);
			if(floor != null && (long)nums[i] - (long)floor <= t){
				return true;
			}
			Integer ceiling = set.ceiling(nums[i]);
			if(ceiling != null && (long)ceiling - (long)nums[i] <= t){
				return true;
			}
			if(set.size() < k){
				set.add(nums[i]);
			}
			else{
				set.remove(nums[i-k]);
				set.add(nums[i]);
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-1, 2147483647};
		int k = 1;
		int t = 2147483647;

		Solution sol = new Solution();
		System.out.println(sol.containsNearbyAlmostDuplicate3(nums, k, t));

	}

}
