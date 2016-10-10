package factorialTrailingZeroes;

public class Solution {

	public int trailingZeroes(int n){
		//return the number of trailing zeroes in n!
		//count the number of 5

		long factor = 5;
		int numZero = 0;
		while(n>=factor){
			numZero += n/factor;
			factor *= 5;
		}
		return numZero;
	}

	public int trailingZeroes2(int n){
		if(n<=0){
			return 0;
		}
		long multiple = 5;
		int numZeroes = 0;
		while(multiple<=n){
			numZeroes += n/multiple;
			multiple *= 5;
		}
		return numZeroes;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 2147483647;
		Solution sol = new Solution();
		System.out.println(sol.trailingZeroes2(n));

	}

}
