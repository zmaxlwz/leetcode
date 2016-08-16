package jumpGame;

public class Solution {

	public boolean canJump(int[] nums){
		//each element in nums represents the max steps can jump from this position
		//return true if can reach the last index, otherwise return false

		if(nums == null || nums.length<=1){
			return true;
		}

		int length = nums.length;

		int start=0;
		int end=0;
		int max = 0;

		while(start<=end){

			for(int i=start;i<=end;i++){
				if(i+nums[i]>max){
					max = i+nums[i];
				}				
			}
			if(max >= length-1)
				return true;

			start = end+1;
			end = max;
		}

		return false;
	}

	public boolean canJump2(int[] nums){
		if(nums == null || nums.length <=1){
			return true;
		}
		int length = nums.length;
		int maxPosition = 0;
		for(int i =0;i<length;i++){
			if(i>maxPosition){
				break;
			}
			if(i+nums[i]>maxPosition){
				maxPosition = i+nums[i];
				if(maxPosition>=length-1){
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,1,4};
		//int[] nums = {3,2,1,0,4};

		Solution sol = new Solution();
		System.out.println(sol.canJump(nums));

	}

}
