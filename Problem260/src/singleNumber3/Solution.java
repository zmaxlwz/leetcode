package singleNumber3;

import java.util.*;

public class Solution {

	public int[] singleNumber(int[] nums){
		//not correct
		// 3^5 == 1^7
		if(nums == null || nums.length <2){
			return null;
		}
		int[] result = new int[2];
		int length = nums.length;
		int n = 0;
		for(int i =0;i<length;i++){
			n = n^nums[i];
		}
		//System.out.println(n);
		
		int m;
		for(int i =0;i<length;i++){
			m = n^nums[i];
			if((n^m)==nums[i]){
				//System.out.println(nums[i]);
				//System.out.println(m);
				result[0] = nums[i];
				result[1] = m;
				break;
			}
		}
		return result;
	}
	
	public int[] singleNumber2(int[] nums){
		if(nums == null || nums.length <2){
			return null;
		}
		int[] result = new int[2];
		int length = nums.length;
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<length;i++){
			if(!set.contains(nums[i])){
				set.add(nums[i]);
			}
			else{
				set.remove(nums[i]);
			}
		}
		int i=0;
		for(Integer n: set){
			result[i++] = n;
		}
		return result;
	}
	
	public int[] singleNumber3(int[] nums){
		
		if(nums == null || nums.length <2){
			return null;
		}
		int[] result = new int[2];
		int length = nums.length;
		int n = 0;
		for(int i =0;i<length;i++){
			n = n^nums[i];
		}
		//System.out.println(n);
		
		int m=0;
		for(m = 0;m<32;m++){
			if(((n>>m)&1)>0){
				break;
			}
		}
		
		int num0 = 0;
		int num1 = 0;
		for(int i=0;i<length;i++){
			if(((nums[i]>>m)&1)==0){
				num0 = num0^nums[i];
			}
			else{
				num1 = num1^nums[i];
			}
		}
		result[0] = num0;
		result[1] = num1;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {1,2,1,3,2,5};
		Solution sol = new Solution();
		int[] result = sol.singleNumber3(nums);
		System.out.println(result[0]);
		System.out.println(result[1]);

	}

}
