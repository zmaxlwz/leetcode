package intersectionOfTwoArrays;

import java.util.*;

public class Solution {
	
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
			return new int[0];
		}
		int length1 = nums1.length;
		int length2 = nums2.length;
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> intersectionSet = new HashSet<Integer>();
		for(int i=0;i<length1;i++){
			set1.add(nums1[i]);
		}
		for(int i=0;i<length2;i++){
			if(set1.contains(nums2[i])){
				intersectionSet.add(nums2[i]);
			}
		}
		int size = intersectionSet.size();
		int[] result = new int[size];
		int index = 0;
		for(Integer n: intersectionSet){
			result[index++] = n;
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] intersection = sol.intersection(nums1, nums2);
		for(int i=0;i<intersection.length;i++){
			System.out.print(intersection[i] + ", ");
		}
		System.out.println();
	}

}
