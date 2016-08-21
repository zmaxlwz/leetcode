package spiralMatrix2;

public class Solution {

	public int[][] generateMatrix(int n){
		//generate a n*n square matrix with integer from 1~n^2 in spiral order
		
		int[][] result = new int[n][n];
		
		if(n<=0)
			return result;
				
		int value = 1;
		int x = 0;
		int y = 0;
		
		while(n>0){
			if(n==1){
				result[x][y] = value;
				return result;
			}
			for(int i=0;i<n-1;i++){
				result[x][y++] = value++;
			}
			for(int i=0;i<n-1;i++){
				result[x++][y] = value++;
			}
			for(int i=0;i<n-1;i++){
				result[x][y--] = value++;
			}
			for(int i=0;i<n-1;i++){
				result[x--][y] = value++;
			}
			
			x = x + 1;
			y = y + 1;
			n = n - 2;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4; 
		
		Solution sol = new Solution();
		int[][] matrix = sol.generateMatrix(n);
		for(int i = 0; i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		
		

	}

}
