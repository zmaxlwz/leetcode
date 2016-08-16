package mergeIntervals;

import java.util.*;

public class Solution {

	public List<Interval> merge(List<Interval> intervals){
		//given a list of intervals, merge overlapping intervals 
		//return the remaining intervals
		
		if(intervals == null || intervals.size() <=1)
			return intervals;
		
		IntervalComparator comp = new IntervalComparator();
		//sort the list of intervals according to their start positions in ascending order
		Collections.sort(intervals, comp);
		
		List<Interval> result = new ArrayList<Interval>();
		
		//get the first interval
		Interval pre = intervals.get(0);
		Interval current;
		for(int i=1;i<intervals.size();i++){
			current = intervals.get(i);
			if(current.start > pre.end){
				//no overlap
				result.add(pre);
				pre = current;
			}
			else{
				//there is overlap
				pre.end = Math.max(pre.end, current.end);
			}
			
		}
		
		result.add(pre);
		
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
