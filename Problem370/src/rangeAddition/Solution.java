package rangeAddition;

public class Solution {
	
	public int[] getModifiedArray(int length, int[][] updates) {
		
		int[] result = new int[length];
		if(updates == null || updates.length == 0){
			return result;
		}
		
		int numUpdates = updates.length;
		for(int i=0;i<numUpdates;i++){
			int startIndex = updates[i][0];
			int endIndex = updates[i][1];
			int inc = updates[i][2];
			result[endIndex] += inc;
			if(startIndex > 0){
				result[startIndex-1] -= inc;
			}
		}
		
		int update = 0;
		for(int i=length-1;i>=0;i--){
			result[i] += update;
			update = result[i];
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int length = 5;
		int[][] updates = {{1,3,2}, {2,4,3}, {0,2,-2}};
		
		int[] result = sol.getModifiedArray(length, updates);
		for(int i=0;i<length;i++){
			System.out.print(result[i] + ", ");
		}
		System.out.println();
		
	}

}
