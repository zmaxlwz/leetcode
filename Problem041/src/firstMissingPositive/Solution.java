package firstMissingPositive;

public class Solution {

	public int firstMissingPositive(int[] nums){
		//nums is an unsorted array
		//find the first missing positive integer

		if(nums == null || nums.length==0){
			return 1;
		}

		int length = nums.length;

		for(int i=0;i<length;i++){
			while(nums[i] != i){
				//nums[i] is out of the range [0, n-1]
				if(nums[i]<0 || nums[i]>=length)
					break;
				//duplicate, there is more than one nums[i], one is already in its spot
				if(nums[i] == nums[nums[i]])
					break;
				//swap nums[i] and nums[nums[i]]
				int temp = nums[i];
				nums[i] = nums[temp];
				nums[temp] = temp;
			}
		}

		//check from 1 to n-1
		for(int i = 1; i < length; i++){
			if(nums[i] != i)
				return i;
		}

		//need to check if nums[0] is n
		if(nums[0] == length)
			return length+1;
		else
			return length;
	}

	public int firstMissingPositive2(int[] nums){
		if(nums == null || nums.length == 0){
			return 1;
		}
		int length = nums.length;
		for(int i =0;i<length;i++){
			while(nums[i] != i){
				if(nums[i] < 0 || nums[i]>=length){
					break;
				}
				int num = nums[i];
				if(num == nums[num]){
					break;
				}
				nums[i] = nums[num];
				nums[num] = num;
			}
		}
		for(int i =1;i<length;i++){
			if(nums[i] != i){
				return i;
			}
		}
		if(nums[0] == length){
			return length+1;
		}
		else{
			return length;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {1,2,0};
		//int[] nums = {3,4,-1,1};
		int[] nums = {3,4,-1,1,4};
		Solution sol = new Solution();
		System.out.println(sol.firstMissingPositive2(nums));
	}

}
