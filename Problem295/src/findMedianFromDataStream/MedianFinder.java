package findMedianFromDataStream;

import java.util.*;

public class MedianFinder {
	
	PriorityQueue<Integer> lowerHalf;
	PriorityQueue<Integer> higherHalf;
	
	public MedianFinder(){
		lowerHalf = new PriorityQueue<Integer>(100, new maxComparator());
		higherHalf = new PriorityQueue<Integer>();
	}
	
	// Adds a number into the data structure.
    public void addNum(int num) {
        if(lowerHalf.isEmpty()){
        	lowerHalf.offer(num);
        	return;
        }
        else if(higherHalf.isEmpty()){
        	if(num>=lowerHalf.peek()){
        		higherHalf.offer(num);
        	}
        	else{
        		lowerHalf.offer(num);
        		higherHalf.offer(lowerHalf.poll());
        	}
        	return;
        }
        //int m1 = lowerHalf.peek();
        int m2 = higherHalf.peek();
        if(num>=m2){
        	higherHalf.offer(num);
        	if(higherHalf.size()>lowerHalf.size()){
        		lowerHalf.offer(higherHalf.poll());
        	}
        }
        else{
        	lowerHalf.offer(num);
        	if(lowerHalf.size()>higherHalf.size()+1){
        		higherHalf.offer(lowerHalf.poll());
        	}
        }
        return;
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(lowerHalf.isEmpty()){
        	return 0;
        }
        if(lowerHalf.size()>higherHalf.size()){
        	return (double)lowerHalf.peek();
        }
        else{
        	return ((double)lowerHalf.peek()+(double)higherHalf.peek())/2;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MedianFinder mf = new MedianFinder();
		mf.addNum(2);
		mf.addNum(3);
		System.out.println(mf.findMedian());
		mf.addNum(4);
		System.out.println(mf.findMedian());
	}

}

class maxComparator implements Comparator<Integer>{
	
	public int compare(Integer a, Integer b){
		return b-a;
	}
}