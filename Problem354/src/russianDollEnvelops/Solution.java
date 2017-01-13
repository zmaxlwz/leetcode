package russianDollEnvelops;

import java.util.*;

public class Solution {
	
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0){
			return 0;
		}
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		int length = envelopes.length;
		for(int i=0;i<length;i++){
			int[] envelope = envelopes[i];
			List<Integer> list = new ArrayList<Integer>();
			list.add(envelope[0]);
			list.add(envelope[1]);
			lists.add(list);
		}
		Collections.sort(lists, new ListComparator());
		HashMap<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
		for(int i=0;i<length;i++){
			List<Integer> list1 = lists.get(i);
			int maxCount = 1;
			for(int j=0;j<i;j++){
				List<Integer> list2 = lists.get(j);
				if(list2.get(0) < list1.get(0) && list2.get(1) < list1.get(1)){
					if(map.get(list2)+1 > maxCount){
						maxCount = map.get(list2)+1;
					}
				}
			}
			map.put(list1, maxCount);
		}
		int maxSize = 0;
		for(List<Integer> list: map.keySet()){
			if(map.get(list)>maxSize){
				maxSize = map.get(list);
			}
		}
		
		return maxSize;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Solution sol = new Solution();
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(sol.maxEnvelopes(envelopes));

	}

}


class ListComparator implements Comparator<List<Integer>>{
	
	public int compare(List<Integer> l1, List<Integer> l2){
		return l1.get(0) - l2.get(0);
	}
}