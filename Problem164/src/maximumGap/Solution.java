package maximumGap;

public class Solution {

	public int maximumGap(int[] nums){

		if(nums == null || nums.length<2){
			return 0;
		}

		int length = nums.length;
		int maxNum = Integer.MIN_VALUE;
		int minNum = Integer.MAX_VALUE;
		for(int i=0;i<length;i++){
			if(nums[i] > maxNum){
				maxNum = nums[i];
			}
			if(nums[i] < minNum){
				minNum = nums[i];
			}
		}

		if(maxNum == minNum){
			return 0;
		}

		//divide all numbers into n+1 groups
		//get max and min in each group
		int[] max = new int[length+1];
		int[] min = new int[length+1];
		double interval = (double)(maxNum+1-minNum)/(length+1);

		for(int i=0;i<=length;i++){
			max[i] = -1;
			min[i] = -1;
		}

		for(int i=0;i<length;i++){
			int groupNum = (int)Math.floor((nums[i]-minNum)/interval);
			//System.out.println(groupNum);
			if(min[groupNum] == -1){
				min[groupNum] = nums[i];
			}
			else if(nums[i]<min[groupNum]){
				min[groupNum] = nums[i];
			}

			if(max[groupNum] == -1){
				max[groupNum] = nums[i];
			}
			else if(nums[i] > max[groupNum]){
				max[groupNum] = nums[i];
			}
		}

		int maxGap = Integer.MIN_VALUE;
		int lastMax = -1;
		int thisMin = -1;
		for(int i=0;i<=length;i++){
			if(max[i] == -1){
				continue;
			}
			if(lastMax == -1){
				lastMax = max[i];
				continue;
			}
			thisMin = min[i];
			if(thisMin-lastMax>maxGap){
				maxGap = thisMin-lastMax;
			}
			lastMax = max[i];
		}

		return maxGap;
	}

	public int maximumGap2(int[] nums){
		if(nums == null || nums.length <2){
			return 0;
		}
		int length = nums.length;
		int minNum = Integer.MAX_VALUE;
		int maxNum = Integer.MIN_VALUE;
		for(int i=0;i<length;i++){
			if(nums[i] < minNum){
				minNum = nums[i];
			}
			if(nums[i] > maxNum){
				maxNum = nums[i];
			}
		}
		if(minNum==maxNum){
			return 0;
		}
		int groupNum = length+1;
		double groupLen = (maxNum-minNum)*1.0/groupNum;
		int[] min = new int[groupNum];
		int[] max = new int[groupNum];
		boolean[] empty = new boolean[groupNum];
		for(int i=0;i<groupNum;i++){
			min[i] = Integer.MAX_VALUE;
			max[i] = Integer.MIN_VALUE;
			empty[i] = true;
		}
		int element;
		int groupIndex;
		for(int i=0;i<length;i++){
			element = nums[i];
			if(element == maxNum){
				groupIndex = groupNum - 1;
			}
			else{
				groupIndex = (int)((element-minNum)*1.0/groupLen);
			}
			if(element>max[groupIndex]){
				max[groupIndex] = element;
			}
			if(element<min[groupIndex]){
				min[groupIndex] = element;
			}
			empty[groupIndex] = false;

		}
		int start = max[0];
		int end; 
		int maxGap = Integer.MIN_VALUE;
		for(int i=1;i<groupNum;i++){
			if(empty[i]){
				continue;
			}
			else{
				end = min[i];
			}
			if(end-start>maxGap){
				maxGap = end-start;
			}
			start = max[i];
		}
		return maxGap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {8,11,1,3,5,10};
		Solution sol = new Solution();
		System.out.println(sol.maximumGap(nums));

	}

}
