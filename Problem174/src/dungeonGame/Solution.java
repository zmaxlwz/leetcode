package dungeonGame;

public class Solution {

	public int calculateMinimumHP(int[][] dungeon){

		if(dungeon == null || dungeon.length == 0){
			return 1;
		}

		int rowNum = dungeon.length;
		int colNum = dungeon[0].length;
		int[][] minHealth = new int[rowNum][colNum];

		minHealth[rowNum-1][colNum-1] = Math.max(1-dungeon[rowNum-1][colNum-1], 1);
		for(int i=rowNum-2;i>=0;i--){
			minHealth[i][colNum-1] = Math.max(minHealth[i+1][colNum-1] - dungeon[i][colNum-1], 1);
		}
		for(int j=colNum-2;j>=0;j--){
			minHealth[rowNum-1][j] = Math.max(minHealth[rowNum-1][j+1] - dungeon[rowNum-1][j], 1);
		}

		for(int i=rowNum-2;i>=0;i--){
			for(int j=colNum-2;j>=0;j--){
				minHealth[i][j] = Math.max(Math.min(minHealth[i+1][j], minHealth[i][j+1])-dungeon[i][j], 1);
			}
		}

		return minHealth[0][0];
	}

	public int calculateMinimumHP2(int[][] dungeon){
		if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
			return 1;	
		}
		int numRow = dungeon.length;
		int numCol = dungeon[0].length;
		int[][] table = new int[numRow][numCol];
		if(dungeon[numRow-1][numCol-1]>=0){
			table[numRow-1][numCol-1] = 1;
		}
		else{
			table[numRow-1][numCol-1] = 1-dungeon[numRow-1][numCol-1];
		}
		for(int j=numCol-2;j>=0;j--){
			int t = table[numRow-1][j+1] - dungeon[numRow-1][j];
			t = t>0? t:1;
			table[numRow-1][j] = t;
		}
		for(int i=numRow-2;i>=0;i--){
			int t = table[i+1][numCol-1] - dungeon[i][numCol-1];
			t = t>0?t:1;
			table[i][numCol-1] = t;
		}

		for(int i=numRow-2;i>=0;i--){
			for(int j=numCol-2;j>=0;j--){
				int t = Math.min(table[i+1][j], table[i][j+1])-dungeon[i][j];
				t = t>0?t:1;
				table[i][j] = t;
			}
		}
		return table[0][0];
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] dungeon = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
		Solution sol = new Solution();
		System.out.println(sol.calculateMinimumHP2(dungeon));

	}

}
