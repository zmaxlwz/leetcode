package removeElement;

public class Solution {

	public int removeElement(int[] nums, int val){
		//remove elements equal to val from the array
		//return the new length

		if(nums == null || nums.length == 0)
			return 0;

		int i=0;
		int j=0;

		while(j<nums.length){
			if(nums[j]!=val){
				nums[i] = nums[j];
				i++;
			}
			j++;
		}
		return i;
	}

	public int removeElement2(int[] nums, int val){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int count = 0;
		for(int i =0; i<length;i++ ){
			if(nums[i] != val){
				nums[count] = nums[i];
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,4,4,5,1,3};
		int val = 4;
		Solution sol = new Solution();
		int len = sol.removeElement2(nums, val);
		System.out.println(len);
		for(int i=0;i<len;i++)
			System.out.print(nums[i]+", ");

	}

}
