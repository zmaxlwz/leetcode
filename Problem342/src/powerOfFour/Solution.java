package powerOfFour;

public class Solution {
	
	public boolean isPowerOfFour(int num) {
		if(num<=0){
			return false;
		}
		while(num>1){
			if(num%4 != 0){
				return false;
			}
			num = num/4;
		}
		
		return num==1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
