package removeDuplicates;

public class Solution {

	public int removeDuplicates(int[] nums){
		//nums is a sorted array
		//remove duplicates from nums, and duplicates are allowed at most twice
		//return the length of the changed array

		if(nums == null || nums.length==0)
			return 0;

		int count = 0;
		int pre = 0;

		for(int i=1;i<nums.length;i++){
			if(nums[i] != nums[pre]){
				nums[i-count] = nums[i];
				pre = i;
			}
			else{
				if(i == pre+1){
					nums[i-count] = nums[i];
				}
				else{
					count++;
				}
			}
		}

		return nums.length-count;
	}

	public int removeDuplicates2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int lastNum = nums[0];
		int index = 0;
		boolean isFirst = true;
		for(int i =1;i<length;i++){
			if(nums[i] != lastNum){
				index++;
				nums[index] = nums[i];
				lastNum = nums[i];
				isFirst = true;
			}
			else if(isFirst){
				index++;
				nums[index] = nums[i];
				isFirst = false;
			}

		}
		return index+1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,1,1,2,2,3};

		Solution sol = new Solution();
		int length = sol.removeDuplicates2(nums);
		System.out.println(length);
		for(int i=0;i<length;i++){
			System.out.print(nums[i] + ", ");
		}
		System.out.println();

	}

}
