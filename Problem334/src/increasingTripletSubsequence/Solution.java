package increasingTripletSubsequence;

public class Solution {
	
	public boolean increasingTriplet(int[] nums) {
		if(nums == null || nums.length <= 2){
			return false;
		}
		int firstMin = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		for(int n: nums){
			if(n<=firstMin){
				firstMin = n;
			}
			else if(n<=secondMin){
				secondMin = n;
			}
			else{
				return true;
			}
		}
		
		return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int[] nums = {1, 2, 3, 4, 5};
		int[] nums = {5, 4, 3, 2, 1};
		System.out.println(sol.increasingTriplet(nums));

	}

}
