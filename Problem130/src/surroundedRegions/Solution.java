package surroundedRegions;

import java.util.*;

public class Solution {

	public void solve(char[][] board){
		//board is a 2D board containing 'X' and 'O'
		//capture all 'O' regions surrounded by 'X' 
		//if a 'O' region is open, don't capture it
		//use queue to do bfs search
				
		if(board == null || board.length==0 || board[0].length==0){
			return;
		}
		
		int numRows = board.length;
		int numCols = board[0].length;
		
		if(numRows == 1 || numCols == 1){
			//only one row or one column, 'O' region must be open
			return;
		}
		
		//change open 'O' regions to 'Y'
		int x=0;
		int y=0;
		for(int j=0;j<numCols-1;j++){
			if(board[x][y] == 'O'){
				bfs(board, x,y);
			}
			y++;
		}
		for(int i=0;i<numRows-1;i++){
			if(board[x][y] == 'O'){
				bfs(board, x,y);
			}
			x++;
		}
		for(int j=0;j<numCols-1;j++){
			if(board[x][y] == 'O'){
				bfs(board, x,y);
			}
			y--;
		}
		for(int i=0;i<numRows-1;i++){
			if(board[x][y] == 'O'){
				bfs(board, x,y);
			}
			x--;
		}
		
		//change closed regions to 'X', and change open regions back to 'O'
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
				else if(board[i][j] == 'Y'){
					board[i][j] = 'O';
				}
			}
		}
		
		return;
	}
	
	private void bfs(char[][] board, int i, int j){
		//board[i][j] is 'O', do bfs from here, change 'O' to 'Y'
		
		int numRows = board.length;
		int numCols = board[0].length;
		
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(i,j));
		while(!queue.isEmpty()){
			Node node = queue.poll();
			i = node.i;
			j = node.j;
			//*****important check *******  some nodes may have been changed to 'Y' before, don't repeat the same process again
			if(board[i][j] == 'O')
				board[i][j] = 'Y';
			else
				continue;
			if(i-1>=0 && board[i-1][j]=='O'){
				queue.offer(new Node(i-1, j));
			}
			if(i+1<numRows && board[i+1][j]=='O'){
				queue.offer(new Node(i+1, j));
			}
			if(j-1>=0 && board[i][j-1]=='O'){
				queue.offer(new Node(i, j-1));
			}
			if(j+1<numCols && board[i][j+1]=='O'){
				queue.offer(new Node(i, j+1));
			}
		}
		
	}
	
	public void solve2(char[][] board){
		//board is a 2D board containing 'X' and 'O'
		//capture all 'O' regions surrounded by 'X' 
		//if a 'O' region is open, don't capture it
		//use recursion to change 'O' to 'Y' may incur stack overflow
				
		if(board == null || board.length==0 || board[0].length==0){
			return;
		}
		
		int numRows = board.length;
		int numCols = board[0].length;
		
		if(numRows == 1 || numCols == 1){
			//only one row or one column, 'O' region must be open
			return;
		}
		
		//change open 'O' regions to 'Y'
		int x=0;
		int y=0;
		for(int j=0;j<numCols-1;j++){
			flip(board, x,y);
			y++;
		}
		for(int i=0;i<numRows-1;i++){
			flip(board, x,y);
			x++;
		}
		for(int j=0;j<numCols-1;j++){
			flip(board, x,y);
			y--;
		}
		for(int i=0;i<numRows-1;i++){
			flip(board, x,y);
			x--;
		}
		
		//change closed regions to 'X', and change open regions back to 'O'
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
				else if(board[i][j] == 'Y'){
					board[i][j] = 'O';
				}
			}
		}
		
		return;
	}
	
	
	private void flip(char[][] board, int i, int j){
		int numRows = board.length;
		int numCols = board[0].length;
		
		if(board[i][j] == 'O')
			board[i][j] = 'Y';
		else
			return;
		
		if(i-1>=0){
			flip(board, i-1,j);
		}
		if(i+1<numRows){
			flip(board, i+1, j);
		}
		if(j-1>=0){
			flip(board, i, j-1);
		}
		if(j+1<numCols){
			flip(board, i, j+1);
		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = {{'X', 'X', 'X', 'X'}, {'X','O','O','X'},{'X','X','O','X'}, {'X','O','X','X'}};
		Solution sol = new Solution();
		sol.solve2(board);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j] + ", ");
			}
			System.out.println();
		}

	}

}
