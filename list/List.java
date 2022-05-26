package list;

/**
 * An adt representing a collection in which duplicates
 * are allowed and order matters
 * @author Ryan Schwegel
 * @author sdb
 * @version September 6 2020
 * @param <E>
 */

public interface List <E>{

	/**
	 * @return the value at the given index in this list. 
	 * @param 0 <= ndx < size
	 */
	E get (int ndx);
	
	/**
	 * Sets the value at the given index to
	 * 		the given value.
	 * @return the old value.
	 * @param 0 <= ndx < size
	 */
	E set (int ndx, E value);
	
	/**
	 * Add the given value at the end of this list.
	 */
	void add (E value);
	
	/**
	 * Insert the given value at the given index in this list
	 * @param 0 <= ndx <= size
	 */
	void add (int ndx, E value);
	
	/**
	 * Remove the value at the given index from this list.
	 * @return the value which was removed
	 * @param 0 <= ndx < size
	 */
	E remove (int ndx);
	
	/**
	 * @return the size of this list.
	 */
	int size();
	
	/**
	 * Removes all elements from this list.
	 */
	void clear();
	
	/**
	 * @return true iff this list is empty
	 */
	boolean isEmpty();
	
	/** @return the position of the first occurrence of obj in this List, or -1 if not found */
	int indexOf(Object obj);

	/** @return true iff the given Object is in this List */
	boolean contains (Object obj);
	
	/**  Remove the first occurrence of obj from this List, if possible.
    @return true iff obj was removed.
	 */
	boolean remove(Object obj);
	
	/**
	 * @return an Iterator for this List
	 */
	Iterator<E> iterator();
	
	/**
	 * @return true iff this List is equal to the parameter.
	 * Precondition: obj is a List
	 */
	boolean equals(Object obj);
	
	/**
	 * @return a list iterator for this list
	 */
	ListIterator<E> listIterator();
	
	/**
	 * @return a ListIterator for this List.
	 * @param start iterating at given start position.
	 * Initial call to previous() returns the value
	 * at position start-1
	 */
	ListIterator<E> listIterator(int start);
	
	/**
	 * Adds all components from given list to this list
	 * @param list list to be added to this list.
	 */
	void addAll(List<E> list);
}
