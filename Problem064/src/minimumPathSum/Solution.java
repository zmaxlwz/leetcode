package minimumPathSum;

public class Solution {

	public int minPathSum(int[][] grid){
		//the grid includes non-negative numbers
		//from a path from top left to bottom right that minimizes the sum
		//return the min path sum

		if(grid == null || grid.length==0 || grid[0].length==0)
			return 0;

		int rowNum = grid.length;
		int colNum = grid[0].length;

		int[][] table = new int[rowNum][colNum];
		table[0][0] = grid[0][0];

		for(int j=1;j<colNum;j++){
			table[0][j] = table[0][j-1] + grid[0][j];
		}
		for(int i=1;i<rowNum;i++){
			table[i][0] = table[i-1][0] + grid[i][0];
		}

		for(int i=1;i<rowNum;i++){
			for(int j=1;j<colNum;j++){
				table[i][j] = Math.min(table[i-1][j], table[i][j-1]) + grid[i][j];
			}
		}

		return table[rowNum-1][colNum-1];
	}

	public int minPathSum2(int[][] grid){
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		int[][] table = new int[m][n];
		table[0][0] = grid[0][0];
		for(int j=1;j<n;j++){
			table[0][j] = table[0][j-1]+grid[0][j];
		}
		for(int i =1;i<m;i++){
			table[i][0] = table[i-1][0] + grid[i][0];
		}
		for(int i =1;i<m;i++){
			for(int j=1;j<n;j++){
				table[i][j] = Math.min(table[i-1][j], table[i][j-1])+grid[i][j];
			}
		}
		return table[m-1][n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] grid = {{1,1,3,4}, {8,1,5,6}, {9,1,1,1}};
		Solution sol = new Solution();
		System.out.println(sol.minPathSum2(grid));

	}

}
