package plusOne;

public class Solution {

	public int[] plusOne(int[] digits){
		//given a non-negative integer represented as an array of digits
		//plus one to the number
		
		int[] result;
		
		if(digits==null || digits.length==0){
			result = new int[1];
			result[0] = 1;
			return result;
		}
				
		int length = digits.length;
		boolean flag =true;
		
		for(int i=length-1;i>=0;i--){
			if(flag){
				int sum = digits[i]+1;
				if(sum <10){
					digits[i] = sum;
					flag = false;
				}
				else{
					digits[i] = sum%10;
					flag = true;
				}
			}
			else{
				break;
			}
		}
		
		if(flag){
			//add one more digit
			result = new int[length+1];
			result[0] = 1;
			for(int i=0;i<length;i++){
				result[i+1] = digits[i];
			}
			return result;
		}
		else{
			return digits;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] digits = {9,9,9};
		Solution sol = new Solution();
		int[] results = sol.plusOne(digits);
		for(int i=0;i<results.length;i++){
			System.out.print(results[i] + ", ");
		}
		System.out.println();

	}

}
