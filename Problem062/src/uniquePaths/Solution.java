package uniquePaths;

public class Solution {

	public int uniquePaths(int m, int n){
		//there is a m*n grid, the robot is at the top left corner
		//the robot can only move right or downward
		//return the number of ways to reach the bottom right corner

		if(m<=0 || n<=0)
			return 0;

		//use dynamic programming 
		int[][] table = new int[m][n];

		for(int j=0;j<n;j++){
			table[0][j] = 1;
		}
		for(int i=0;i<m;i++){
			table[i][0] = 1;
		}

		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				table[i][j] = table[i][j-1] + table[i-1][j];
			}
		}

		return table[m-1][n-1];
	}

	public int uniquePaths2(int m, int n){
		if(m<=0 || n<=0){
			return 0;
		}
		int[][] table = new int[m][n];
		for(int j=0;j<n;j++){
			table[0][j] = 1;
		}
		for(int i =0;i<m;i++){
			table[i][0] = 1;
		}
		for(int i =1;i<m;i++){
			for(int j=1;j<n;j++){
				table[i][j] = table[i-1][j]+table[i][j-1];
			}
		}
		return table[m-1][n-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m = 3;
		int n = 7;

		Solution sol = new Solution();
		System.out.println(sol.uniquePaths2(m, n));

	}

}
