package trapRainWater;

public class Solution {

	public int trap(int[] height){
		//height array includes the height of each bar
		//compute the amount of water that can be trapped

		if(height == null || height.length<=2)
			return 0;

		//there are more than 2 bars(3 or more)
		//the max height of bars to the left of each bar
		int[] leftMax = new int[height.length];
		//the max height of bars to the right of each bar
		int[] rightMax = new int[height.length];

		//fill leftMax array
		int maxHeight = 0;
		for(int i=0;i<height.length;i++){
			leftMax[i] = maxHeight;
			maxHeight = Math.max(maxHeight, height[i]);
		}
		//fill rightMax array
		maxHeight = 0;
		for(int i=height.length-1;i>=0;i--){
			rightMax[i] = maxHeight;
			maxHeight = Math.max(maxHeight, height[i]);
		}

		//for each bar i, the amount of water can be trapped is 
		//max(min(leftMax[i], rightMax[i]) - height[i], 0)
		int totalAmount = 0;
		int waterAmount = 0;
		for(int i=0;i<height.length;i++){
			waterAmount = Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
			totalAmount += waterAmount;
		}

		return totalAmount;
	}

	public int trap2(int[] height){
		if(height == null || height.length == 0){
			return 0;
		}
		int length = height.length;
		int[] leftMax = new int[length];
		int[] rightMax = new int[length];
		int max = 0;
		for(int i =0;i<length;i++){
			leftMax[i] = max;
			if(height[i]>max){
				max = height[i];
			}
		}
		max = 0;
		for(int i =length-1;i>=0;i--){
			rightMax[i] = max;
			if(height[i]>max){
				max = height[i];
			}
		}
		int amount = 0;
		for(int i =0;i<length;i++){
			int val = Math.min(leftMax[i], rightMax[i]) - height[i];
			if(val>0){
				amount = amount + val;
			}
		}
		return amount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		Solution sol = new Solution();
		System.out.println(sol.trap2(height));
	}

}
