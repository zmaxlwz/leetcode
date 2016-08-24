package editDistance;

public class Solution {

	public int minDistance(String word1, String word2){
		//convert word1 to word2
		//return the minimum edit distance
		//three types of edit: insert one char, remove one char, replace one char
		//use dynamic programming

		if((word1 == null || word1.length()==0) && (word2 == null || word2.length()==0)){
			return 0;
		}

		if(word1 == null || word1.length() == 0){
			return word2.length();
		}

		if(word2 == null || word2.length() == 0){
			return word1.length();
		}

		int m = word1.length();
		int n = word2.length();

		int[][] table = new int[m+1][n+1];

		for(int j=0;j<=n;j++){
			table[0][j] = j;
		}
		for(int i=0;i<=m;i++){
			table[i][0] = i;
		}

		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				int min = Math.min(table[i-1][j], table[i][j-1]);
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					table[i][j] = Math.min(min+1, table[i-1][j-1]);

				}
				else{
					table[i][j] = Math.min(min+1, table[i-1][j-1]+1);
				}

			}
		}

		return table[m][n];
	}

	public int minDistance2(String word1, String word2){
		if(word1 == null || word1.length()==0){
			if(word2 == null){
				return 0;
			}
			else{
				return word2.length();
			}
		}
		if(word2 == null || word2.length()==0){
			return word1.length();
		}
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] table = new int[len1+1][len2+1];
		for(int j=0;j<=len2;j++){
			table[0][j] = j;
		}
		for(int i =0;i<=len1;i++){
			table[i][0] = i;
		}
		int n1, n2, n3;
		for(int i =1;i<=len1;i++){
			for(int j=1;j<=len2;j++){
				n1 = table[i-1][j]+1;
				n2 = table[i][j-1]+1;
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					n3 = table[i-1][j-1];
				}
				else{
					n3 = table[i-1][j-1]+1;
				}
				table[i][j] = Math.min(Math.min(n1,n2),n3);
			}
		}
		return table[len1][len2];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String word1 = "geek";
		//String word2 = "gesek";
		//String word1 = "cat";
		//String word2 = "cut";
		String word1 = "sunday";
		String word2 = "saturday";

		Solution sol = new Solution();
		System.out.println(sol.minDistance2(word1, word2));

	}

}
