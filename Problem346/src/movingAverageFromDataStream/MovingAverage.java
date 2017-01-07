package movingAverageFromDataStream;

import java.util.*;

public class MovingAverage {
	
	LinkedList<Integer> queue;
	double sum;
	int windowSize;
	
	/** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        sum = 0;
        windowSize = size;
    }
    
    public double next(int val) {
        
    	if(queue.size() < windowSize){
    		queue.offer(val);
    		sum += val;
    		return sum/queue.size();
    	}
    	else{
    		int elem = queue.poll();
    		queue.offer(val);
    		sum = sum - elem + val;
    		return sum/windowSize;
    	}
    	
    }
    
    public static void main(String[] args){
    	
    }

}
