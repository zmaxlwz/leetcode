package gameOfLife;

public class Solution {

	public void gameOfLife(int[][] board){
		if(board == null || board.length == 0 || board[0].length == 0){
			return;
		}
		int numRows = board.length;
		int numCols = board[0].length;
		int[][] newBoard = new int[numRows][numCols];
		for(int i =0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				int count = countNeighbors(board, numRows, numCols, i, j);
				if(board[i][j] == 0){
					if(count == 3){
						newBoard[i][j] = 1;
					}
					else{
						newBoard[i][j] = 0;
					}
				}
				else{
					if(count < 2 || count>3){
						newBoard[i][j] = 0;
					}
					else{
						newBoard[i][j] = 1;
					}
				}
			}
		}
		for(int i =0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				board[i][j] = newBoard[i][j];
			}
		}
		return;
	}
	
	public int countNeighbors(int[][] board, int m, int n, int i , int j){
		int count = 0;
		if(i-1>=0){
			if(board[i-1][j] == 1){
				count++;
			}
			if(j-1>=0 && board[i-1][j-1] == 1){
				count++;
			}
			if(j+1<n && board[i-1][j+1] == 1){
				count++;
			}
		}
		if(i+1<m){
			if(board[i+1][j] == 1){
				count++;
			}
			if(j-1>=0 && board[i+1][j-1] == 1){
				count++;
			}
			if(j+1<n && board[i+1][j+1] == 1){
				count++;
			}

		}
		if(j-1>=0 && board[i][j-1] == 1){
			count++;
		}
		if(j+1<n && board[i][j+1] == 1){
			count++;
		}
		return count;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
