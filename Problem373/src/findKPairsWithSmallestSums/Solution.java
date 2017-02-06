package findKPairsWithSmallestSums;

import java.util.*;

public class Solution {
	
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0){
        	return result;
        }
		int length1 = nums1.length;
		int length2 = nums2.length;
		PriorityQueue<Element> pq = new PriorityQueue<Element>(length2);
		for(int j=0;j<length2;j++){
			pq.offer(new Element(nums1[0]+nums2[j], 0, j));
		}
		for(int i=0;i<k;i++){
			if(pq.isEmpty()){
				break;
			}
			Element elem = pq.poll();
			int[] pair = new int[2];
			pair[0] = nums1[elem.index1];
			pair[1] = nums2[elem.index2];
			result.add(pair);
			if(elem.index1<length1-1){
				pq.offer(new Element(nums1[elem.index1+1]+nums2[elem.index2], elem.index1+1, elem.index2));
			}
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Element implements Comparable<Element>{
	int sumVal;
	int index1;
	int index2;
	Element(int sum, int i, int j){
		sumVal = sum;
		index1 = i;
		index2 = j;
	}
	
	public int compareTo(Element that){
		return this.sumVal - that.sumVal;
	}
}


