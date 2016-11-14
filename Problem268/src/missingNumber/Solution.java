package missingNumber;

public class Solution {
	
	public int missingNumber(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		for(int i=0;i<length;i++){
			while(nums[i] != i){
				if(nums[i]>=length){
					break;
				}
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}
		
		for(int i=0;i<length;i++){
			if(nums[i] != i){
				return i;
			}
		}
		
		return length;
    }
	
	public int missingNumber2(int[] nums){
		
		if(nums == null || nums.length == 0){
			return 0;
		}
		int n = nums.length;
		int result = 0;
		for(int i=1;i<=n;i++){
			result = result ^ i;
		}
		for(int i=0;i<n;i++){
			result = result ^ nums[i];
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
