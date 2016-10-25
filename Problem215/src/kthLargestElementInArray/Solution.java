package kthLargestElementInArray;

public class Solution {

	public int findKthLargest(int[] nums, int k){

		return find(nums, 0, nums.length-1, k);

	}

	private int find(int[] nums, int start, int end, int k){
		int pivotIndex;
		if(start < end){
			pivotIndex = partition(nums, start, end);
			if(k == end-pivotIndex+1){
				return nums[pivotIndex];
			}
			else if(k < end-pivotIndex+1){
				return find(nums, pivotIndex+1, end, k);
			}
			else{
				return find(nums, start, pivotIndex-1, k-end+pivotIndex-1);
			}
		}
		else{
			return nums[start];
		}
	}

	private int partition(int[] nums, int start, int end){
		int pivot = nums[end];
		int k = start-1;
		for(int i=start;i<end;i++){
			if(nums[i]<=pivot){
				k++;
				int temp = nums[k];
				nums[k] = nums[i];
				nums[i] = temp;
			}
		}
		int t = nums[k+1];
		nums[k+1] = pivot;
		nums[end] = t;
		return k+1;
	}

	public int findKthLargest2(int[] nums, int k){
		int length = nums.length;
		k = length - k;
		int start = 0;
		int end = length-1;
		int index = quickPartition(nums, start, end);
		while(index != k){
			if(index<k){
				start = index+1;
				index = quickPartition(nums, start, end);
			}
			else{
				end = index-1;
				index = quickPartition(nums, start, end);
			}
		}
		return nums[index];
	}

	public int quickPartition(int[] nums, int start, int end){
		int pivot = nums[end];
		int p = start;
		int q = end-1;
		while(p<=q){
			if(nums[p]<=pivot){
				p++;
				continue;
			}
			else{
				swap(nums, p, q);
				q--;
			}
		}
		swap(nums, p, end);
		return p;
	}

	public void swap(int[] nums, int p, int q){
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		Solution sol = new Solution();
		System.out.println(sol.findKthLargest(nums, k));

	}

}
