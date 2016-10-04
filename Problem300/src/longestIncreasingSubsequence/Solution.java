package longestIncreasingSubsequence;

public class Solution {
	
	public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int maxLen = 0;
		int[] maxLength = new int[length];
		for(int i=length-1;i>=0;i--){
			//int num = nums[i];
			int len = 1;
			for(int j=i+1;j<length;j++){
				if(nums[j] > nums[i] && maxLength[j]+1>len){
					len = maxLength[j]+1;
				}
			}
			maxLength[i] = len;
			if(maxLength[i]>maxLen){
				maxLen = maxLength[i];
			}
		}
		
		return maxLen;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(sol.lengthOfLIS(nums));

	}

}
