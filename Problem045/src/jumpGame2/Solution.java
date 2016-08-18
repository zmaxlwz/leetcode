package jumpGame2;

public class Solution {

	public int jumpNaive(int[] nums){
		//each element in nums represents the max lengths can be jumped from here
		//compute the minimum number of jumps to reach the last index
		//******this method time complexity is O(n^2), time limit exceeded******

		if(nums == null || nums.length<=1)
			return 0;

		int length = nums.length;
		//the min steps to reach each element
		int[] minSteps = new int[length];

		for(int i=0;i<length;i++){
			minSteps[i] = Integer.MAX_VALUE;
		}

		int jumpLength;
		minSteps[0] = 0;
		//compute minSteps for each element
		for(int i=0;i<length;i++){
			jumpLength = nums[i];
			for(int j=1;j<=jumpLength;j++){
				if(i+j>=length)
					break;
				minSteps[i+j] = Math.min(minSteps[i+j], minSteps[i]+1);
				if(i+j==length-1)
					return minSteps[length-1];
			}			
		}

		return minSteps[length-1];
	}

	public int jump(int[] nums){
		//this method maintains the max cover so far with count steps

		if(nums == null || nums.length<=1)
			return 0;

		int length = nums.length;
		int start = 0;
		int end = 0;
		int count = 0;
		int max = 0;

		while(end<length){
			//the number of steps
			count++;
			max = 0;
			for(int i = start;i<=end;i++){
				if(i + nums[i] >= length-1)
					return count;
				if(i + nums[i] > max)
					max = i+nums[i];

			}
			start = end+1;
			end = max;
			if(start>end){
				return -1;
			}

		}

		return count;
	}

	public int jump2(int[] nums){
		if(nums == null || nums.length<=1){
			return 0;
		}
		int length = nums.length;
		int start = 0;
		int end = 0;
		int max = 0;
		int count = 0;
		while(start<=end){
			count++;
			for(int i=start;i<=end;i++){
				if(nums[i] + i > max){
					max = nums[i] + i;
				}

			}
			if(max>=length-1){
				return count;
			}
			start = end+1;
			end = max;
		}
		return -1;
	}

	public int jump3(int[] nums){
		if(nums == null || nums.length <= 1){
			return 0;
		}
		int length = nums.length;
		int start = 0, end = 0;
		int count = 0;
		int maxPosition = 0;
		while(start<=end){
			count++;
			for(int i =start;i<=end;i++){
				if(i+nums[i]>maxPosition){
					maxPosition = i+nums[i];
				}
			}
			if(maxPosition>=length-1){
				return count;
			}
			start = end+1;
			end = maxPosition;
		}
		return -1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {2,3,1,1,4};
		Solution sol = new Solution();
		System.out.println(sol.jump3(nums));
	}

}
