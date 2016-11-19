package perfectSquare;

public class Solution {
	
	public int numSquares(int n) {
		
		int[] numSquare = new int[n];
		//numSquare[0] = 1;
		for(int num=1;num<=n;num++){
			int leastNum = Integer.MAX_VALUE;
			for(int i=1;i*i<=num;i++){
				if(num-i*i==0){
					leastNum = 1;
					break;
				}
				else{
					if(numSquare[num-i*i-1]+1<leastNum){
						leastNum = numSquare[num-i*i-1]+1;
					}
				}
			}
			numSquare[num-1] = leastNum;
		}
				
		return numSquare[n-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int n = 13;
		int num = sol.numSquares(n);
		System.out.println(num);
	}

}
