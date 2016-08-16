package spiralMatrix;

import java.util.*;

public class Solution {

	public List<Integer> spiralOrder(int[][] matrix){
		//traverse the elements in matrix in spiral order, and add it to list

		List<Integer> result = new ArrayList<Integer>();

		if(matrix == null || matrix.length == 0)
			return result;

		//m is row number, n is column number
		int m = matrix.length;
		int n = matrix[0].length;

		//x,y is the row index and column index for current element
		int x=0;
		int y=0;

		while(m>0 && n>0){
			if(m == 1){
				//only one row left, print this row
				for(int i=0;i<n;i++){
					result.add(matrix[x][y++]);
				}
				break;
			}
			else if(n == 1){
				//only one column left, print this column
				for(int i=0;i<m;i++){
					result.add(matrix[x++][y]);
				}
				break;
			}

			//more than 1 row and more than 1 row exists, there are circles
			for(int i=0;i<n-1;i++){
				result.add(matrix[x][y++]);
			}

			for(int i=0;i<m-1;i++){
				result.add(matrix[x++][y]);
			}

			for(int i=0;i<n-1;i++){
				result.add(matrix[x][y--]);
			}

			for(int i=0;i<m-1;i++){
				result.add(matrix[x--][y]);
			}

			x = x+1;
			y = y+1;
			m = m-2;
			n = n-2;
		}

		return result;
	}

	public List<Integer> spiralOrder2(int[][] matrix){
		List<Integer> result = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return result;
		}
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int x = 0, y=0;
		while(numRows>0 && numCols>0){
			if(numRows == 1){
				for(int i =0;i<numCols;i++){
					result.add(matrix[x][y]);
					y++;
				}
				break;
			}
			if(numCols == 1){
				for(int i =0;i<numRows;i++){
					result.add(matrix[x][y]);
					x++;
				}
				break;
			}

			for(int j =0;j<numCols-1;j++){
				result.add(matrix[x][y]);
				y++;
			}
			for(int i =0;i<numRows-1;i++){
				result.add(matrix[x][y]);
				x++;
			}
			for(int j =0;j<numCols-1;j++){
				result.add(matrix[x][y]);
				y--;
			}
			for(int i =0;i<numRows-1;i++){
				result.add(matrix[x][y]);
				x--;
			}
			x++;
			y++;
			numRows = numRows-2;
			numCols = numCols-2;
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
		Solution sol = new Solution();
		System.out.println(sol.spiralOrder2(matrix));

	}

}
