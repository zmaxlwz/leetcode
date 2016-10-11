package numberOfOneBits;

public class Solution {

	public int hammingWeight(int n){
		//return the number of ‘1’ bits in n
		if(n == 0){
			return 0;
		}
		int count = 0;
		for(int i=0;i<32;i++){
			if((n & 1) == 1){
				count++;
			}
			n = n>>1;
		}
		return count;
	}

	public int hammingWeight2(int n){
		int count = 0;
		for(int i=0;i<32;i++){
			if((n&1) > 0){
				count++;
			}
			n = n>>1;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 11;
		Solution sol = new Solution();
		System.out.println(sol.hammingWeight(n));

	}

}
