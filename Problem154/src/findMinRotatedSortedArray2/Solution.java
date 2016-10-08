package findMinRotatedSortedArray2;

public class Solution {

	public int findMin(int[] nums){
		//nums is a sorted array that is rotated at some point unknown to you
		//duplicates may exist
		//find the minimum

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
			else if(nums[middle] == nums[right]){
				right--;
			}
			else{
				left = middle+1;
			}			
		}

		return nums[left];
	}

	public int findMin2(int[] nums){
		if(nums==null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		if(length == 1){
			return nums[0];
		}
		int left = 0;
		int right = length-1;
		int middle = 0;
		while(left<right){
			middle = (left+right)/2;
			if(nums[middle] < nums[right]){
				right = middle;
			}
			else if(nums[middle] == nums[right]){
				right--;
			}
			else{
				left = middle+1;
			}
		}
		return nums[left];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
