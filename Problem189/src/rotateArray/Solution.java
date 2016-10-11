package rotateArray;

public class Solution {

	public void rotate1(int[] nums, int k){
		//use a new array
		if(nums == null || nums.length<=1){
			return;
		}

		int length = nums.length;
		k = k%length;

		int[] rotateArray = new int[length];
		int i = 0;
		for(int j=length-k;j<length;j++){
			rotateArray[i] = nums[j];
			i++;
		}
		for(int j=0;j<length-k;j++){
			rotateArray[i] = nums[j];
			i++;
		}
		for(int j=0;j<length;j++){
			nums[j] = rotateArray[j];
		}
		return;
	}

	public void rotate2(int[] nums, int k){
		//use bubble move
		if(nums == null || nums.length<=1){
			return;
		}
		int length = nums.length;
		k = k%length;
		for(int i=0;i<k;i++){
			int elem = nums[length-1];
			for(int j=length-2;j>=0;j--){
				nums[j+1] = nums[j];
			}
			nums[0] = elem;
		}
		return;
	}

	public void rotate3(int[] nums, int k){
		//rotate based on reverse
		if(nums == null || nums.length<=1){
			return;
		}
		int length = nums.length;
		k = k%length;

		reverse(nums, 0, length-k-1);
		reverse(nums, length-k, length-1);
		reverse(nums, 0, length-1);
	}

	private void reverse(int[] array, int start, int end){

		int left = start;
		int right = end;
		while(left<right){
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		return;
	}

	public void rotate4(int[] nums, int k){
		if(nums == null || nums.length == 0){
			return;
		}
		int length = nums.length;
		k = k%length;
		if(k == 0){
			return;
		}
		reverseElem(nums, 0, length-k-1);
		reverseElem(nums, length-k, length-1);
		reverseElem(nums, 0, length-1);
		return;
	}
	
	private void reverseElem(int[] nums, int start, int end){
		int left = start;
		int right = end;
		while(left<right){
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;

		Solution sol = new Solution();
		sol.rotate4(nums, k);

		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i] + ",");
		}

	}

}
