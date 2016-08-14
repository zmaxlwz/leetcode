package removeDuplicatesSortedArray;

public class Solution {

	public int removeDuplicates(int[] nums){

		if(nums == null || nums.length == 0)
			return 0;

		if(nums.length == 1)
			return 1;

		//the previous element
		int preElement = nums[0];
		//number of duplicates appeared
		int num_dup = 0;

		for(int i=1;i<nums.length;i++){
			if(nums[i]==preElement){
				num_dup++;
			}
			else{
				preElement = nums[i];
				nums[i-num_dup] = nums[i];
			}
		}

		return nums.length-num_dup;
	}

	public int removeDuplicates2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int count = 1;
		int lastNum = nums[0];
		for(int i=1;i<length;i++ ){
			if(lastNum != nums[i]){
				nums[count] = nums[i];
				count++;
				lastNum = nums[i];
			}
		}
		return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,1,2,2,2,3,4,4,5};
		Solution sol = new Solution();
		int len = sol.removeDuplicates2(nums);
		System.out.println(len);
		for(int i=0; i<len; i++){
			System.out.print(nums[i] + ", ");
		}
	}

}
