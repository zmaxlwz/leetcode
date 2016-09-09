package longestConsecutiveSequence;

import java.util.*;

public class Solution {

	public int longestConsecutive(int[] nums){
		//return the length of the longest consecutive sequence in nums
		//for instance, given [100, 4, 200, 1, 3, 2], return 4

		if(nums == null || nums.length==0){
			return 0;
		}

		//use a HashSet
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<nums.length;i++){
			set.add(nums[i]);			
		}

		HashSet<Integer> firstElementSet = new HashSet<Integer>();
		int maxLength = 0;
		for(int i=0;i<nums.length;i++){
			if(!set.contains(nums[i]-1)){
				//nums[i] is the first element in a sequence
				if(!firstElementSet.contains(nums[i])){
					//not checked before
					firstElementSet.add(nums[i]);
					//count length
					int length = 1;
					int number = nums[i]+1;
					while(set.contains(number)){
						length++;
						number++;
					}
					if(length>maxLength){
						maxLength = length;
					}
				}
			}
		}

		return maxLength;
	}

	public int longestConsecutive2(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
		}
		int maxLength = 0;
		for(int i=0;i<length;i++){
			int num = nums[i];
			int seqlength = 0;
			while(set.contains(num)){
				seqlength++;
				set.remove(num);
				num--;
			}
			num = nums[i]+1;
			while(set.contains(num)){
				seqlength++;
				set.remove(num);
				num++;
			}
			if(seqlength>maxLength){
				maxLength = seqlength;
			}
		}
		return maxLength;
	}

	public int longestConsecutive3(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i =0;i<length;i++){
			set.add(nums[i]);
		}
		int maxLength = 0;
		int seqLength = 0;
		for(int i =0; i<length;i++){
			if(!set.contains(nums[i]-1)){
				seqLength = findLength(nums[i], set);
				if(seqLength > maxLength){
					maxLength = seqLength;
				}
			}
		}
		return maxLength;
	}

	public int findLength(int num, HashSet<Integer> set){
		int length = 1;
		while(set.contains(num+1)){
			length++;
			num++;
		}
		return length;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {100,4,200,1,3,2};
		Solution sol = new Solution();
		System.out.println(sol.longestConsecutive3(nums));

	}

}
