package bitwiseAndNumbersRange;

import java.util.*;

public class Solution {

	public int rangeBitwiseAnd(int m, int n){
		//return the bitwise and of number within [m,n]

		if(m==0){
			return 0;
		}

		if(m==n){
			return m;
		}

		int result = m;
		for(int i=m+1;i<=n;i++){
			result = result & i;
		}
		return result;
	}

	public int rangeBitwiseAnd2(int m, int n){
		//compute the bitwise and result of numbers within [m,n]
		if(m==0 || n==0){
			return 0;
		}
		List<Integer> bitPosList = new ArrayList<Integer>();
		int n1 = n;
		int p = 1;
		while(n1>0){
			bitPosList.add(p);
			p++;
			n1 = n1/2;
		}
		for(int num=m;num<=n;num++){
			for(int i = bitPosList.size()-1;i>=0; i--){
				int c = bitPosList.get(i);
				if(((num>>(c-1)) & 1) ==0){
					bitPosList.remove(i);
				}
			}

		}
		if(bitPosList.isEmpty()){
			return 0;
		}
		
		int result = 0;
		for(int i =0;i< bitPosList.size();i++){
			result += (1<<( bitPosList.get(i)-1));
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m = 5;
		int n = 7;
		Solution sol = new Solution();
		System.out.println(sol.rangeBitwiseAnd2(m, n));		

	}

}
