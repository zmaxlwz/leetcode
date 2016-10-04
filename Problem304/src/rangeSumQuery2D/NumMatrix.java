package rangeSumQuery2D;

public class NumMatrix {
	
	int[][] accumSumMatrix;
	
	public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        	accumSumMatrix = new int[0][0];
        	return;
        }
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		accumSumMatrix = new int[numRows+1][numCols+1];
		for(int i=0;i<=numRows;i++){
			accumSumMatrix[i][0] = 0;
		}
		for(int j=0;j<=numCols;j++){
			accumSumMatrix[0][j] = 0;
		}
		for(int i=1;i<=numRows;i++){
			for(int j=1;j<=numCols;j++){
				accumSumMatrix[i][j] = accumSumMatrix[i-1][j]+accumSumMatrix[i][j-1]-accumSumMatrix[i-1][j-1]+matrix[i-1][j-1];
				
			}
		}
		return;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        
    	int sum = accumSumMatrix[row2+1][col2+1]-accumSumMatrix[row1][col2+1]-accumSumMatrix[row2+1][col1]+accumSumMatrix[row1][col1];
    	
    	return sum;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
