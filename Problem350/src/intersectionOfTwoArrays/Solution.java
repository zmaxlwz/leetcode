package intersectionOfTwoArrays;

import java.util.*;

public class Solution {
	
	public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
        	return new int[0];
        }
		
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> intersectionMap = new HashMap<Integer, Integer>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        for(int i=0;i<length1;i++){
        	if(!map1.containsKey(nums1[i])){
        		map1.put(nums1[i], 1);
        	}
        	else{
        		map1.put(nums1[i], map1.get(nums1[i])+1);
        	}
        }
        int size = 0;
        for(int i=0;i<length2;i++){
        	if(map1.containsKey(nums2[i])){
        		if(!intersectionMap.containsKey(nums2[i])){
        			intersectionMap.put(nums2[i], 1);
        			size++;
        		}
        		else if(map1.get(nums2[i])>intersectionMap.get(nums2[i])){
        			intersectionMap.put(nums2[i], intersectionMap.get(nums2[i])+1);
        			size++;
        		}
        	}
        }
        int[] intersectionArray = new int[size];
        int index = 0;
        for(Integer n: intersectionMap.keySet()){
        	int count = intersectionMap.get(n);
        	for(int j=0;j<count;j++){
        		intersectionArray[index++] = n;
        	}
        }
		return intersectionArray;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		int[] intersection = sol.intersect(nums1, nums2);
		for(int i=0;i<intersection.length;i++){
			System.out.print(intersection[i] + ", ");
		}
		System.out.println();
	}

}
