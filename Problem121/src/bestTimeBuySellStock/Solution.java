package bestTimeBuySellStock;

public class Solution {

	public int maxProfit(int[] prices){
		//the input is an array of prices
		//at most one transaction is permitted
		//return the max profit

		if(prices == null || prices.length==0){
			return 0;
		}

		int minPrice = prices[0];
		int maxProfit = 0;

		for(int i=1;i<prices.length;i++){
			if(prices[i] - minPrice > maxProfit){
				maxProfit = prices[i] - minPrice;
			}
			if(prices[i]<minPrice){
				minPrice = prices[i];
			}
		}

		return maxProfit;
	}

	public int maxProfit2(int[] prices){
		if(prices == null || prices.length<=1){
			return 0;
		}	
		int length = prices.length;
		int[] profit = new int[length-1];
		for(int i=1;i<length;i++){
			profit[i-1] = prices[i]-prices[i-1];
		}
		int[] table = new int[length-1];
		table[0] = profit[0];
		int maxProfit = 0;
		if(maxProfit < table[0]){
			maxProfit = table[0];
		}
		for(int i=1;i<length-1;i++){
			if(table[i-1]<=0){
				table[i] = profit[i];
			}
			else{
				table[i] = table[i-1]+profit[i];
			}
			if(table[i]>maxProfit){
				maxProfit = table[i];
			}
		}
		return maxProfit;
	}

	public int maxProfit3(int[] prices){
		if(prices == null || prices.length <=1){
			return 0;
		}
		int length = prices.length;
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i =1;i<length;i++){
			if(prices[i]-minPrice > maxProfit){
				maxProfit = prices[i]-minPrice;
			}
			minPrice = Math.min(minPrice, prices[i]);
		}
		return maxProfit;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
