package list;

/**
 * An ITerator which can go to the previous value as well as
 * the next value
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
public interface ListIterator<E> extends Iterator<E> {
	/*
	 * Implicit cursor
	 * a  b   c  d
	 *      ^
	 * next() -> c
	 * previous() -> b
	 */
	
	/**
	 * @return true only if there is a previous value.
	 */
	boolean hasPrevious();
	
	/**
	 * @return the previous value, and move the implicit 
	 * cursor to the left.
	 */
	public E previous();
	
	/**
	 * The remove operation, inherited from Iterator, will always
	 * remove the last value obtained by a call to next() or previous()
	 * Pre: remove may be called no more than once between successive calls to
	 * next() or previous().
	 */
	
	/** Add the given value at the implicit cursor position in the List which is being iterated.
    Post:  The implicit cursor will be immediately AFTER the added value.  A subsequent call to previous() will return the added value.
	 */
	void add(E value);
}
