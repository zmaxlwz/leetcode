package maxProductSubarray;

public class Solution {

	public int maxProduct(int[] nums){
		//get the max product of contiguous subarrays
		//use 2d dynamic programming to compute product of nums[i...j]
		//time: O(n^2) -- Time Limit Exceeded

		if(nums == null || nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return nums[0];
		}

		int length = nums.length;
		int maxProduct = Integer.MIN_VALUE;

		//2d array
		int[][] table = new int[length][length];
		for(int i=0;i<length;i++){
			table[i][i] = nums[i];
			for(int j=i+1;j<length;j++){
				table[i][j] = table[i][j-1]*nums[j];
			}
		}

		for(int i=0;i<length;i++){
			for(int j=i;j<length;j++){
				if(table[i][j] > maxProduct){
					maxProduct = table[i][j];
				}
			}
		}

		return maxProduct;
	}

	public int maxProduct2(int[] nums){
		//use 1d dynamic programming
		//keep both min and max ending at each element

		if(nums == null || nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return nums[0];
		}

		int length = nums.length;


		//use min and max two 1d tables for dynamic programming
		int[] min = new int[length];
		int[] max = new int[length];
		min[0] = nums[0];
		max[0] = nums[0];
		int maxProduct = nums[0];

		for(int i=1;i<length;i++){
			int minValue = Math.min(min[i-1]*nums[i], max[i-1]*nums[i]);
			int maxValue = Math.max(min[i-1]*nums[i], max[i-1]*nums[i]);
			min[i] = Math.min(minValue, nums[i]);
			max[i] = Math.max(maxValue, nums[i]);
			maxProduct = Math.max(maxProduct, max[i]);
		}

		return maxProduct;
	}

	public int maxProduct3(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int[] max = new int[length];
		int[] min = new int[length];
		max[0] = nums[0];
		min[0] = nums[0];
		int maxProduct = max[0];
		for(int i=1;i<length;i++){
			max[i] = maxOfThree(nums[i], max[i-1]*nums[i], min[i-1]*nums[i]);
			min[i] = minOfThree(nums[i], max[i-1]*nums[i], min[i-1]*nums[i]);
			if(max[i]>maxProduct){
				maxProduct = max[i];
			}
		}
		return maxProduct;
	}

	private int maxOfThree(int x, int y, int z){
		return Math.max(x, Math.max(y,z));
	}
	private int minOfThree(int x, int y, int z){
		return Math.min(x, Math.min(y,z));
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,-2,4};
		//int[] nums = {3,-2,5,-3,-2};

		Solution sol = new Solution();
		System.out.println(sol.maxProduct2(nums));

	}

}
