package insertDeleteGetRandom;

import java.util.*;

public class RandomizedSet {
	
	HashMap<Integer, Integer> map;
	List<Integer> dataList;
	Random ran;
	
	/** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        dataList = new ArrayList<Integer>();
        ran = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
        	return false;
        }
    	dataList.add(val);
    	map.put(val, dataList.size()-1);
    	
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
        	return false;
        }
    	int index = map.get(val);
    	if(index != dataList.size()-1){
    		int lastElem = dataList.get(dataList.size()-1);
    		dataList.set(index, lastElem);
    		map.put(lastElem, index);
    	}
    	map.remove(val);
    	dataList.remove(dataList.size()-1);
    	
    	return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = ran.nextInt(dataList.size());
    	
    	return dataList.get(index);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
