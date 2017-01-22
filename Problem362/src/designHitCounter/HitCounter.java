package designHitCounter;

import java.util.*;

public class HitCounter {
	
	List<Integer> timeList;
	HashMap<Integer, Integer> timeHitsMap;
	int totalHits;
	
	/** Initialize your data structure here. */
    public HitCounter() {
        this.timeList = new ArrayList<Integer>();
        this.timeHitsMap = new HashMap<Integer, Integer>();
        this.totalHits = 0;
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        
    	if(this.timeHitsMap.containsKey(timestamp)){
    		this.timeHitsMap.put(timestamp, this.timeHitsMap.get(timestamp)+1);    		
    	}
    	else{
    		this.timeHitsMap.put(timestamp, 1);
    		this.timeList.add(timestamp); 
    	}
    	this.totalHits++;
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        
    	if(this.timeList.size() == 0){
    		return 0;
    	}
    	
    	int firstTimestamp = this.timeList.get(0);
    	while(timestamp - firstTimestamp >= 300){
    		this.timeList.remove(0);
    		this.totalHits -= this.timeHitsMap.get(firstTimestamp);
    		this.timeHitsMap.remove(firstTimestamp);
    		if(this.timeList.size()==0){
    			break;
    		}
    		else{
    			firstTimestamp = this.timeList.get(0);
    		}
    	}
    	
    	return this.totalHits;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
