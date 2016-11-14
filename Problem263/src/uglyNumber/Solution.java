package uglyNumber;

public class Solution {

	public boolean isUgly(int num){
		if(num <= 0){
			return false;
		}
		while((num%2)==0){
			num = num/2;
		}
		while((num%3)==0){
			num = num/3;
		}
		while((num%5)==0){
			num = num/5;
		}
		return num == 1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		
		//int n = 6;
		//int n = 8;
		int n = 14;
		
		System.out.println(sol.isUgly(n));

	}

}
