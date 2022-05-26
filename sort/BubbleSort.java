package sort;

import list.List;

/**
 * An implementation of the Bubble Sort Algorithm
 */
public class BubbleSort<E extends Comparable> 
	implements Sorter<E> {
	
	List<E> list;
	public void sort(List<E> list) {
		boolean swapped = false;
		this.list = list;
		for(int ndx=0; ndx<list.size()-1;ndx++) {
			swapped = false;
			for(int i=0; i < list.size()-ndx-1; i++) {
				if(list.get(i).compareTo(list.get(i+1))>0) {
					swap(i,i+1);
					swapped = true;
				}
			}
			if(!swapped)
				break;
		}
	}
	
	/**
	 * Exchange the items at the given positions
	 */
	private void swap(int x, int y) {
		E temp = list.get(x);
		list.set(x, list.get(y));
		list.set(y, temp);
	}

}
