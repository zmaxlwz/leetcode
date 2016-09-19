package palindromePartitioning2;

public class Solution {


	public int minCut(String s){
		//return the min number of cuts such that each partition is a palindrome

		if(s==null || s.length()<=1){
			return 0;
		}
		int length = s.length();

		//use dynamic programming
		boolean[][] table = new boolean[length][length];
		int[] minCuts = new int[length];

		for(int j=0;j<length;j++){
			minCuts[j] = j;
			for(int i=0;i<=j;i++){
				char c1 = s.charAt(i);
				char c2 = s.charAt(j);
				if(c1 == c2 && (j-i<=1 || table[i+1][j-1])){
					table[i][j] = true;
					if(i==0){
						minCuts[j] = 0;
					}
					else{
						if(minCuts[i-1]+1 < minCuts[j]){
							minCuts[j] = minCuts[i-1]+1;
						}
					}
				}
				else{
					table[i][j] = false;
				}
			}
		}
		return minCuts[length-1];
	}

	public int minCut2(String s){

		if(s == null || s.length() <= 1){
			return 0;
		}
		int length = s.length();
		boolean[][] table = new boolean[length][length];
		for(int j=0;j<length;j++){
			for(int i =0;i<=j;i++){
				char c1 = s.charAt(i);
				char c2 = s.charAt(j);
				if(c1 == c2 && (j-i<=1 || table[i+1][j-1])){
					table[i][j] = true;
				}
				else{
					table[i][j] = false;
				}
			}
		}
		int[] minCuts = new int[length];
		for(int i =1;i<length;i++){

			if(table[0][i]){
				minCuts[i] = 0;
				continue;
			}
			else{
				minCuts[i] = i;
			}
			for(int k=1;k<=i;k++){
				if(table[k][i]){
					if(minCuts[k-1]+1<minCuts[i]){
						minCuts[i] = minCuts[k-1]+1;
					}
				}
			}
		}
		return minCuts[length-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//String s = "aab";
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Solution sol = new Solution();
		System.out.println(sol.minCut(s));

	}

}
