package surroundedRegions2;

import java.util.*;

public class Solution {

	public void solve(char[][] board){
		if(board == null || board.length <= 2 || board[0].length <= 2){
			return;
		}
		int numRows = board.length;
		int numCols = board[0].length;
		for(int i =0;i<numRows;i++){
			if(board[i][0] == 'O'){
				dfs(board, i, 0);
			}
			if(board[i][numCols-1] == 'O'){
				dfs(board, i, numCols-1);
			}
		}
		for(int j=1;j<numCols-1;j++){
			if(board[0][j] == 'O'){
				dfs(board, 0, j);
			} 
			if(board[numRows-1][j] == 'O'){
				dfs(board, numRows-1, j);
			}
		}
		for(int i =0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				if(board[i][j] == 'O'){
					board[i][j] = 'X';
				}
			}
		}
		for(int i =0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				if(board[i][j] == 'Y'){
					board[i][j] = 'O';
				}
			}
		}
		return;
	}

	public void dfs(char[][] board, int i , int j){
		board[i][j] = 'Y';
		if(i-1>=0 && board[i-1][j] == 'O'){
			dfs(board, i-1, j);
		}
		if(i+1 < board.length && board[i+1][j] == 'O'){
			dfs(board, i+1, j);
		}
		if(j-1>=0 && board[i][j-1] == 'O'){
			dfs(board, i, j-1);
		}
		if(j+1 < board[0].length && board[i][j+1] == 'O'){
			dfs(board, i, j+1);
		}
		return;
	}

	public void solve2(char[][] board){
		if(board == null || board.length <= 2 || board[0].length <= 2){
			return;
		}
		int numRows = board.length;
		int numCols = board[0].length;
		for(int i =0;i<numRows;i++){
			bfs(board, i, 0);
			bfs(board, i, numCols-1);
		}
		for(int j=1;j<numCols-1;j++){
			bfs(board, 0, j);
			bfs(board, numRows-1, j);
		}
		for(int i =0;i<numRows;i++){
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
	public void bfs(char[][] board, int i, int j){
		if(board[i][j] != 'O'){
			return;
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.offer(new Node(i, j));
		while(!queue.isEmpty()){
			Node node = queue.poll();
			if(board[node.i][node.j] != 'O'){
				continue;
			}
			board[node.i][node.j] = 'Y';
			if(node.i-1>=0 && board[node.i-1][node.j] == 'O'){
				queue.offer(new Node(node.i-1, node.j));
			}
			if(node.i+1<board.length && board[node.i+1][node.j] == 'O'){
				queue.offer(new Node(node.i+1, node.j));
			}
			if(node.j-1 >= 0 && board[node.i][node.j-1] == 'O'){
				queue.offer(new Node(node.i, node.j-1));
			}
			if(node.j+1<board[0].length && board[node.i][node.j+1] == 'O'){
				queue.offer(new Node(node.i, node.j+1));
			}
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
		Solution sol = new Solution();
		sol.solve2(board);
		for(int i=0;i<board.length;i++){
			System.out.println(new String(board[i]));
		}

	}

}


class Node{
	int i ;
	int j;
	Node(int i ,int j){
		this.i = i;
		this.j = j;
	}
}



