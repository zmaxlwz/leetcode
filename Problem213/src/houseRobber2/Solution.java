package houseRobber2;

public class Solution {

	public int rob(int[] nums){
		//houses are in a circle
		if(nums==null || nums.length==0){
			return 0;
		}

		if(nums.length==1){
			return nums[0];
		}

		if(nums.length==2){
			return Math.max(nums[0], nums[1]);
		}

		int length = nums.length;

		//rob from 0 to n-2
		int[] table = new int[length-1];
		table[0] = nums[0];
		table[1] = Math.max(table[0], nums[1]);
		for(int i=2;i<length-1;i++){
			table[i] = Math.max(table[i-1], table[i-2]+nums[i]);
		}

		int maxAmount = table[length-2];

		table[0] = nums[1];
		table[1] = Math.max(table[0], nums[2]);
		for(int i=2;i<length-1;i++){
			table[i] = Math.max(table[i-1], table[i-2]+nums[i+1]);
		} 

		maxAmount = Math.max(maxAmount, table[length-2]);
		return maxAmount;
	}

	public int rob2(int[] nums){
		if(nums==null || nums.length==0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int length = nums.length;
		int sum1 = maxAmount(nums, 0, length-2);
		int sum2 = maxAmount(nums, 1, length-1);
		return Math.max(sum1, sum2);
	}
	public int maxAmount(int[] nums, int start, int end){
		int length = end-start+1;	
		int[] table = new int[length];
		table[0] = nums[start];
		if(length>=2){
			table[1] = Math.max(nums[start], nums[start+1]);
		}	
		for(int i =2;i<length;i++){
			table[i] = Math.max(table[i-1], table[i-2]+nums[start+i]);
		}
		return table[length-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
