package queue;

import list.LinkedList;
import list.List;

/**
 * An implementation of the QueueADT interface,
 * using a LinkedList
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
public class Queue<E> implements QueueADT<E> {
	List<E> values = new LinkedList<E>();
	
	//front is at position 0     (head)
	//back is at position size-1 (tail)
	public void add (E value) {
		values.add(value);
	}
	
	public E remove() {
		return values.remove(0);
	}
	
	public E peek() {
		if(values.isEmpty())
			return null;
		return values.get(0);
	}
	
	public boolean isEmpty() {
		return values.size() == 0;
	}
	
	public void clear() {
		values.clear();
	}
	
	public String toString() {
		return values.toString();
	}
	
	public int size() {
		return values.size();
	}
}
