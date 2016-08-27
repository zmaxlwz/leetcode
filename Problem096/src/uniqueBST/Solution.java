package uniqueBST;

public class Solution {

	public int numTrees(int n){
		//return the number of dynamic BST for 1,2,...,n
		//use dynamic programming

		if(n<=1){
			return 1;
		}

		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		for(int i=2;i<=n;i++){
			table[i] = 0;
			for(int j=1;j<=i;j++){
				table[i] += table[j-1]*table[i-j];
			}
		}

		return table[n];
	}

	public int numTrees2(int n){
		if(n<=0){
			return 0;
		}
		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		for(int i =2;i<=n;i++){
			table[i] = 0;
			for(int rootIndex=1;rootIndex<=i;rootIndex++){
				int numLeftTrees = table[rootIndex-1];
				int numRightTrees = table[i-rootIndex];
				table[i] += numLeftTrees*numRightTrees;
			}
		}
		return table[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 3;
		Solution sol = new Solution();
		System.out.println(sol.numTrees2(n));

	}

}
