package insertDeleteGetRandom2;

import java.util.*;

public class RandomizedCollection {
	
	HashMap<Integer, HashSet<Integer>> map;
	List<Integer> dataList;
	Random ran;
	
	/** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, HashSet<Integer>>();
        dataList = new ArrayList<Integer>();
        ran = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contains = map.containsKey(val);
        dataList.add(val);
        if(!contains){
         	map.put(val, new HashSet<Integer>());
        }
        map.get(val).add(dataList.size()-1);
        
        if(contains){
        	return false;
        }
        else{
        	return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val)){
    		return false;
    	}
    	int index = 0;
    	for(Integer i: map.get(val)){
    		index = i;
    		break;
    	}
    	if(index != dataList.size()-1){
    		//System.out.println(index);
    		int lastElem = dataList.get(dataList.size()-1);
    		if(lastElem == val){
    			index = dataList.size()-1;
    		}
    		else{
    			dataList.set(index, lastElem);
        		HashSet<Integer> set = map.get(lastElem);
        		set.remove(dataList.size()-1);
        		set.add(index);
    		}
    		
    	}
    	dataList.remove(dataList.size()-1);
    	map.get(val).remove(index);
    	if(map.get(val).size()==0){
    		map.remove(val);
    	}
    	
    	return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int ranNum = ran.nextInt(dataList.size());
    	
    	return dataList.get(ranNum);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RandomizedCollection rc = new RandomizedCollection();
		rc.insert(0);
		rc.insert(1);
		rc.insert(2);
		rc.insert(3);
		rc.insert(3);
		
		rc.remove(2);
		rc.remove(3);
		rc.remove(0);
		
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		System.out.println(rc.getRandom());
		
	}

}
