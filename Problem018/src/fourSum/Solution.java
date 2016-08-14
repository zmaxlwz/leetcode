package fourSum;

import java.util.*;

public class Solution {

	public List<List<Integer>> fourSum(int[] nums, int target){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		
		Arrays.sort(nums);
		
		int length = nums.length;
		int left, right, sum;
		for(int i=0;i<length-3;i++){
			for(int j=i+1;j<length-2;j++){
				left = j+1;
				right = length-1;
				while(left<right){
					sum = nums[i] + nums[j] + nums[left] + nums[right];
					if(sum < target){
						left++;
					}
					else if(sum>target){
						right--;
					}
					else{
						//sum == target
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[left]);
						temp.add(nums[right]);
						if(!set.contains(temp)){
							set.add(temp);
							result.add(temp);
						}
						left++;
						right--;
					}
				}
				
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,0,-1,0,-2,2};
		int target = 0;
		Solution sol = new Solution();
		System.out.println(sol.fourSum(nums, target));
	}

}
