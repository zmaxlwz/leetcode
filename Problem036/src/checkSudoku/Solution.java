package checkSudoku;

import java.util.*;

public class Solution {

	public boolean isValidSudoku(char[][] board){
		if(board == null || board.length == 0 || board[0].length == 0){
			return false;
		}
		int numRows = board.length;
		int numCols = board[0].length;
		if(numRows != 9 || numCols != 9){
			return false;
		}
		for(int i =0;i<9;i++){
			if(!checkRow(board, i)){
				return false;
			}
		}
		for(int j=0;j<9;j++){
			if(!checkColumn(board, j)){
				return false;
			}
		}
		for(int i =0;i<3;i++){
			for(int j=0;j<3;j++){
				if(!checkBox(board, i, j)){
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkRow(char[][] board, int rowIndex){
		HashSet<Character> set = new HashSet<Character>();
		for(int j =0;j<9;j++){
			char c = board[rowIndex][j];
			if(c>='1' && c<='9'){
				if(set.contains(c)){
					return false;
				}
				else{
					set.add(c);
				}
			}
		}
		return true;
	}
	public boolean checkColumn(char[][] board, int colIndex){
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0;i<9;i++){
			char c = board[i][colIndex];
			if(c>='1' && c<='9'){
				if(set.contains(c)){
					return false;
				}
				else{
					set.add(c);
				}
			}
		}
		return true;
	}
	public boolean checkBox(char[][] board, int row, int col){
		HashSet<Character> set = new HashSet<Character>();
		for(int i =0;i<3;i++){
			int rowIndex = 3*row + i;
			for(int j=0;j<3;j++){
				int colIndex = 3*col + j;
				char c = board[rowIndex][colIndex];
				if(c>='1' && c<='9'){
					if(set.contains(c)){
						return false;
					}
					else{
						set.add(c);
					}
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
