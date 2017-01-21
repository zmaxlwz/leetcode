package bombEnemy;

public class Solution {
	
	public int maxKilledEnemies(char[][] grid) {
		
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;
		
		int[][] leftEnemies = new int[m][n];
		int[][] rightEnemies = new int[m][n];
		int[][] topEnemies = new int[m][n];
		int[][] bottomEnemies = new int[m][n];
		
		//process each row
		for(int i=0;i<m;i++){
			int num = 0;
			//scan from left to right for row i
			for(int j=0;j<n;j++){
				if(grid[i][j] == '0'){
					leftEnemies[i][j] = num;
				}
				else if(grid[i][j] == 'E'){
					num++;
				}
				else{
					//grid[i][j] == 'W'
					num = 0;
				}
			}
			num = 0;
			//scan from right to left for row i
			for(int j=n-1;j>=0;j--){
				if(grid[i][j] == '0'){
					rightEnemies[i][j] = num;
				}
				else if(grid[i][j] == 'E'){
					num++;
				}
				else{
					//grid[i][j] == 'W'
					num = 0;
				}
			}
			
		}
		
		//process each column
		for(int j=0;j<n;j++){
			int num = 0;
			//scan from top to bottom for column j
			for(int i=0;i<m;i++){
				if(grid[i][j] == '0'){
					topEnemies[i][j] = num;
				}
				else if(grid[i][j] == 'E'){
					num++;
				}
				else{
					//grid[i][j] == 'W'
					num = 0;
				}
			}
			num = 0;
			//scan from bottom to top for column j
			for(int i=m-1;i>=0;i--){
				if(grid[i][j] == '0'){
					bottomEnemies[i][j] = num;
				}
				else if(grid[i][j] == 'E'){
					num++;
				}
				else{
					//grid[i][j] == 'W'
					num = 0;
				}
			}
		}
		
		//compute max Enemies
		int maxNumEnemies = 0;
		int numEnemies = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j] == '0'){
					numEnemies = leftEnemies[i][j] + rightEnemies[i][j] + topEnemies[i][j] + bottomEnemies[i][j];
					if(numEnemies > maxNumEnemies){
						maxNumEnemies = numEnemies;
					}
				}
			}
		}
		
		return maxNumEnemies;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		char[][] grid = {{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
		
		System.out.println(sol.maxKilledEnemies(grid));

	}

}
