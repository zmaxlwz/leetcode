package validPerfectSquare;

public class Solution {
	
	public boolean isPerfectSquare(int num) {
		if(num < 0){
			return false;
		}
		if(num == 0){
			return true;
		}
		long left = 0;
		long right = num/2+1;
		long mid = 0;
		while(left<=right){
			mid = (left+right)/2;
			if(mid*mid == num){
				return true;
			}
			else if(mid*mid < num){
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}
				
		return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
