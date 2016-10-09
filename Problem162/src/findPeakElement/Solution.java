package findPeakElement;

public class Solution {

	public int findPeakElement(int[] nums){
		//run in O(log(n)) time
		//return the index of peak element

		if(nums == null || nums.length == 0){
			return 0;
		}

		if(nums.length == 1){
			return 0;
		}

		int left = 0;
		int right = nums.length-1;
		int middle = 0;
		while(left < right){
			middle = (left+right)/2;
			if(middle-1>=left && middle+1<=right){
				if(nums[middle]>nums[middle-1] && nums[middle]>nums[middle+1]){
					return middle;
				}
				else if(nums[middle-1]>nums[middle]){
					right = middle-1;
				}
				else{
					left = middle+1;
				}
			}
			else if(middle-1>=left){
				if(nums[middle]>nums[middle-1]){
					return middle;
				}
				else{
					right = middle-1;
				}

			}
			else if(middle+1<=right){
				if(nums[middle]>nums[middle+1]){
					return middle;
				}
				else{
					left = middle+1;
				}

			}
			else{
				return middle;
			}
		}

		return left;
	}

	public int findPeakElement2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		if(length == 1){
			return 0;
		}
		int left = 0;
		int right = length-1;
		int middle = 0;
		int leftNeighbor, rightNeighbor;
		while(left < right){
			middle = (left+right)/2;
			if(middle-1<left){
				leftNeighbor = Integer.MIN_VALUE;	
			}
			else{
				leftNeighbor = nums[middle-1];
			}
			if(middle+1>right){
				rightNeighbor = Integer.MIN_VALUE;
			}
			else{
				rightNeighbor = nums[middle+1];
			}
			if(nums[middle]>leftNeighbor && nums[middle] > rightNeighbor){
				return middle;
			}
			else if(nums[middle]<leftNeighbor){
				right = middle-1;
			}
			else{
				left = middle+1;
			}
		}
		return left;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4,5,2};
		Solution sol = new Solution();
		System.out.println(sol.findPeakElement(nums));

	}

}
