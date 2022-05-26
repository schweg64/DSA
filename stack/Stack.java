package stack;
import list.ArrayList;
import list.List;
import list.LinkedList;
/**
 * An implementation of the StackADT interface using a List.
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
public class Stack<E> implements StackADT<E> {

	List<E> values = new ArrayList<E>();
	
	/**
	 * Default constructor
	 * Use an ArrayList
	 */
	public Stack()
	{     } 
	
	/**
	 * Constructor
	 * @param arrayBased => Use an ArrayList
	 * 		 !arrayBased => Use a LinkedList
	 */
	public Stack(boolean arrayBased) {
		if(!arrayBased)
			values = new LinkedList<E>();
	}
	
	public E push(E value) {
		values.add(value);
		return value;
	}

	
	public E pop() {
		return values.remove(values.size()-1);
		
	}

	
	public E peek() {
		return values.get(values.size()-1);
	}
	
	public boolean isEmpty() {
		return values.isEmpty();
	}
	
	public void clear() {
		values.clear();
	}
	
	public String toString() {
		return values.toString();
	}
}
