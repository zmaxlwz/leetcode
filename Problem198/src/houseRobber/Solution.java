package houseRobber;

public class Solution {

	public int rob(int[] nums){
		//use dynamic programming
		if(nums == null || nums.length == 0){
			return 0;
		}
		if(nums.length==1){
			return nums[0];
		}
		int length = nums.length;
		int[] table = new int[length];
		table[0] = nums[0];
		table[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<length;i++){
			table[i] = Math.max(table[i-1], table[i-2]+nums[i]);
		}
		return table[length-1];
	}

	public int rob2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		if(length == 1){
			return nums[0];
		}
		int[] table = new int[length];
		table[0] = nums[0];
		table[1] = Math.max(nums[0], nums[1]);
		for(int i=2;i<length;i++){
			table[i] = Math.max(table[i-2]+nums[i], table[i-1]);
		}
		return table[length-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,10,1,9,8,4};
		Solution sol = new Solution();
		System.out.println(sol.rob2(nums));

	}

}
