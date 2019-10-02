/*
Author: Akhilesh Borgaonkar
Approach: I am maintaining a cache variable which basically gets the integer at next pointer before hand.
	Whenever the peek() function is called, the cache variable is returned without having to access the iterator.
Time Complexity: O(1) for peek and next methods
Space Complexity: O(1)
LC verified
*/

class PeekingIterator implements Iterator<Integer> {
    
    Integer cache = null;   //variable to store the next integer
    Iterator<Integer> iter; //local iterator
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator;
        
        if(iter.hasNext())
            cache = iter.next();    //storing the next integer for peek functionality
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cache;       //here we return the stored next integer
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer temp = cache;   //storing next integer to return
        if(iter.hasNext())
            cache = iter.next();    //resetting the next integer storage
        else
            cache = null;       //if next integer not present then set to null
        
        return temp;
	}

	@Override
	public boolean hasNext() {
        return cache!=null;         //if the storage doesn't have integer that means no next integer present
	}
}