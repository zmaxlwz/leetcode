package missingRanges;

import java.util.*;

public class Solution {

	public List<String> findMissingRanges(int[] nums, int lower, int upper){
		List<String> result = new ArrayList<String>();
		if(nums == null || nums.length == 0){
			result.add(String.valueOf(lower) + "->" + String.valueOf(upper));
			return result;
		}
		int length = nums.length;
		List<Range> ranges = new ArrayList<Range>();
		if(nums[0]>lower){
			ranges.add(new Range(lower, nums[0]-1));
		}
		for(int i =1;i<length;i++){
			if(nums[i] == nums[i-1]+1){
				continue;
			}
			ranges.add(new Range(nums[i-1]+1, nums[i]-1));
		}
		if(nums[length-1] <upper){
			ranges.add(new Range(nums[length-1]+1, upper));
		}
		for(Range ran: ranges){
			if(ran.start == ran.end){
				result.add(String.valueOf(ran.start));
			}
			else{
				result.add(String.valueOf(ran.start) + "->" + String.valueOf(ran.end));
			}
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums = {0,1,3,50,75};
		int lower = 0;
		int upper = 99;
		System.out.println(sol.findMissingRanges(nums, lower, upper));

	}

}

class Range{
	int start;
	int end;
	Range(){
		start = 0;
		end = 0;
	}
	Range(int s, int e){
		start = s;
		end = e;
	}
}
