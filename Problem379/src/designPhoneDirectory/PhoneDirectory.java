package designPhoneDirectory;

import java.util.*;

public class PhoneDirectory {
	
	HashSet<Integer> set;

	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
		
		set = new HashSet<Integer>();
		for(int i=0;i<maxNumbers;i++){
			set.add(i);
		}
		
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {

		if(set.size() == 0){
			return -1;
		}
		Iterator<Integer> iter = set.iterator();
		
		Integer num = iter.next();
		set.remove(num);
		
		return num;
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {

		if(set.contains(number)){
			return true;
		}
		else{
			return false;
		}
		
	}

	/** Recycle or release a number. */
	public void release(int number) {

		set.add(number);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
