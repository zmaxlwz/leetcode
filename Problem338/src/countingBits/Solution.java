package countingBits;

public class Solution {
	
	public int[] countBits(int num) {
		int[] result = new int[num+1];
		result[0] = 0;
		int len = 1;
		int index = 1;
		while(len*2<=num+1){
			for(int i=0;i<len;i++){
				result[index++] = result[i]+1;
			}
			len = len*2;
		}
		int i = 0;
		while(index<=num){
			result[index++] = result[i++]+1;
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int num = 2;
		int[] result = sol.countBits(num);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i] + ", ");
		}
		System.out.println();
	}

}
