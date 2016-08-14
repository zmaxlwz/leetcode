package searchRange;

public class Solution {

	public int[] searchRange(int[] nums, int target){
		//search the range of target in the sorted array nums
		//do binary search twice, 
		//the first time for the left end, the second time for the right end
		int[] result = new int[2];

		if(nums == null || nums.length == 0){
			result[0] = -1;
			result[1] = -1;
			return result;
		}

		int left = 0;
		int right = nums.length-1;
		int middle;

		int range_left = -1;
		//search for range left
		while(left<=right){
			middle = (left+right)/2;
			if(nums[middle] == target){
				range_left = middle;
				right = middle-1;
			}
			else if(nums[middle]>target){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}

		left=0;
		right=nums.length-1;
		int range_right = -1;
		//search for range right
		while(left<=right){
			middle=(left+right)/2;
			if(nums[middle]==target){
				range_right = middle;
				left = middle+1;
			}
			else if(nums[middle]>target){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}

		result[0] = range_left;
		result[1] = range_right;
		return result;
	}

	public int[] searchRange2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return null;
		}
		int[] result = new int[2];
		result[0] = searchLeft(nums, target);
		result[1] = searchRight(nums, target);
		return result;
	}
	public int searchLeft(int[] nums, int target){
		int length = nums.length;
		int left = 0;
		int right = length-1;
		int middle;
		Integer lastIndex = null;
		while(left<=right){
			middle = (left+right)/2;
			if(nums[middle]==target){
				lastIndex = middle;
				right = middle-1;
			}
			else if(nums[middle]<target){
				left = middle+1;
			}
			else{
				right = middle-1;
			}
		}
		if(lastIndex == null){
			return -1;
		}
		else{
			return lastIndex;
		}
	}
	public int searchRight(int[] nums, int target){
		int length = nums.length;
		int left = 0;
		int right = length-1;
		int middle;
		Integer lastIndex = null;
		while(left<=right){
			middle = (left+right)/2;
			if(nums[middle]==target){
				lastIndex = middle;
				left = middle+1;
			}
			else if(nums[middle]<target){
				left = middle+1;
			}
			else{
				right = middle-1;
			}
		}
		if(lastIndex == null){
			return -1;
		}
		else{
			return lastIndex;
		}
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {5,7,7,8,8,10};
		int target = 7;

		Solution sol = new Solution();
		int[] result = sol.searchRange2(nums, target);
		System.out.println(result[0] + ", "+result[1]);

	}

}
