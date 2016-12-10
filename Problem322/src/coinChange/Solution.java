package coinChange;

import java.util.*;

public class Solution {
	
	public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length == 0){
        	return -1;
        }
        HashSet<Integer> coinSet = new HashSet<Integer>();
		for(int i=0;i<coins.length;i++){
			coinSet.add(coins[i]);
		}
		int[] table = new int[amount+1];
		table[0] = 0;
		for(int i=1;i<=amount;i++){
			if(coinSet.contains(i)){
				table[i] = 1;
				continue;
			}
			int minNum = Integer.MAX_VALUE;
			boolean hasSolution = false;
			for(int j=0;j<coins.length;j++){
				if(coins[j]<i && table[i-coins[j]] != -1 && table[i-coins[j]]+1<minNum){
					hasSolution = true;
					minNum = table[i-coins[j]]+1;
				}
			}
			if(!hasSolution){
				table[i] = -1;
			}
			else{
				table[i] = minNum;
			}
		}
        
		return table[amount];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int[] coins = {1,2,5};
		//int amount = 11;
		int[] coins = {2};
		int amount = 3;		
		System.out.println(sol.coinChange(coins, amount));

	}

}
