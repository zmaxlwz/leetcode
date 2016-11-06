package productOfArrayExceptSelf;

public class Solution {

	public int[] productExceptSelf(int[] nums){
		if(nums == null || nums.length==0){
			return null;
		}

		int length = nums.length;
		int[] leftProduct = new int[length];
		int[] rightProduct = new int[length];

		leftProduct[0] = 1;
		for(int i=1;i<length;i++){
			leftProduct[i] = leftProduct[i-1]*nums[i-1];
		}

		rightProduct[length-1] = 1;
		for(int i=length-2;i>=0;i--){
			rightProduct[i] = rightProduct[i+1]*nums[i+1];
		}

		int[] product = new int[length];
		for(int i=0;i<length;i++){
			product[i] = leftProduct[i]*rightProduct[i];
		}
		return product;

	}

	public int[] productExceptSelf2(int[] nums){
		if(nums == null || nums.length == 0){
			return nums;
		}
		int length = nums.length;
		int[] result = new int[length];
		result[length-1] = 1;
		for(int i = length-2; i>=0 ;i-- ){
			result[i] = result[i+1]*nums[i+1];
		}
		int leftProduct = 1;
		for(int i = 0;i<length;i++ ){
			result[i] = leftProduct * result[i];
			leftProduct *= nums[i];
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
