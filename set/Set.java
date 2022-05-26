package set;
import list.Iterator;
/** A collection with no duplicates. Ordering of the values
 * need not be maintained
 * @author Ryan Schwegel
 * @author sdb
 */
public interface Set<E> {
	/** @return true iff this Set contains the given object.
	 */
	boolean contains(Object obj);
	
	/** Add the given value to this Set, if not already in this Set.
	 * @return true iff it was added.
	 */
	boolean add(E value);
	
	/** Remove the given object from this Set, if possible.
	 * @return true iff it was removed
	 */
	boolean remove(Object obj);
	
	/** @return an Iterator for this Set */
	Iterator<E> iterator();
	
	/** @return the size of this Set */
	int size();
	
	/** Clears this Set */
	void clear();
	
	/** @return true iff this Set is empty */
	boolean isEmpty();
	
	/** @return the Set of values which this Set has in
	  * common with otherSet
	  */
	public Set<E> intersection (Set<E> otherSet);
}
