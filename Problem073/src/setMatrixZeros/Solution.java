package setMatrixZeros;

public class Solution {

	public void setZeroes(int[][] matrix){
		//if an element in the matrix is 0, than set the whole row and whole column to 0
		//only use constant space

		if(matrix == null || matrix.length==0)
			return;

		//number of rows
		int m = matrix.length;
		//number of columns
		int n = matrix[0].length;

		//use the first row and first column as indicator

		//
		boolean firstRowZero = false;
		for(int j=0;j<n;j++){
			if(matrix[0][j] == 0){
				firstRowZero = true;
				break;
			}
		}
		boolean firstColumnZero = false;
		for(int i=0;i<m;i++){
			if(matrix[i][0] == 0){
				firstColumnZero = true;
				break;
			}
		}

		//check other elements, set first row and first column
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j]==0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		//set  other elements according to first row and first column
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][0]==0 || matrix[0][j]==0){
					matrix[i][j] = 0;
				}
			}
		}
		//set first row if firstRowZero == true
		if(firstRowZero){
			for(int j=0;j<n;j++){
				matrix[0][j] = 0;
			}
		}
		//set first column if firstColumnZero == true
		if(firstColumnZero){
			for(int i=0;i<m;i++){
				matrix[i][0] = 0;
			}
		}

		return;
	}

	public void setZeroes2(int[][] matrix){
		if(matrix == null || matrix.length==0 || matrix[0].length == 0){
			return;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		boolean firstRowZero = false;
		for(int j=0;j<n;j++){
			if(matrix[0][j] == 0){
				firstRowZero = true;
			}
		}
		boolean firstColumnZero = false;
		for(int i =0;i<m;i++){
			if(matrix[i][0] == 0){
				firstColumnZero = true;
			}
		}
		for(int i =1;i<m;i++){
			for(int j=1;j<n;j++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for(int i =1;i<m;i++){
			if(matrix[i][0] == 0){
				for(int j=1;j<n;j++){
					matrix[i][j] = 0;
				}
			}
		}
		for(int j=1;j<n;j++){
			if(matrix[0][j] == 0){
				for(int i =1;i<m;i++){
					matrix[i][j] = 0;
				}
			}
		}
		if(firstRowZero){
			for(int j=0;j<n;j++){
				matrix[0][j] = 0;
			}
		}
		if(firstColumnZero){
			for(int i =0;i<m;i++){
				matrix[i][0] = 0;
			}
		}
		return;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
