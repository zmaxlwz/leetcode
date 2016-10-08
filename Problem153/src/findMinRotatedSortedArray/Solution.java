package findMinRotatedSortedArray;

public class Solution {

	public int findMin(int[] nums){
		//a sorted array is rotated at some point unknown to you
		//find the min value in the array
		//no duplicates exist
		//use binary search, check if nums[middle] < nums[right]

		if(nums == null || nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return nums[0];
		}

		int length = nums.length;
		int left = 0;
		int right = length-1;
		int middle = 0;

		while(left<right){
			middle = (left+right)/2;
			if(nums[middle]<nums[right]){
				right = middle;
			}
			else{
				//nums[middle] > nums[right]
				left = middle+1;
			}
		}

		return nums[left];
	}

	public int findMin2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		if(length == 1){
			return nums[0];
		}

		int left = 0;
		int right = length-1;
		int middle = 0;
		while(left < right){
			middle = (left+right)/2;
			if(nums[middle] > nums[right]){
				left = middle+1;
			}
			else{
				right = middle;
			}

		}
		return nums[left];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {4,5,6,7,0,1,2};
		//int[] nums = {5,6,7,0,1,2,4};
		//int[] nums = {6,7,0,1,2,4,5};
		//int[] nums = {7,0,1,2,4,5,6};
		int[] nums = {0,1,2,4,5,6,7};

		Solution sol = new Solution();
		System.out.println(sol.findMin(nums));

	}

}
