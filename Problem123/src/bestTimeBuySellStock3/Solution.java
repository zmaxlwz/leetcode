package bestTimeBuySellStock3;

public class Solution {

	public int maxProfit(int[] prices){
		//return the max profit of at most 2 transactions
		//the input is an array of prices

		if(prices == null || prices.length==0){
			return 0;
		}

		//use dynamic programming, two 1d tables
		//one table records the max profit of one transaction on the left side of each day
		//the other table records the max profit of one transaction on the right side of each day

		int length = prices.length;
		int[] leftMaxProfit = new int[length];
		int[] rightMaxProfit = new int[length];

		//the max profit on the left of each day
		int maxProfit = 0;
		int minPrice = prices[0];
		leftMaxProfit[0] = maxProfit;
		for(int i=1;i<length;i++){
			if(prices[i]-minPrice > maxProfit){
				maxProfit = prices[i] - minPrice;
			}
			leftMaxProfit[i] = maxProfit;
			if(prices[i] < minPrice){
				minPrice = prices[i];
			}
		}

		//the max profit on the right of each day
		maxProfit = 0;
		int maxPrice = prices[length-1];
		rightMaxProfit[length-1] = maxProfit;
		for(int i=length-2;i>=0;i--){
			if(maxPrice - prices[i] > maxProfit){
				maxProfit = maxPrice-prices[i];
			}
			rightMaxProfit[i] = maxProfit;
			if(prices[i] > maxPrice){
				maxPrice = prices[i];
			}
		}

		int maxTotalProfit = 0;
		for(int i=0;i<length;i++){
			if(leftMaxProfit[i]+rightMaxProfit[i]>maxTotalProfit){
				maxTotalProfit = leftMaxProfit[i]+rightMaxProfit[i];
			}
		}

		return maxTotalProfit;
	}

	public int maxProfit2(int[] prices){
		if(prices == null || prices.length <=1){
			return 0;
		}
		int length = prices.length;
		int[] leftSideMaxProfit = new int[length];
		int[] rightSideMaxProfit = new int[length];
		leftSideMaxProfit[0] = 0;
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i =1;i<length;i++){
			if(prices[i] - minPrice > maxProfit){
				maxProfit = prices[i] - minPrice;
			}
			leftSideMaxProfit[i] = maxProfit;
			minPrice = Math.min(minPrice, prices[i]);
		}
		rightSideMaxProfit[length-1] = 0;
		int maxPrice = prices[length-1];
		maxProfit = 0;
		for(int j=length-2;j>=0;j--){
			if(maxPrice - prices[j] > maxProfit){
				maxProfit = maxPrice - prices[j];
			}
			rightSideMaxProfit[j] = maxProfit;
			maxPrice = Math.max(maxPrice, prices[j]);
		}
		maxProfit = 0;
		for(int i =0;i<length;i++){
			if(leftSideMaxProfit[i] + rightSideMaxProfit[i] > maxProfit){
				maxProfit = leftSideMaxProfit[i] + rightSideMaxProfit[i];
			}
		}
		return maxProfit;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] prices = {1,4,5,7,6,3,2,9};
		Solution sol = new Solution();
		System.out.println(sol.maxProfit(prices));

	}

}
