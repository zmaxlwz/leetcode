package maxSubarray;

public class Solution {

	public int maxSubArray(int[] nums){
		//find the max sum of continuous subarray in nums
		//use one dimensional dynamic programming

		if(nums == null || nums.length==0)
			return 0;

		int length = nums.length;
		int[] maxEndHere = new int[length];
		int maxSoFar = nums[0];

		maxEndHere[0] = nums[0];
		for(int i=1;i<length;i++){
			if(maxEndHere[i-1]>0){
				maxEndHere[i] = maxEndHere[i-1]+nums[i];
			}
			else{
				maxEndHere[i] = nums[i];
			}
			if(maxEndHere[i]>maxSoFar){
				maxSoFar = maxEndHere[i];
			}
		}

		return maxSoFar;
	}

	public int maxSubArray2(int[] nums){
		//use divide and conquer method
		//running time is O(nlgn)

		if(nums == null || nums.length==0){
			return 0;
		}	

		return maxSumWithin(nums, 0, nums.length-1);
	}

	private int maxSumWithin(int[] nums, int start, int end){
		//return the max sum of subarrays within nums[start…end]
		if(start<0 || end>=nums.length){
			return 0;
		}
		if(start>end){
			return 0;
		}
		else if(start==end){
			return nums[start];
		}

		int middle = (start+end)/2;
		int leftMax = maxSumWithin(nums, start, middle);
		int rightMax = maxSumWithin(nums, middle+1, end);
		int bothSidesMax = maxSumBothSides(nums, start, middle, end);

		return Math.max(Math.max(leftMax, rightMax), bothSidesMax);
	}

	private int maxSumBothSides(int[] nums, int start, int middle, int end){
		int sumLeftMax = Integer.MIN_VALUE;
		int sumLeft = 0;
		for(int i=middle;i>=start;i--){
			sumLeft += nums[i];
			if(sumLeft>sumLeftMax){
				sumLeftMax = sumLeft;
			}
		}

		int sumRightMax = Integer.MIN_VALUE;
		int sumRight = 0;
		for(int i=middle+1;i<=end;i++){
			sumRight += nums[i];
			if(sumRight > sumRightMax){
				sumRightMax = sumRight;
			}
		}
		return sumLeftMax + sumRightMax;

	}

	public int maxSubArray3(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int  length = nums.length;
		int maxSum = Integer.MIN_VALUE;
		int lastMaxSum = 0;
		for(int i =0;i<length;i++){
			if(lastMaxSum<=0){
				lastMaxSum = nums[i];
			}
			else{
				lastMaxSum = lastMaxSum + nums[i];
			}
			if(lastMaxSum > maxSum){
				maxSum = lastMaxSum;
			}
		}
		return maxSum;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		Solution sol = new Solution();
		System.out.println(sol.maxSubArray3(nums));
	}

}
