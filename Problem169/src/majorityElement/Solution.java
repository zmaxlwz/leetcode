package majorityElement;

public class Solution {

	public int majorityElement(int[] nums){
		//use majority vote algorithm

		if(nums.length == 1){
			return nums[0];
		}

		int length = nums.length;
		int majElem = nums[0];
		int count = 1;
		for(int i=1;i<length;i++){
			if(count == 0){
				majElem = nums[i];
				count = 1;
				continue;
			}

			if(nums[i] == majElem){
				count++;
			}
			else{
				count--;
			}
		}
		return majElem;
	}

	public int majorityElement2(int[] nums){
		int length = nums.length;
		if(length==1){
			return nums[0];
		}
		int majorityElement = 0;
		int count = 0;
		for(int i=0;i<length;i++){
			if(count==0){
				majorityElement = nums[i];
				count++;
				continue;
			}
			if(nums[i] == majorityElement){
				count++;
			}
			else{
				count--;
			}
		}
		return majorityElement;
	}

	public int majorityElement3(int[] nums){
		int length = nums.length;
		int majorityElement = nums[0];
		int count = 1;
		for(int i =1;i<length;i++){
			if(nums[i] == majorityElement){
				count++;
			}
			else{
				count--;
				if(count == 0){
					majorityElement = nums[i];
					count = 1;
				}
			}
		}
		return majorityElement;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,3,4,3,5,3,3};
		Solution sol = new Solution();
		System.out.println(sol.majorityElement3(nums));

	}

}
