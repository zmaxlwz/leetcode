package excelSheetColumnTitle;

public class Solution {

	public String convertToTitle(int n){
		//convert the number to Excel title
		int count = n;
		String title = "";
		while(count>0){
			count = count-1;
			char c = (char)('A' + count%26);
			title = String.valueOf(c) + title;
			count = count/26;
		}
		return title;
	}

	public String convertToTitle2(int n){
		if(n<=0){
			return "";
		}
		String result = "";
		while(n>0){
			n = n-1;
			char c = (char)('A' + n%26);
			result = String.valueOf(c) + result;
			n = n/26;
		}
		return result;
	}

	public String convertToTitle3(int n){
		if(n<=0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		while(n>0){
			n = n-1;
			char c = (char)('A' + n%26);
			sb.insert(0, c);
			n = n/26;
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 28;
		Solution sol = new Solution();
		System.out.println(sol.convertToTitle3(n));

	}

}
