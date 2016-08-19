package rotateImage;

public class Solution {

	public void rotate(int[][] matrix){
		//rotate the n*n image by 90 degrees clockwise
		//do it in-place
		
		if(matrix == null || matrix.length==0){
			return;
		}
		
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		
		//row number is not equal to column number
		if(rowNum != colNum)
			return;
		
		//first swap according to up diagnal
		for(int i=0;i<rowNum-1;i++){
			for(int j=0;j<colNum-1-i;j++){
				//swap m[i,j] with m[len-1-j, len-1-i]
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rowNum-1-j][colNum-1-i];
				matrix[rowNum-1-j][colNum-1-i] = temp;
			}
		}
				
		//then swap according to x middle line
		for(int i=0;i<rowNum/2;i++){
			for(int j=0;j<colNum;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[rowNum-1-i][j];
				matrix[rowNum-1-i][j] = temp;
			}
		}
				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}	
		Solution sol = new Solution();
		sol.rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		
	}

}
