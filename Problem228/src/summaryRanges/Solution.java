package summaryRanges;

import java.util.*;

public class Solution {

	public List<String> summaryRanges(int[] nums){
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length==0){
			return result;
		}

		int length = nums.length;
		String range = String.valueOf(nums[0]);
		int pre = nums[0];
		int count = 1;
		for(int i=1;i<length;i++){
			if(nums[i] == pre+1){
				count++;
				pre = nums[i];
			}
			else{
				if(count==1){
					result.add(range);
					range = String.valueOf(nums[i]);
					pre = nums[i];	
				}
				else{
					range += "->" + String.valueOf(pre);
					result.add(range);
					range = String.valueOf(nums[i]);
					pre = nums[i];
					count = 1;
				}
			}
		}

		if(count==1){
			result.add(range);

		}
		else{
			range += "->" + String.valueOf(pre);
			result.add(range);

		}
		return result;	

	}

	public List<String> summaryRanges2(int[] nums){
		List<String> result = new ArrayList<String>();
		if(nums==null || nums.length==0){
			return result;
		}
		int length = nums.length;
		int num = nums[0];
		String range = String.valueOf(nums[0]);
		boolean hasNextNum = false;
		for(int i =1;i<length;i++){
			if(nums[i] == num+1){
				if(!hasNextNum){
					range = range + "->";
				}
				hasNextNum = true;
				num = nums[i];				
			}
			else{
				if(hasNextNum){
					range = range + String.valueOf(num);	
				}
				result.add(range);
				hasNextNum = false;
				num = nums[i];
				range = String.valueOf(nums[i]);

			}
		}
		if(hasNextNum){
			range = range + String.valueOf(num);	
		}
		result.add(range);
		return result;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,2,4,5,7};
		Solution sol = new Solution();
		System.out.println(sol.summaryRanges2(nums));

	}

}
