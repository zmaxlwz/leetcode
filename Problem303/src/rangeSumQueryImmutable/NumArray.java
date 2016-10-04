package rangeSumQueryImmutable;

public class NumArray {
	
	int[] numArray;
	
	public NumArray(int[] nums){
		if(nums == null){
            return;
        }
        int length = nums.length;
		numArray = new int[length];
		if(length == 0){
		    return;
		}
		numArray[0] = nums[0];
		for(int i=1;i<length;i++){
			numArray[i] = numArray[i-1] + nums[i];
		}
		return;
	}
	
	public int sumRange(int i, int j){
		if(i==0){
			return numArray[j];
		}
		else{
			return numArray[j] - numArray[i-1];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
