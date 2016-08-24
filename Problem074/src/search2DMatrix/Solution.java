package search2DMatrix;

public class Solution {

	public boolean searchMatrix(int[][] matrix, int target){
		//search target in the 2d matrix
		//each row in the matrix is in ascending order
		//the first element of each row is greater than the last element in the last row

		if(matrix == null || matrix.length==0)
			return false;

		int m = matrix.length;
		int n = matrix[0].length;

		int length = m*n;

		int start = 0;
		int end = length-1;
		int middle = 0;
		int row = 0;
		int col = 0;
		while(start<=end){
			//middle point
			middle = (start+end)/2;
			//convert middle point in one dimension to two dimensions
			row = middle/n;
			col = middle%n;
			if(matrix[row][col] == target){
				return true;
			}
			else if(matrix[row][col] < target){
				start = middle+1;
			}
			else{
				end = middle-1;
			}
		}

		return false;
	}

	public boolean searchMatrix2(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int length = m*n;
		int left = 0, right = length-1, mid;
		int rowIndex, colIndex;
		while(left<=right){
			mid = (left+right)/2;
			rowIndex = mid/n;
			colIndex = mid%n;
			if(matrix[rowIndex][colIndex] == target){
				return true;
			}
			else if(matrix[rowIndex][colIndex] < target){
				left = mid+1;
			}
			else{
				right = mid-1;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,3,5,7}, {10,11,16,20}, {23,30,34,50}};
		int target = 11;

		Solution sol = new Solution();
		System.out.println(sol.searchMatrix2(matrix, target));


	}

}
