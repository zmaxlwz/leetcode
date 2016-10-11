package reverseBits;

public class Solution {

	public int reverseBits(int n){
		//treat n as an unsigned integer
		int result = 0;
		for(int i=0;i<32;i++){
			result = result << 1;
			if((n & 1) == 1){
				result += 1;

			}
			n = n>>1;
		}

		return result;
	}

	public int reverseBits2(int n){

		int left = 31;
		int right = 0;
		while(left>right){
			int a = (n>>left) & 1;
			int b = (n>>right) & 1;
			if(a != b){
				n = n ^ ((1<<left) | (1<<right));
			}
			left--;
			right++;
		}
		return n;
	}

	public int reverseBits3(int n){
		int result = 0;
		for(int i=0;i<32;i++){
			result = result <<1;
			result += n&1;
			n = n>>1;
		}
		return result;
	}

	public int reverseBits4(int n){
		int left = 31;
		int right = 0;
		while(left > right){
			int a = (n>>left)&1;
			int b = (n>>right)&1;
			if(a != b){
				n ^= (1<<left) | (1<<right);
			}
			left--;
			right++;
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 43261596;
		Solution sol = new Solution();
		System.out.println(sol.reverseBits4(n));

	}

}
