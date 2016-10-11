package numberOfIslands;

public class Solution {

	public int numIslands(char[][] grid){
		//use a visited matrix and do dfs search
		if(grid == null || grid.length==0){
			return 0;
		}
		int rowNum = grid.length;
		int colNum = grid[0].length;
		boolean[][] visited = new boolean[rowNum][colNum];
		int count = 0;
		for(int i=0;i<rowNum;i++){
			for(int j=0;j<colNum;j++){
				if(!visited[i][j] && grid[i][j] == '1'){
					count++;
					dfs(grid, visited, i, j);
				}
			}
		}
		return count;

	}

	private void dfs(char[][] grid, boolean[][] visited, int row, int col){
		visited[row][col] = true;
		if(col-1>=0 && !visited[row][col-1] && grid[row][col-1] == '1'){
			dfs(grid, visited, row, col-1);
		}	
		if(col+1<grid[0].length && !visited[row][col+1] && grid[row][col+1] == '1'){
			dfs(grid, visited, row, col+1);
		}
		if(row-1>=0 && !visited[row-1][col] && grid[row-1][col] == '1'){
			dfs(grid, visited, row-1, col);
		}
		if(row+1<grid.length && !visited[row+1][col] && grid[row+1][col] == '1'){
			dfs(grid, visited, row+1, col);
		}
	}

	public int numIslands2(char[][] grid){
		//return the number of islands in the grid

		if(grid == null || grid.length == 0){
			return 0;
		}

		int numRows = grid.length;
		int numCols = grid[0].length;
		int count = 0;

		for(int i =0; i< numRows; i++){
			for(int j = 0; j< numCols; j++){
				if(grid[i][j] == '1'){
					count++;
					dfs2(grid, i, j);
				}
			}
		}
		return count;
	}

	public void dfs2(char[][] grid, int i, int j){
		grid[i][j] = '0';
		if(j-1>=0 && grid[i][j-1] == '1'){
			dfs2(grid, i, j-1);
		}
		if(i-1>=0 && grid[i-1][j] == '1'){
			dfs2(grid, i-1, j);
		}
		if(j+1<grid[0].length && grid[i][j+1] == '1'){
			dfs2(grid, i, j+1);
		}
		if(i+1<grid.length && grid[i+1][j] == '1'){
			dfs2(grid, i+1, j);
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
		char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};

		Solution sol = new Solution();
		System.out.println(sol.numIslands2(grid));

	}

}
