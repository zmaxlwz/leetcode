package candy;

public class Solution {

	public int candy(int[] ratings){
		//each child is given a rating
		//give candies to children such that 
		//1. each child has at least 1 candy
		//2. child with higher rating will get more candies than their neighbors
		//return the minimum total candies needed
		
		if(ratings == null || ratings.length==0){
			return 0;
		}
		
		//scan twice, once from left to right and search for increasing sequence
		//the second time from right to left and search for increasing sequence
		int length = ratings.length;
		int[] left = new int[length];
		int[] right = new int[length];
		
		left[0] = 1;
		for(int i=1;i<length;i++){
			if(ratings[i]>ratings[i-1]){
				left[i] = left[i-1]+1;
			}
			else{
				left[i] = 1;
			}
		}
		
		right[length-1] = 1;
		for(int i=length-2;i>=0;i--){
			if(ratings[i]>ratings[i+1]){
				right[i] = right[i+1]+1;
			}
			else{
				right[i] = 1;
			}
		}
		
		int minCandies = 0;
		for(int i=0;i<length;i++){
			minCandies += Math.max(left[i], right[i]);
		}
		
		return minCandies;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] ratings = {1,2,4,3,2,1,5};
		Solution sol = new Solution();
		System.out.println(sol.candy(ratings));

	}

}
