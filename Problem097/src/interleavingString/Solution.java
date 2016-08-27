package interleavingString;

public class Solution {

	public boolean isInterleave(String s1, String s2, String s3){
		//check if s3 is an interleaving of s1 and s2
		//use 2D dynamic programming

		int length1 = s1.length();
		int length2 = s2.length();
		int length3 = s3.length();

		if(length1 + length2 != length3){
			return false;
		}

		if(length1 == 0){
			return s2.equals(s3);
		}
		if(length2 == 0){
			return s1.equals(s3);
		}

		boolean[][] table = new boolean[length1+1][length2+1];
		for(int i=1;i<=length2;i++){	
			table[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
		}
		for(int i=1;i<=length1;i++){
			table[i][0] = s1.substring(0,i).equals(s3.substring(0,i));
		}
		for(int i=1;i<=length1;i++){
			for(int j=1;j<=length2;j++){
				char c1 = s1.charAt(i-1);
				char c2 = s2.charAt(j-1);
				char c3 = s3.charAt(i+j-1);
				if(c1 == c3 && c2 == c3){
					table[i][j] = table[i-1][j] || table[i][j-1];
				}
				else if(c1 == c3){
					table[i][j] = table[i-1][j];
				}
				else if(c2 == c3){
					table[i][j] = table[i][j-1];
				}
				else{
					table[i][j] = false;
				}
			}
		}
		return table[length1][length2];
	}

	public boolean isInterleave2(String s1, String s2, String s3){
		if(s1 == null || s2 == null || s3 == null){
			return false;
		}
		int len1 = s1.length();
		int len2 = s2.length();
		int len3 = s3.length();
		if(len1+len2 != len3){
			return false;
		}
		boolean[][] table = new boolean[len1+1][len2+1];
		table[0][0] = true;
		for(int i =1;i<=len1;i++){
			if(s1.charAt(i-1) == s3.charAt(i-1) && table[i-1][0]){
				table[i][0] = true;
			}
			else{
				table[i][0] = false;
			}
		}
		for(int j=1;j<=len2;j++){
			if(s2.charAt(j-1) == s3.charAt(j-1) && table[0][j-1]){
				table[0][j] = true;
			}
			else{
				table[0][j] = false;
			}
		}
		for(int i =1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				char c1 = s1.charAt(i-1);
				char c2 = s2.charAt(j-1);
				char c3 = s3.charAt(i+j-1);
				if(c3 != c1 && c3 != c2){
					table[i][j] = false;
				}
				else if(c3 == c1 && c3 != c2){
					table[i][j] = table[i-1][j];
				}
				else if(c3 != c1 && c3 == c2){
					table[i][j] = table[i][j-1];
				}
				else{
					table[i][j] = table[i-1][j] || table[i][j-1];
				}
			}
		}
		return table[len1][len2];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		//String s3 = "aadbbbaccc";

		Solution sol = new Solution();
		System.out.println(sol.isInterleave2(s1, s2, s3));

	}

}
