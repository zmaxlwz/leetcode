package sqrt;

public class Solution {

	public int mySqrt(int x){
		//compute the sqrt(x), return integer
		//use binary search over [0, x/2+1]
		//****the binary search method is too slow:  Time Limit Exceeded****

		if(x<=0)
			return 0;

		int start = 0;
		int end = x/2+1;
		int middle;

		while(start<=end){
			middle = (start+end)/2;
			if(middle*middle <= x && x<(middle+1)*(middle+1)){
				return middle;
			}
			else if(x<middle*middle){
				end = middle-1;
			}
			else{
				start = middle+1;
			}
		}

		return 0;
	}

	public int newtonSqrt(int x){
		//use Newton method 
		//x[i+1] = (x[i]+x/x[i])/2

		if(x<=0)
			return 0;

		//result should be declared as long
		//otherwise, if x is Integer.MAX_VALUE, result+x/result will be negative
		long result = x/2 + 1;
		//System.out.println(result);
		//System.out.println(x/result);
		System.out.println(result + x/result);
		System.out.println(result*result);

		while(x<result*result || x>=(result+1)*(result+1)){
			result = (result + x/result)/2;
			System.out.println(result);

		}

		return (int)result;
	}

	public int mySqrt2(int x){
		if(x<=0){
			return 0;
		}
		if(x == 1){
			return 1;
		}
		long left = 1, right = x-1, mid;
		while(left<=right){
			mid = (left+right)/2;
			//System.out.println(mid);
			
			long prod1 = mid*mid;
			long prod2 = (mid+1)*(mid+1);
			if(x>=prod1 && x<prod2){
				return (int)mid;
			}
			else if(x<prod1){
				right = mid-1;
			}
			else{
				left = mid+1;
			}
			
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//int x = 2147483647;
		//int x = 2147395600;
		int x = 2147395599;

		//System.out.println(Integer.MAX_VALUE);
		//System.out.println(x);
		Solution sol = new Solution();
		//System.out.println(sol.newtonSqrt(x));
		System.out.println(sol.mySqrt2(x));

	}

}
