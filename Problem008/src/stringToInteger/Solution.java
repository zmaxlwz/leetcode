package stringToInteger;

public class Solution {

	public int myAtoi(String str){
		if(str == null || str.length() == 0){
			return 0;
		}
		str = str.trim();
		int length = str.length();
		if(length == 0){
			return 0;
		}
		int sign = 1;
		if(str.charAt(0) == '+'){
			str = str.substring(1);
			length--;
		}
		else if(str.charAt(0) == '-'){
			sign = -1;
			str = str.substring(1);
			length--;
		}
		double result = 0;
		for(int i =0; i<length;i++){
			char c = str.charAt(i);
			if(c >= '0' && c <= '9'){
				int value = c - '0';
				result = result * 10 + value;

			}
			else{
				break;
			}
		}
		result = result * sign;
		if(result > Integer.MAX_VALUE){
			return Integer.MAX_VALUE;
		}
		else if(result < Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		else{
			return (int)result;
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//String s = "-1563";
		String s = "9223372036854775809";
		int result = sol.myAtoi(s);
		System.out.println(result);
		//System.out.println(Long.MAX_VALUE);

	}

}
