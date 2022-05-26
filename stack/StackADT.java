package stack;

/**
 * A Stack is a last in first out List.
 * Access is limited to the 'top' of the stack.
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
public interface StackADT<E> {
	/**
	 * Add the given value at the top fo the stack
	 * @return the value which was pushed.
	 */
	E push(E value);
	
	/**
	 * Remove the value at the top of this StackADT
	 * @return the value removed
	 * Pre: This StackADT is not empty.
	 */
	E pop();
	
	/**
	 * @return the value at the top of this StackADT.
	 * Pre: This StackADT is not empty.
	 */
	E peek();
	
	/**
	 * @return true iff this StackADT is empty.
	 */
	boolean isEmpty();
	
	/**
	 * Clears this StackADT
	 */
	void clear();
	
	/**
	 * Prints this StackADT as a String
	 */
	String toString();
}
