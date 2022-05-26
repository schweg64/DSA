package queue;
import list.*;
/**
 * A PriorityQueue is a Queue, in which each item
 * has a priority. When removing, the value with the highest
 * priority is removed (not FIFO)
 * @author sdb
 * @author Ryan Schwegel
 */
public class PriorityQueue<E extends Comparable> 
	implements QueueADT<E>{
	List<E> values = new ArrayList<E>();
	
	public E remove() {
		E result = values.get(0);
		int last = values.size() -1;
		int avail = 0;
		int bc = biggerChild(0);
		while(2*avail+1 < last && greater(bc, last)) {
			values.set(avail, values.get(bc));
			avail = bc;
			bc = biggerChild(avail);
		}
		values.set(avail, values.get(last));
		values.remove(last);
		return result;
	}
	
	public void add(E value) {
		int added, parent;
		values.add(value);
		added = values.size()-1;
		parent = (added-1) / 2;
		while(added>0 && greater(added,parent)) {
			swap(added,parent);
			added = parent;
			parent = (added-1)/2;
		}
	}
	
	/** @return the position of parent's bigger child */
	private int biggerChild(int parent) {
		int left = 2*parent + 1;
		int right = left + 1;
		if(right >= values.size())
			return left;
		if(greater(left,right))
			return left;
		return right;
	}
	
	/** @return true iff the value at position x is
	 * greater than the value at position y
	 */
	private boolean greater(int x, int y) {
		return values.get(x).compareTo(values.get(y)) > 0;
	}
	
	private void swap(int i, int j) {
		E temp = values.get(i);
		values.set(i, values.get(j));
		values.set(j, temp);
	}
	
	public int size() {
		return values.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public E peek() {
		return values.get(0);
	}
	
	public void clear() {
		values = new ArrayList<E>();
	}
	
	public String toString() {
		return values.toString();
	}
}
