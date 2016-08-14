package divideIntegers;

public class Solution {

	public int divide(int dividend, int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		if(divisor == 1){
			return dividend;
		}
		if(divisor == -1){
			if(dividend == Integer.MIN_VALUE){
				return Integer.MAX_VALUE;
			}
			else{
				return negate(dividend);
			}	 
		}
		if(dividend==0){
			return 0;
		}
		
		long absDividend = Math.abs((long)dividend);
		long absDivisor = Math.abs((long)divisor);
		//System.out.println(absDividend);
		//System.out.println(absDivisor);
		int quotient = absDivide(absDividend, absDivisor);
		if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
			return quotient;
		}
		else{
			return negate(quotient);
		}
	}

	public int absDivide(long dividend, long divisor){
		if(dividend<divisor){
			return 0;
		}
		int quotient = 1;
		long product = divisor;
		while(product + product <= dividend){
			quotient = quotient + quotient;
			product = product + product;
		}
		return quotient + absDivide(dividend-product, divisor);
	}



	public int negate(int x){
		int unit;

		if(x>0){
			unit = -1;
		}
		else if(x<0){
			unit = 1;
		}
		else{
			return 0;
		}
		int negate_value = 0;
		while(x != 0){
			x = x+unit;
			negate_value = negate_value + unit;
		}
		return negate_value;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(Integer.MIN_VALUE);
		//System.out.println(Integer.MAX_VALUE);
			
		
		Solution sol = new Solution();
		//int dividend = -1768809435;
		//int divisor = -2147483648;
		int dividend = -2147483648;
		int divisor = 2;
		
		int result = sol.divide(dividend, divisor);
		System.out.println(result);

	}

}
