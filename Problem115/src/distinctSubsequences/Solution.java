package distinctSubsequences;

public class Solution {

	public int numDistinct(String s, String t){
		//return the number of distinct subsequences in s that is equal to t
		
		if(t==null || t.length() == 0){
			return 1;
		}
		
		if(s==null || s.length()==0 || s.length()<t.length()){
			return 0;
		}
		
		int sLength = s.length();
		int tLength = t.length();
		
		//use dynamic programming, create a 2-d arrays
		int[][] table = new int[sLength+1][tLength+1];
		
		for(int i=0;i<=sLength;i++){
			table[i][0] = 1;
		}
		for(int j=1;j<=tLength;j++){
			table[0][j] = 0;
		}
		
		for(int i=1;i<=sLength;i++){
			for(int j=1;j<=tLength;j++){
				char c1 = s.charAt(i-1);
				char c2 = t.charAt(j-1);
				if(c1 == c2){
					table[i][j] = table[i-1][j-1] + table[i-1][j];
				}
				else{
					table[i][j] = table[i-1][j];
				}
			}
		}
		
		return table[sLength][tLength];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "rabbbit";
		String t = "rabbit";
		Solution sol = new Solution();
		System.out.println(sol.numDistinct(s, t));

	}

}
