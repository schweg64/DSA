package list;

/**
 * A ListIterator specifically for LinkedLists
 * @author Ryan Schwegel
 * @author sdb
 * @version Sept 2020
 */
public class RefListIterator<E> 
	extends RefIterator<E> 
	implements ListIterator<E>{
	
	/*
	 * cursor, in the superclass, is a reference
	 * to the last value returned by a call
	 * to next() or previous().
	 */
	private boolean forward = true;
	
	RefListIterator(LinkedList<E> list){
		super(list);
	}
	
	// @param start is starting position for iteration
	RefListIterator(LinkedList<E> list, int start){
		super(list);
		for(int i = 0; i<start; i++)
			cursor = cursor.next;
	}
	
	public boolean hasNext() {
		if(list.isEmpty())
			return false;
		if(forward)
			return cursor.next != list.tail;
		return true;
	}
	
	public E next() {
		if (forward)
			cursor = cursor.next;
		forward = true;
		return cursor.value;
	}
	
	public boolean hasPrevious() {
		if(!forward)
			return cursor.prev != list.head;
		return cursor != list.head;
	}
	
	public E previous() {
		if (!forward)
			cursor = cursor.prev;
		forward = false;
		return cursor.value;
	}
	
	public void remove() {
		super.remove();
		if(forward) {
			cursor = cursor.prev;
		} else {
			cursor = cursor.next;
		}
	}
	
	public void add(E value) {
		if(forward) {
			//cursor represents the value before the implicit cursor
			Node<E> temp = new Node<E>(value, cursor.next, cursor);
			cursor.next.prev = temp;
			cursor.next = temp; 
			cursor = temp;
		} else { 
			//cursor represents the value after the implicit cursor
			Node<E> temp = new Node<E>(value, cursor, cursor.prev);
			cursor.prev.next = temp;
			cursor.prev = temp; 
		}

		list.size++;
	}
}
