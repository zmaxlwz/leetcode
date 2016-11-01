package summaryRanges2;

import java.util.*;

public class Solution {

	public List<String> summaryRanges(int[] nums){
		List<String> result = new ArrayList<String>();
		List<Range> ranges = new ArrayList<Range>();
		if(nums == null || nums.length == 0){
			return result;
		}

		int length = nums.length;
		int lastNum = nums[0];
		Range range = new Range();
		range.start = nums[0];
		for(int i=1;i<length;i++){
			if(nums[i] == lastNum+1){
				lastNum++;
			}
			else{
				range.end = lastNum;
				ranges.add(range);
				range = new Range();
				range.start = nums[i];
				lastNum = nums[i];
			}
		}
		range.end = lastNum;
		ranges.add(range);
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
		int[] nums = {0,1,2,4,5,7};
		List<String> list = sol.summaryRanges(nums);
		System.out.println(list);

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

