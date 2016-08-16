package mergeIntervals;

import java.util.Comparator;

public class IntervalComparator implements Comparator<Interval>{

	public int compare(Interval i1, Interval i2){
		
		if(i1.start > i2.start)
			return 1;
		else if(i1.start == i2.start)
			return 0;
		else{
			return -1;
		}
	}

}

