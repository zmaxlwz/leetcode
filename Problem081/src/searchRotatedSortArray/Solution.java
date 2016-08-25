package searchRotatedSortArray;

public class Solution {

	public boolean search(int[] nums, int target){
		//search in rotated sorted array nums for target
		//duplicates are allowed in target

		if(nums == null || nums.length==0){
			return false;
		}

		//use binary search
		int left = 0;
		int right = nums.length-1;
		int middle;
		while(left<=right){
			middle = (left+right)/2;
			if(target == nums[middle])
				return true;

			if(nums[left]<nums[middle]){
				//the left side is increasing
				if(target>=nums[left] && target<nums[middle]){
					right = middle-1;
				}
				else{
					left = middle+1;
				}
			}
			else if(nums[left]>nums[middle]){
				//the right side is increasing
				if(target>nums[middle] && target<=nums[right]){
					left = middle+1;
				}
				else{
					right = middle-1;
				}
			}
			else{
				//nums[left] == nums[middle]
				//not sure which side is increasing
				left++;

			}

		}

		return false;
	}

	public boolean search2(int[] nums, int target){
		if(nums == null || nums.length == 0){
			return false;
		}
		int length = nums.length;
		int left = 0, right = length-1, mid;
		while(left<=right){
			mid = (left+right)/2;
			if(target == nums[mid]){
				return true;
			}
			if(nums[left]<nums[mid]){
				if(target>=nums[left] && target<nums[mid]){
					right = mid-1;
				}
				else{
					left = mid+1;
				}
			}
			else if(nums[left]>nums[mid]){
				if(target>nums[mid] && target<=nums[right]){
					left = mid+1;
				}
				else{
					right = mid-1;
				}
			}
			else{
				left++;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int[] nums = {5,6,7,1,2,3,4};
		//int target = 8;
		int[] nums = {1,3,1,1,1};
		int target = 2;

		Solution sol = new Solution();
		System.out.println(sol.search2(nums, target));

	}

}
