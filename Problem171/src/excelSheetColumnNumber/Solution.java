package excelSheetColumnNumber;

public class Solution {

	public int titleToNumber(String s){
		//convert the Excel sheet title to number
		int number = 0;
		for(int i=0;i<s.length();i++){
			number = number*26 + s.charAt(i) - 'A' +1;
		}
		return number;
	}

	public int titleToNumber2(String s){
		if(s == null || s.length() == 0){
			return 0;
		}
		int length = s.length();
		int result = 0;
		for(int i=0;i<length;i++){
			char c = s.charAt(i);
			result = result*26 + c - 'A' +1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "AB";
		Solution sol = new Solution();
		System.out.println(sol.titleToNumber(s));

	}

}
