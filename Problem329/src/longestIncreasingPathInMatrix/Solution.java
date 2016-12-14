package longestIncreasingPathInMatrix;



public class Solution {

	public int longestIncreasingPath(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int maxLength = 0;
		int len = 0;
		boolean[][] visited = new boolean[numRows][numCols];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				//System.out.println(i + ", " + j);
				len = findPathLength(matrix, i, j, visited);
				if(len>maxLength){
					maxLength = len;
				}
			}
		}
		return maxLength;
	}

	public int findPathLength(int[][] matrix, int i, int j, boolean[][] visited){
		System.out.println(i + ", " + j);
		visited[i][j] = true;
		int maxLength = 1;
		int len = 0;
		if(i-1>=0 && !visited[i-1][j] && matrix[i-1][j] > matrix[i][j]){
			len = findPathLength(matrix, i-1, j, visited) + 1;
			if(len>maxLength){
				maxLength = len;
			}
		}
		if(i+1<matrix.length && !visited[i+1][j] && matrix[i+1][j] > matrix[i][j]){
			len = findPathLength(matrix, i+1, j, visited) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		if(j-1 >= 0 && !visited[i][j-1] && matrix[i][j-1] > matrix[i][j]){
			len = findPathLength(matrix, i, j-1, visited) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		if(j+1 < matrix[0].length && !visited[i][j+1] && matrix[i][j+1] > matrix[i][j]){
			len = findPathLength(matrix, i, j+1, visited) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		visited[i][j] = false;
		return maxLength;
	}

	public int longestIncreasingPath2(int[][] matrix) {
		//DFS with memorization
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int maxLength = 0;
		int len = 0;
		int[][] lenCache = new int[numRows][numCols];
		for(int i=0;i<numRows;i++){
			for(int j=0;j<numCols;j++){
				//System.out.println(i + ", " + j);
				len = findPathLength2(matrix, i, j, lenCache);
				if(len>maxLength){
					maxLength = len;
				}
			}
		}
		return maxLength;
	}

	public int findPathLength2(int[][] matrix, int i, int j, int[][] lenCache){
		//System.out.println(i + ", " + j);
		if(lenCache[i][j] > 0){
			return lenCache[i][j];
		}
		int maxLength = 1;
		int len = 0;
		if(i-1>=0 && matrix[i-1][j] > matrix[i][j]){
			len = findPathLength2(matrix, i-1, j, lenCache) + 1;
			if(len>maxLength){
				maxLength = len;
			}
		}
		if(i+1<matrix.length && matrix[i+1][j] > matrix[i][j]){
			len = findPathLength2(matrix, i+1, j, lenCache) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]){
			len = findPathLength2(matrix, i, j-1, lenCache) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		if(j+1 < matrix[0].length && matrix[i][j+1] > matrix[i][j]){
			len = findPathLength2(matrix, i, j+1, lenCache) + 1;
			if(len > maxLength){
				maxLength = len;
			}
		}
		lenCache[i][j] = maxLength;
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		//int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
		//int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
		int[][] matrix = {{0,1,2,3,4,5,6,7,8,9},{19,18,17,16,15,14,13,12,11,10},{20,21,22,23,24,25,26,27,28,29},{39,38,37,36,35,34,33,32,31,30},{40,41,42,43,44,45,46,47,48,49},{59,58,57,56,55,54,53,52,51,50},{60,61,62,63,64,65,66,67,68,69},{79,78,77,76,75,74,73,72,71,70},{80,81,82,83,84,85,86,87,88,89},{99,98,97,96,95,94,93,92,91,90},{100,101,102,103,104,105,106,107,108,109},{119,118,117,116,115,114,113,112,111,110},{120,121,122,123,124,125,126,127,128,129},{139,138,137,136,135,134,133,132,131,130},{0,0,0,0,0,0,0,0,0,0}};
		System.out.println(sol.longestIncreasingPath2(matrix));

	}

}
