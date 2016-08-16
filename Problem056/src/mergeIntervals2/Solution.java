package mergeIntervals2;

import java.util.*;

public class Solution {

	public List<Interval> merge(List<Interval> intervals){
		if(intervals == null || intervals.size()<=1){
			return intervals;
		}
		Collections.sort(intervals, new IntervalComparator());
		List<Interval> result = new ArrayList<Interval>();
		Interval lastInterval = intervals.get(0);
		int length = intervals.size();
		for(int i =1;i<length;i++){
			Interval current = intervals.get(i);
			if(current.start<=lastInterval.end){
				lastInterval = new Interval(lastInterval.start, Math.max(lastInterval.end, current.end));
			}
			else{
				result.add(lastInterval);
				lastInterval = current;
			}
		}
		result.add(lastInterval);
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i4);
		list.add(i2);
		list.add(i3);
		list.add(i1);
		System.out.println(list);
		
		Solution sol = new Solution();
		System.out.println(sol.merge(list));

	}

}

class IntervalComparator implements Comparator<Interval>{
	public int compare(Interval v1, Interval v2){
		return v1.start - v2.start;
	}
}

