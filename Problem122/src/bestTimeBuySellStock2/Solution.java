package bestTimeBuySellStock2;

public class Solution {

	public int maxProfit(int[] prices){
		//the input array is the stock prices for the days
		//return the max profit
		//you can do as many transaction as you want
		
		if(prices == null || prices.length == 0){
			return 0;
		}
		
		//add each one day increase
		int maxProfit = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1]){
				maxProfit += prices[i] - prices[i-1];
			}
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
