package addDigits;

public class Solution {
	
	public int addDigits(int num) {
        //final sum is from 1~9, appearing periodically
        return (num-1)%9 + 1;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
