package longestPalindrome;

public class Solution {

	public String longestPalindrome(String s){
		//use dynamic programming

		int strLen = s.length();

		int max_len = 1;
		String palindrome = s.substring(0, 1);

		boolean[][] validPalindrome = new boolean[strLen][strLen];

		for(int i=0;i<strLen;i++)
			for(int j=0;j<strLen;j++){
				validPalindrome[i][j] = false;
			}

		for(int i=0;i<strLen;i++){
			validPalindrome[i][i] = true;
		}

		for(int i=0;i<strLen-1;i++){
			if(s.charAt(i) == s.charAt(i+1)){
				validPalindrome[i][i+1] = true;
				if(max_len < 2){
					max_len = 2;
					palindrome = s.substring(i, i+2);
				}
			}

		}

		for(int j=2;j<strLen;j++)
			for(int i=0;i<j-1;i++){
				if(s.charAt(i) == s.charAt(j) && validPalindrome[i+1][j-1]){
					validPalindrome[i][j] = true;
					if(max_len < j-i+1){
						max_len = j-i+1;
						palindrome = s.substring(i, j+1);
					}
				}	
				else
					validPalindrome[i][j] = false;
			}

		return palindrome;
	}

	public String longestPalindrome2(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		char[] array = s.toCharArray();
		int length = array.length;
		int maxLength = 0;
		String str = "", maxPalindrome = "";
		for(int i =0;i<length;i++){
			str = getMaxPalindrome(array, i);
			if(str.length() > maxLength){
				maxPalindrome = str;
				maxLength = str.length();
			}
		}
		for(int i = 0; i<length-1; i++ ){
			str = getMaxPalindrome(array, i, i+1);
			if(str.length()>maxLength){
				maxPalindrome = str;
				maxLength = str.length();
			}
		}
		return maxPalindrome;

	}
	public String getMaxPalindrome(char[] array, int index){
		int length = array.length;
		StringBuffer sb = new StringBuffer();
		sb.append(array[index]);
		int p = index-1;
		int q = index+1;
		while(p>=0 && q<length && array[p] == array[q]){
			sb.insert(0, array[p]);
			sb.append(array[q]);
			p--;
			q++;
		}
		return sb.toString();
	}
	public String getMaxPalindrome(char[] array, int index1, int index2){
		int length = array.length;
		StringBuffer sb = new StringBuffer();
		while(index1>=0 && index2<length && array[index1] == array[index2]){
			sb.insert(0, array[index1]);
			sb.append(array[index2]);
			index1--;
			index2++;
		}
		return sb.toString();
	}

	public String longestPalindrome3(String s){
		if(s == null || s.length() == 0){
			return "";
		}
		int length = s.length();
		int maxLength = 1;
		String maxPalindrome = s.substring(0,1);
		boolean[][] table = new boolean[length][length];
		for(int i =0;i<length;i++){
			table[i][i] = true;
		}
		for(int i =0;i<length-1;i++){
			if(s.charAt(i) == s.charAt(i+1)){
				table[i][i+1] = true;
				if(maxLength<2){
					maxLength = 2;
					maxPalindrome = s.substring(i, i+2);
				}
			}
		}
		for(int j = 2;j<length;j++){
			for(int i=0; i<=j-2; i++){
				if(s.charAt(i) == s.charAt(j) && table[i+1][j-1]){
					table[i][j] = true;
					if(maxLength<j-i+1){
						maxLength = j-i+1;
						maxPalindrome = s.substring(i, j+1);
					}
				}
			}
		}
		return maxPalindrome;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "cbabcdcba";
		Solution sol = new Solution();
		System.out.println(sol.longestPalindrome3(s));

	}

}
