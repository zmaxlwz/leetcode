package searchInsertPosition;

public class Solution {

	public int searchInsert(int[] nums, int target){
		//search target, if not found, return the insert position
		//use binary search

		if(nums==null || nums.length==0)
			return 0;

		int left=0;
		int right = nums.length-1;
		int middle=0;

		while(left<=right){
			middle = (left+right)/2;

			if(nums[middle]==target){
				return middle;
			}
			else if(nums[middle]>target){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}

		if(target<=nums[middle]){
			return middle;
		}
		else{
			return middle+1;
		}

	}

	public int searchInsert2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		int left = 0, right = length-1, middle, lastIndex=0;
		while(left<=right){
			middle = (left+right)/2;
			lastIndex = middle;
			if(nums[middle]==target){
				return middle;
			}
			else if(nums[middle]<target){
				left = middle+1;
			}
			else{
				right = middle-1;
			}
		}
		if(nums[lastIndex]<target){
			return lastIndex+1;
		}
		else{
			return lastIndex;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,3,5,6};
		int target = 0;

		Solution sol = new Solution();
		System.out.println(sol.searchInsert2(nums, target));
	}

}
