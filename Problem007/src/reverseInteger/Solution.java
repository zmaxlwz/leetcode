package reverseInteger;

public class Solution {

	public int reverse(int x){

		int sign;

		//use double to prevent reverse of x is out of range
		double value = 0;

		//check x is positive, negative or 0
		if(x<0){
			sign = -1;
			x = -x;
		}
		else if(x>0){
			sign = 1;			
		}
		else{
			//x==0
			return x;
		}

		//reverse absolute value of x
		while(x>0){
			value = value*10 + x%10;
			x = x/10;
		}

		value = sign*value;

		if(value > Integer.MAX_VALUE || value < Integer.MIN_VALUE){
			return 0;
		}

		return (int)value;
	}

	public int reverse2(int x){
		int sign;
		if(x < 0){
			sign = -1;
		}
		else if(x>0){
			sign = 1;
		}
		else{
			return x;
		}
		long absx = sign*x;
		long result = 0;
		while(absx > 0){
			result = result*10 + absx%10;
			absx = absx/10;
		}
		result = result*sign;
		if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
			return 0;
		}
		else{
			return (int)result;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();

		//int x = 1000000003;	
		int x = -123;
		System.out.println(sol.reverse2(x));

	}

}
