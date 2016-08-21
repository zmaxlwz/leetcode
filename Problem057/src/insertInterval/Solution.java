package insertInterval;

import java.util.*;

public class Solution {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		//insert a new interval into a list of intervals, merge if necessary
		//the original list is sorted according to the start time
		//method1

		List<Interval> result = new ArrayList<Interval>();

		if(intervals == null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}

		int length = intervals.size();
		for(int i=0;i<length;i++){
			if(newInterval.start < intervals.get(i).start){
				intervals.add(i, newInterval);
				break;
			}
		}
		if(intervals.size() == length){
			//not add in
			intervals.add(length, newInterval);

		}
		length = intervals.size();

		//merge intervals
		Interval pre = intervals.get(0);
		Interval current;
		for(int i=1;i<length;i++){
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

	public List<Interval> insert1(List<Interval> intervals, Interval newInterval){
		//method2

		List<Interval> result = new ArrayList<Interval>();

		if(intervals == null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}

		//compare each interval in the list with newInterval, merge if possible
		Interval current;
		boolean isInserted = false;
		for(int i=0;i<intervals.size();i++){
			current = intervals.get(i);
			if(isInserted){
				result.add(current);
				continue;
			}
			if(current.end< newInterval.start){
				//no overlap
				result.add(current);
			}
			else if(newInterval.end < current.start){
				//no overlap
				result.add(newInterval);				
				isInserted = true;
				result.add(current);
			}
			else{
				//there is overlap, merge current to newInterval
				newInterval.start = Math.min(newInterval.start, current.start);
				newInterval.end = Math.max(newInterval.end, current.end);
			}
		}

		if(!isInserted){
			result.add(newInterval);
		}

		return result;
	}

	public List<Interval> insert2(List<Interval> intervals, Interval newInterval){	
		if(newInterval == null){
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		int length = intervals.size();
		boolean isInserted = false;
		for(int i =0;i<length;i++){
			Interval v = intervals.get(i);
			if(isInserted){
				result.add(v);
				continue;
			}
			if(overlap(v, newInterval)){
				newInterval = new Interval(Math.min(v.start, newInterval.start), Math.max(v.end, newInterval.end));
			}
			else{
				if(v.end < newInterval.start){
					result.add(v);
				}
				else{
					result.add(newInterval);
					isInserted = true;
					result.add(v);
				}
			}
		}
		if(!isInserted){
			result.add(newInterval);
		}
		return result;
	}

	public boolean overlap(Interval v1, Interval v2){
		int startMax = Math.max(v1.start, v2.start);
		int endMin = Math.min(v1.end, v2.end);
		if(startMax<=endMin){
			return true;
		}
		else{
			return false;
		}
	}

	public List<Interval> insert3(List<Interval> intervals, Interval newInterval){	
		if(newInterval == null){
			return intervals;
		}
		List<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		int length = intervals.size();
		boolean isInserted = false;
		for(int i =0;i<length;i++){
			Interval v = intervals.get(i);
			if(isInserted){
				result.add(v);
				continue;
			}
			if(v.end < newInterval.start){
				result.add(v);
			}
			else if(newInterval.end < v.start){
				result.add(newInterval);
				isInserted = true;
				result.add(v);
			}
			else{
				newInterval = new Interval(Math.min(v.start, newInterval.start), Math.max(v.end, newInterval.end));
			}

		}
		if(!isInserted){
			result.add(newInterval);
		}
		return result;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,9);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		Interval newInterval = new Interval(2,5);
		 */

		Interval i1 = new Interval(1,2);
		Interval i2 = new Interval(3,5);
		Interval i3 = new Interval(6,7);
		Interval i4 = new Interval(8,10);
		Interval i5 = new Interval(12,16);
		List<Interval> list = new ArrayList<Interval>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		list.add(i4);
		list.add(i5);
		Interval newInterval = new Interval(4,9);
		System.out.println(list);

		Solution sol = new Solution();
		System.out.println(sol.insert3(list, newInterval));

	}

}
