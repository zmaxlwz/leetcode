package patchingArray;

import java.util.*;

public class Solution {
	
	public int minPatches(int[] nums, int n) {
		//this is O(n^2) algorithm, fails the test
		
		List<Long> sumList = new ArrayList<Long>();
		sumList.add(0L);
		HashSet<Long> set = new HashSet<Long>();
		set.add(0L);
		if(nums != null && nums.length > 0){
			
			for(int i=0;i<nums.length;i++){
				int len = sumList.size();
				for(int j=0;j<len;j++){
					if(!set.contains(sumList.get(j)+nums[i])){
						sumList.add(sumList.get(j)+nums[i]);
						set.add(sumList.get(j)+nums[i]);
					}
					
				}
			}
		}
		//System.out.println(sumList);
		
		System.out.println(sumList);
		System.out.println(set);
		int numPatches = 0;
		for(long i=1;i<=n;i++){
			if(set.contains(i)){
				continue;
			}
			numPatches++;
			
			//System.out.println(numPatches);
			System.out.println(i);
			
			int len = sumList.size();
			for(int j=0;j<len;j++){
				Long sum = sumList.get(j)+i;
				if(!set.contains(sum)){
					sumList.add(sum);
					set.add(sum);
				}
				
			}
		}
		return numPatches;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		//int[] nums = {1,3};
		//int n = 6;
		//int[] nums = {1,5,10};
		//int n = 20;
		//int[] nums = {1,2,2};
		//int n = 5;
		int[] nums = {1,2,31,33};
		int n = 2147483647;
		
		System.out.println(sol.minPatches(nums, n));
		//System.out.println(Integer.MAX_VALUE);

	}

}
