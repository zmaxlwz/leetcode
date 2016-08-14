package searchRotateArray;

public class Solution {

	public int search(int[] nums, int target){

		//search target in a rotated array
		//no duplicates exist

		if(nums==null || nums.length==0){
			return -1;
		}

		//use binary search
		int left = 0;
		int right = nums.length-1;
		int middle;

		while(left<=right){
			middle = (left+right)/2;
			if(nums[middle]==target){
				return middle;
			}

			if(nums[left]<=nums[middle]){
				//left side is increasing range
				if(nums[left]<=target && target<nums[middle]){
					right = middle-1;
				}
				else{
					left = middle+1;
				}
			}
			else{
				//right side is increasing range
				if(nums[middle]<target && target<=nums[right]){
					left = middle+1;
				}
				else{
					right = middle-1;
				}

			}
		}


		return -1;
	}

	public int search2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int length = nums.length;
		int left = 0, right = length - 1, middle;
		while(left <= right){
			middle = (left+right)/2;
			if(nums[middle] == target){
				return middle;
			}
			if(nums[middle]>=nums[left]){
				if(target>=nums[left] && target<nums[middle]){
					right = middle-1;
				}
				else{
					left = middle+1;
				}
			}
			else{
				if(target>nums[middle] && target<=nums[right]){
					left = middle+1;
				}
				else{
					right = middle-1;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {4,5,6,7,0,1,2};
		//int[] nums = {3,1};
		int target = 1;
		Solution sol = new Solution();
		System.out.println(sol.search(nums, target));
	}

}
