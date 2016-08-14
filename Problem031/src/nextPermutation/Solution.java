package nextPermutation;

import java.util.Arrays;

public class Solution {

	public void nextPermutation(int[] nums){

		if(nums==null || nums.length <= 1)
			return;

		int length = nums.length;

		//1. find largest k, such that nums[k]<nums[k+1]
		int k = 0;
		boolean find = false;
		for(int i=length-2;i>=0;i--){
			if(nums[i] < nums[i+1]){
				k = i;
				find = true;
				break;
			}
		}

		if(!find){
			//no such k exists, return the first permutation, which is ascending order
			Arrays.sort(nums);
			return;
		}

		//2. find largest l>k, such that nums[l]>nums[k]
		//at least nums[k+1] is satisfied 
		int l = 0;
		for(int i=length-1;i>k;i--){
			if(nums[i]>nums[k]){
				l = i;
				break;
			}
		}

		//3. swap nums[k] and nums[l]
		int temp = nums[k];
		nums[k] = nums[l];
		nums[l] = temp;

		//4. reverse the elements from nums[k+1] to the end
		int start = k+1;
		int end = length-1;
		while(start<end){
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}

	}

	public void nextPermutation2(int[] nums){
		if(nums == null || nums.length <= 1){
			return;
		}
		int length = nums.length;
		Integer k=null;
		for(int i =length-2;i>=0;i--){
			if(nums[i]<nums[i+1]){
				k = i;
				break;
			}
		}
		if(k == null){
			//Arrays.sort(nums);
			reverse(nums, 0, length-1);
			return;
		}
		int l = length-1;
		for(int i =length-1;i>k;i--){
			if(nums[i]>nums[k]){
				l = i;
				break;
			}
		}
		int temp = nums[k];
		nums[k] = nums[l];
		nums[l] = temp;
		reverse(nums, k+1, length-1);
		return;
	}
	
	public void reverse(int[] nums, int start, int end){
		if(start>=end){
			return;
		}
		while(start<end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
		return;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,4,3};
		Solution sol = new Solution();
		sol.nextPermutation2(nums);

		for(int i=0;i<nums.length;i++)
			System.out.print(nums[i] + ", ");

	}

}
