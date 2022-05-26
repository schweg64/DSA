package queue;

/**
 * A first in first out List.
 * @author Ryan Schwegel
 * @author sdb
 */
public interface QueueADT<E> {
	/**
	 * Add the given value at the back of this QueueADT
	 */
	void add (E value);
	
	/**
	 * Remove the value which is at the front of this QueueADT
	 * @return The value which was removed.
	 * Pre: This QueueADT is not empty.
	 */
	E remove();
	
	/**
	 * @return the value which is at the front of this QueueADT
	 * or null if this QueueADT is empty.
	 */
	E peek();
	
	/**
	 * @return true iff the queue is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Clears this QueueADT.
	 */
	void clear();
	
	/**
	 * Prints this QueueADT as a String.
	 */
	String toString();
	
	/**
	 * @return the size of this QueueADT
	 */
	int size();
}
