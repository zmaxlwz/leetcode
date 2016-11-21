package countOfSmallerElementsAfterItself;

import java.util.*;

public class Solution {
	
	public List<Integer> countSmaller(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return result;
		}
		for(int i=0;i<nums.length;i++){
			int num = nums[i];
			int count = 0;
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]<num){
					count++;
				}
			}
			result.add(count);
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums = {5,2,6,1};
		List<Integer> result = sol.countSmaller(nums);
		System.out.println(result);

	}

}
