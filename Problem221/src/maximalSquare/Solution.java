package maximalSquare;

public class Solution {

	public int maximalSquare(char[][] matrix){
		if(matrix == null || matrix.length==0){
			return 0;
		}

		int numRow = matrix.length;
		int numCol = matrix[0].length;
		int[][] table = new int[numRow][numCol];
		int maxLength = 0;
		for(int i=0;i<numCol;i++){
			if(matrix[0][i] == '0'){
				table[0][i] = 0;
			}
			else{
				table[0][i] = 1;
				if(maxLength<1){
					maxLength = 1;
				}
			}
		}
		for(int i = 0;i<numRow;i++){
			if(matrix[i][0] == '0'){
				table[i][0] = 0;
			}
			else{
				table[i][0] = 1;
				if(maxLength<1){
					maxLength = 1;
				}
			}
		}
		for(int i=1;i<numRow;i++){
			for(int j=1;j<numCol;j++){
				if(matrix[i][j] == '0'){
					table[i][j] = 0;
				}
				else{
					int minValue = Math.min(table[i][j-1], table[i-1][j]);
					minValue = Math.min(minValue, table[i-1][j-1]);
					table[i][j] = minValue+1;
					if(table[i][j] > maxLength){
						maxLength = table[i][j];
					}
				}
			}
		}

		return maxLength*maxLength;
	}

	public int maximalSquare2(char[][] matrix){
		if(matrix == null || matrix.length==0 || matrix[0].length==0){
			return 0;
		}
		int numRow = matrix.length;
		int numCol = matrix[0].length;
		int[][] table = new int[numRow][numCol];
		int maxEdge = 0;
		for(int i =0;i<numRow;i++ ){
			if(matrix[i][0] == '0'){
				table[i][0] = 0;
			}
			else{
				table[i][0] = 1;
				maxEdge = 1;
			}
		}
		for(int j = 0;j<numCol; j++){
			if(matrix[0][j] == '0'){
				table[0][j] = 0;
			}
			else{
				table[0][j] = 1;
				maxEdge = 1;
			}
		}
		for(int i=1;i<numRow;i++){
			for(int j=1;j<numCol;j++){
				if(matrix[i][j] == '0'){
					table[i][j] = 0;
				}
				else{
					table[i][j] = 1+Math.min(Math.min(table[i-1][j-1], table[i-1][j]), table[i][j-1]);
					if(table[i][j] > maxEdge){
						maxEdge = table[i][j];
					}
				}
			}
		}
		return maxEdge*maxEdge;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] matrix = {{'1','0','1','0','0'},{'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1','0','0','1','0'}};
		Solution sol = new Solution();
		System.out.println(sol.maximalSquare2(matrix));
	}

}
