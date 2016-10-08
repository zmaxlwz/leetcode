package moveZeroes;

public class Solution {
	
	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length <= 1){
			return;
		}
		int length = nums.length;
		int numZeroes = 0;
		for(int i=0;i<length;i++){
			if(nums[i] == 0){
				numZeroes++;
			}
			else{
				nums[i-numZeroes] = nums[i];
			}
		}
		for(int i=length-1;i>=length-numZeroes;i--){
			nums[i] = 0;
		}
		return;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int[] nums = {0,1,0,3,12};
		sol.moveZeroes(nums);
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + ", ");
		}
	}

}
