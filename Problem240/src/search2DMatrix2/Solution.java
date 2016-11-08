package search2DMatrix2;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target){
		if(matrix==null || matrix.length==0){
			return false;
		}
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		int i = 0;
		int j = numCol-1;
		while(i<=numRow-1 && j>=0){
			if(matrix[i][j] == target){
				return true;
			}
			else if(matrix[i][j] < target){
				i++;
			}
			else{
				j--;
			}
		}
		return false;
	}

	public boolean searchMatrix2(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int i = 0;
		int j = numCols-1;
		boolean isFound = false;
		while(i < numRows && j >= 0){
			if(matrix[i][j] == target){
				isFound = true;
				break;
			}
			else if(matrix[i][j] < target){
				i = i + 1;
			}
			else{
				j = j - 1;
			}
		}  
		return isFound;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
