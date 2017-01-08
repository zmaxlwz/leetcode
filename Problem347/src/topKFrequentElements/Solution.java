package topKFrequentElements;

import java.util.*;

public class Solution {
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int length = nums.length;
		for(int i=0;i<length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}
			else{
				map.put(nums[i], map.get(nums[i])+1);
			}
		}
		PriorityQueue<Element> pq = new PriorityQueue<Element>();
		for(Integer num: map.keySet()){
			pq.offer(new Element(num, map.get(num)));
			if(pq.size()>k){
				pq.poll();
			}			
		}
		List<Integer> result = new ArrayList<Integer>();
		while(!pq.isEmpty()){
			result.add(0, pq.poll().num);
		}
		
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Element implements Comparable<Element>{
	int num;
	int times;
	Element(int n, int t){
		num = n;
		times = t;
	}
	
	public int compareTo(Element that){
		return this.times - that.times;
	}
}

