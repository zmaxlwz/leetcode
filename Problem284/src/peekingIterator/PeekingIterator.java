package peekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	
	Integer peekedItem;
	boolean hasPeeked;
	Iterator<Integer> iter;
	
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		
		peekedItem = null;
		hasPeeked = false;
		iter = iterator;
		
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		
		if(!hasPeeked){
			peekedItem = iter.next();
			hasPeeked = true;
		}
        return peekedItem;
        
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(hasPeeked){
	    	hasPeeked = false;
	    	return peekedItem;
	    }
	    else{
	    	return iter.next();
	    }
	}

	@Override
	public boolean hasNext() {
	    return hasPeeked || iter.hasNext();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
