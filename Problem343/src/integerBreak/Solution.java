package integerBreak;

public class Solution {

	public int integerBreak(int n) {
		//divide numbers into group of 3
		
		int num = n-2;
		int group = num/3;
		int index = num%3;
		
		//group 0 is unique
		if(group == 0){
			if(index == 0){
				return 1;
			}
			else if(index == 1){
				return 2;
			}
			else{
				return 4;
			}
		}
		
		//group i will have 3**i
		int result = 1;
		for(int i=0;i<group;i++){
			result *= 3;
		}
		//then times 2 or 3 or 4
		if(index == 0){
			return result*2;
		}
		else if(index == 1){
			return result*3;
		}
		else{
			return result*4;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
