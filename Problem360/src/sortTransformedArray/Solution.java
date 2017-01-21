package sortTransformedArray;

public class Solution {
	
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        
		if(nums == null || nums.length <= 1){
			return nums;
		}
		
		int length = nums.length;
		int[] result = new int[length];
		
		if(a == 0){
			//linear function
			if(b>=0){
				for(int i=0;i<length;i++){
					result[i] = b*nums[i]+c;
				}
			}
			else{
				for(int i=length-1;i>=0;i--){
					result[length-i-1] = b*nums[i]+c;
				}
			}
		}
		else if(a>0){
			//quadratic function with a>0
			//first find the pivot value, the x closest to pivot value will have the smallest function value
			double pivotValue = -b*1.0/(2.0*a);
			int index1 = -1;
			int index2 = 0;
			for(int i=0;i<length;i++){
				if(nums[i]<pivotValue){
					index1++;
					index2++;
				}
			}
			int index = 0;
			while(index1>=0 || index2<length){
				int val1 = 0;
				int val2 = 0;
				if(index1>=0 && index2<length){
					val1 = nums[index1];
					val2 = nums[index2];
					if(Math.abs(val1-pivotValue) < Math.abs(val2-pivotValue)){
						result[index] = a*val1*val1 + b*val1 + c;
						index++;
						index1--;
					}
					else{
						result[index] = a*val2*val2 + b*val2 + c;
						index++;
						index2++;
					}
				}
				else if(index1>=0){
					//index2>=length
					val1 = nums[index1];
					result[index] = a*val1*val1 + b*val1 + c;
					index++;
					index1--;
					
				}
				else if(index2<length){
					//index1<0
					val2 = nums[index2];
					result[index] = a*val2*val2 + b*val2 + c;
					index++;
					index2++;
				}
			}
			
		}
		else{
			//a < 0
			//quadratic function with a<0
			//first find the pivot value, the x closest to pivot value will have the largest function value
			double pivotValue = -b*1.0/(2.0*a);
			int index1 = -1;
			int index2 = 0;
			for(int i=0;i<length;i++){
				if(nums[i]<pivotValue){
					index1++;
					index2++;
				}
			}
			int index = length-1;
			while(index1>=0 || index2<length){
				int val1 = 0;
				int val2 = 0;
				if(index1>=0 && index2<length){
					val1 = nums[index1];
					val2 = nums[index2];
					if(Math.abs(val1-pivotValue) < Math.abs(val2-pivotValue)){
						result[index] = a*val1*val1 + b*val1 + c;
						index--;
						index1--;
					}
					else{
						result[index] = a*val2*val2 + b*val2 + c;
						index--;
						index2++;
					}
				}
				else if(index1>=0){
					//index2>=length
					val1 = nums[index1];
					result[index] = a*val1*val1 + b*val1 + c;
					index--;
					index1--;
					
				}
				else if(index2<length){
					//index1<0
					val2 = nums[index2];
					result[index] = a*val2*val2 + b*val2 + c;
					index--;
					index2++;
				}
			}
		}
		
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums = {-4,-2,2,4};
		//int a = 1;
		int a = -1;
		int b = 3;
		int c = 5;
		
		int[] result = sol.sortTransformedArray(nums, a, b, c);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i] + ", ");
		}
		System.out.println();

	}

}
