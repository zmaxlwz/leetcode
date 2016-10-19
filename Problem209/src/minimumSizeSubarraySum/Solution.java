package minimumSizeSubarraySum;

import java.util.*;

public class Solution {

	public int minSubArrayLen(int s, int[] nums){
		//find the minimum length of the subarray with sum>= s
		if(nums==null || nums.length==0){
			return 0;
		}

		int length = nums.length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int current_sum = 0;
		int min_length = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		while(end<length){
			queue.offer(nums[end]);
			current_sum += nums[end];

			while(current_sum>=s){
				if(end-start+1 < min_length){
					min_length = end-start+1;

				}
				start++;
				int elem = queue.poll();
				current_sum -= elem;
			}

			end++;
		}

		if(min_length > length){
			return 0;
		}
		else{
			return min_length;
		}

	}

	public List<List<Integer>> findSubArray(int s, int[] nums){
		//find all subarrays in nums with sum==s
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(nums == null || nums.length==0){
			return result;
		} 

		int length = nums.length;
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int current_sum = 0;
		//int start = 0;
		int end = 0;
		while(end<length){
			queue.offer(nums[end]);
			current_sum += nums[end];

			while(current_sum > s){
				//start++;
				int elem = queue.poll();
				current_sum -= elem;
			}

			if(current_sum == s){
				result.add(new LinkedList<Integer>(queue));
			}

			end++;
		}

		return result;
	}

	public int minSubArrayLen2(int s, int[] nums){
		if(nums==null || nums.length==0){
			return 0;
		}
		int sum = 0;
		int subArrayLen = 0;
		int minSubArrayLen = Integer.MAX_VALUE;
		int length = nums.length;
		int start = 0;
		boolean exists = false;
		for(int end =0;end<length;end++){
			sum += nums[end];
			subArrayLen++;
			while(sum-nums[start]>=s){
				sum -= nums[start];
				subArrayLen--;
				start++;
			}
			if(sum >= s && subArrayLen< minSubArrayLen){
				exists = true;
				minSubArrayLen = subArrayLen;
			}

		}
		if(exists)
			return minSubArrayLen;
		else
			return 0;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,2,4,3};
		int s = 7;

		Solution sol = new Solution();
		System.out.println(sol.minSubArrayLen(s, nums));

		System.out.println(sol.findSubArray(s, nums));

	}

}
