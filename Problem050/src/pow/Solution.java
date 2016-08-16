package pow;

public class Solution {

	public double myPow(double x, int n){
		//compute x^n, 
		//use binary search, use O(log(n)) time

		if(x==0)
			return 0;

		if(n==0)
			return 1;

		double result = myPow(x, n/2);
		if(n%2 == 0){
			//n is even integer
			return result*result;
		}			
		else{
			if(n>0){
				//n is positive odd integer
				return result*result*x;
			}

			else{
				//n is negative odd integer
				return result*result/x;
			}

		}

	}

	public double myPow2(double x, int n){
		if(n == 0){
			return 1;
		}
		double result = myPow(x, n/2);
		if(n%2 == 0){
			return result*result;
		}
		else{
			if(n>0){
				return x*result*result;
			}
			else{
				return result*result/x;
			}
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double x = 2.0;
		int n = -3;
		Solution sol = new Solution();
		System.out.println(sol.myPow2(x, n));
		System.out.println(-3/2);

	}

}
