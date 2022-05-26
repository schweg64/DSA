package sort;

import list.*;

/**
 * Sort a LinkedList in time O(n^2), using a ListIterator
 * This will be slow for an ArrayList
 * @author sdb
 * @author Ryan Schwegel
 */
public class BubbleSortLinked<E extends Comparable> 
	implements Sorter<E> {
	
	List<E> list;
	
	public void sort(List<E> list) {
		this.list = list;
		E left, right;
		ListIterator<E> itty;
		for(int i=0; i<list.size()-1; i++) {
			itty = list.listIterator();
			right = itty.next();
			for(int j=0; j<list.size()-i-1; j++) {
				left = right;
				right = itty.next();
				if(left.compareTo(right)>0) {
					itty.remove();
					itty.previous();
					itty.add(right);
					right = itty.next();
				}
			}
			
		}
	}
}
