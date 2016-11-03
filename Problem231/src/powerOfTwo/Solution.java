package powerOfTwo;

public class Solution {

	public boolean isPowerOfTwo(int n){
		if(n<=0){
			return false;
		}

		while((n & 1) == 0){
			n = n>>1;
		}
		if(n == 1){
			return true;
		}
		else{
			return false;
		}
	}

	public boolean isPowerOfTwo2(int n){
		if(n<=0){
			return false;
		}
		boolean findOne = false;
		while(n>0){
			if((n&1) > 0){
				if(!findOne){
					findOne = true;
				}
				else{
					return false;
				}
			}
			n = n>>1;
		}
		return findOne;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 15;
		Solution sol = new Solution();
		System.out.println(sol.isPowerOfTwo2(n));

	}

}
