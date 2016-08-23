package uniquePaths2;

public class Solution {

	public int uniquePathsWithObstacles(int[][] obstacleGrid){
		//similar to problem62, but there are obstacles in this problem
		//empty space is 0, obstacle is 1

		if(obstacleGrid.length == 0)
			return 0;

		int numRow = obstacleGrid.length;
		int numColumn = obstacleGrid[0].length;

		//use dynamic programming
		int[][] table = new int[numRow][numColumn];

		if(obstacleGrid[0][0] == 0){
			table[0][0] = 1;
		}
		else{
			table[0][0] = 0;
		}

		for(int j=1;j<numColumn;j++){
			if(obstacleGrid[0][j] == 0){
				table[0][j] = table[0][j-1];
			}
			else{
				table[0][j] = 0;
			}
		}

		for(int i=1;i<numRow;i++){
			if(obstacleGrid[i][0] == 0){
				table[i][0] = table[i-1][0];
			}
			else{
				table[i][0] = 0;
			}
		}

		for(int i=1;i<numRow;i++){
			for(int j=1;j<numColumn;j++){
				if(obstacleGrid[i][j] == 0){
					table[i][j] = table[i-1][j] + table[i][j-1];
				}
				else{
					table[i][j] = 0;
				}
			}
		}

		return table[numRow-1][numColumn-1];
	}

	public int uniquePathsWithObstacles2(int[][] obstacleGrid){
		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] table = new int[m][n];
		if(obstacleGrid[0][0] == 0){
			table[0][0] = 1;
		}
		else{
			table[0][0] = 0;
		}
		for(int j=1;j<n;j++){
			if(obstacleGrid[0][j] == 1){
				table[0][j] = 0;
			}
			else{
				table[0][j] = table[0][j-1];
			}
		}
		for(int i =1;i<m;i++){
			if(obstacleGrid[i][0] == 1){
				table[i][0] = 0;
			}
			else{
				table[i][0] = table[i-1][0];
			}
		}
		for(int i =1;i<m;i++){
			for(int j=1;j<n;j++){
				if(obstacleGrid[i][j] == 1){
					table[i][j] = 0;
				}
				else{
					table[i][j] = table[i-1][j] + table[i][j-1];
				}
			}
		}
		return table[m-1][n-1];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = {{0,0,0}, {0,1,0}, {0,0,0}};

		Solution sol = new Solution();
		System.out.println(sol.uniquePathsWithObstacles2(grid));

	}

}
