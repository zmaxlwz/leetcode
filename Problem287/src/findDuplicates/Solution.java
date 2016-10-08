package findDuplicates;

import java.util.*;

public class Solution {
	
	public int findDuplicate(int[] nums) {
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
			else{
				return nums[i];
			}
		}
		
		return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
