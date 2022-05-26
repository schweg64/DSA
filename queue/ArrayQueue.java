package queue;

import list.ArrayList;
import list.List;
/**
 * An implementation of the QueueADT interface,
 * using an ArrayList
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
public class ArrayQueue<E> implements QueueADT<E> {
	List<E> values = new ArrayList<E>();
	
	int back=0;
	int front=0;
	int size=0;
	
	public void add(E value) {
		if(size==values.size()) {
			values.add(back, value);
			front = (front+1) % values.size();
		} else
			values.set(back, value);
		back = (back+1) % values.size();
		size++;	
	}

	
	public E remove() {
		E output = values.get(front);
		front = (front+1) % values.size();
		size--;
		return output;
	}
	
	public E peek() {
		if(size>0)
			return values.get(front);
		return null;
	}
	
	public boolean isEmpty() {
		return size == 0; 
	}
	
	public void clear() {
		size = 0;
		front = 0;
		back = 0;
	}
	
	public String toString() {
		String out = "[";
		if(size > 0) {
			out += values.get(front);
			int ndx = front;
			for(int i = 1; i<size; i++) {
				ndx = (ndx+1) % values.size();
				out += "," + values.get(ndx);
			}
		}
		return out + "]";
	}
	
	public int size() {
		return size;
	}
}
