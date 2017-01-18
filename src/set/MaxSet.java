package set;

import java.util.NoSuchElementException;
import java.util.Iterator;


public class MaxSet<E extends Comparable<E>> extends ArraySet<E> {
	private E maxElement;
	
	/**
	 * Constructs a new empty set.
	 */
	public MaxSet() {
		super();
	}
	
	/** Returns the currently largest element in this set. 
	pre: the set is not empty 
	post: the set is unchanged 
	@return the currently largest element in this set 
	@throws NoSuchElementException if this set is empty 
	*/ 
	public E getMax() {
		if(maxElement == null){
			throw new NoSuchElementException("The set is empty.");
		}
		return maxElement;
	}
	
	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		boolean result = super.add(x);
		try {
		if (result && x.compareTo(maxElement) > 0)
			maxElement = x;
		} catch(NullPointerException e) {
			//Borde bara hamna här om maxElement är null.
			//Om x är null tror vi att add returnerar false.
			maxElement = x;
		}
		return result;
	}
	
	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {
		if(super.remove(x)){
			if (x.equals(maxElement)) {
				maxElement = newMax();
			}
			return true;
		}
		return false;
	}
	
	
	private E newMax(){
		Iterator<E> it = super.iterator();
		E currentMax = null;
		if(it.hasNext()) {
			currentMax = it.next();

			while (it.hasNext()) {
				E current = it.next();
				if (current.compareTo(currentMax) > 0) {
					currentMax = current;
				}
			}
		}
		return currentMax;
	}
	
	/** Adds all of the elements in the specified set, for which it is 
	possible, to this set. 
	post: all elements, for which it is possible, in the 
	specified set are added to this set. 
	@return true if this set changed as a result of the call 
	*/
	public boolean addAll(SimpleSet<? extends E> c) {
		boolean result = false;
		for(E e: c) {
			if (add(e)) result = true;
		}
		return result;
	}
	
}
