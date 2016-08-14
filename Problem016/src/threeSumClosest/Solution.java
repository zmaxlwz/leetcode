package threeSumClosest;

import java.util.Arrays;

public class Solution {

	public int threeSumClosest(int[] nums, int target){

		if(nums == null || nums.length <= 2)
			return 0;

		//sort the array
		Arrays.sort(nums);

		int minDiff = Integer.MAX_VALUE;
		int threeSum=0, resultSum=0;
		int left, right;
		for(int i=0; i<nums.length-2; i++){
			//nums[i] is the first of the three elements
			left = i+1;
			right = nums.length-1;

			while(left<right){
				threeSum = nums[i]+nums[left]+nums[right];
				if(Math.abs(threeSum-target) < minDiff){
					minDiff = Math.abs(threeSum-target);
					resultSum = threeSum;
				}

				if(threeSum == target)
					return threeSum;
				else if(threeSum < target){
					left++;
				}
				else{
					right--;
				}
			}

		}

		return resultSum;
	}

	public int threeSumClosest2(int[] nums, int target){
		if(nums == null || nums.length==0){
			return 0;
		}
		Arrays.sort(nums);
		int length = nums.length;
		int left, right, sum;
		int minDiff = Integer.MAX_VALUE;
		int result = 0;
		for(int i =0; i<length-2;i++){
			left = i+1;
			right = length-1;
			while(left<right){
				sum = nums[i]+nums[left]+nums[right];
				if(Math.abs(sum-target)<minDiff){
					minDiff = Math.abs(sum-target);
					result = sum;
				}
				if(sum<target){
					left++;
				}
				else if(sum>target){
					right--;
				}
				else{
					return target;
				}
			}

		}
		return result;
	}


	public static void main(String[] args){

		//System.out.println("hello");
		//int[] nums = {-1,2,1,-4};
		//int target = 1;
		int[] nums = {0,1,2};
		int target = 3;
		Solution sol = new Solution();
		System.out.println(sol.threeSumClosest2(nums, target));
	}

}
