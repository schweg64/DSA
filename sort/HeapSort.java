package sort;

import list.List;

/** Sort a given List using the HeapSort algorithm
 * @author sdb
 * @author Ryan Schwegel
 */
public class HeapSort<E extends Comparable> implements Sorter<E> {
	List<E> list;
	public void sort(List<E> list) {
		this.list = list;
		int last = list.size() - 1;
		heapify(0);
		while (last > 0) {
			swap(0, last);
			last--;
			percDown(0,last);
		}
	}
	
	/**
	 * Make the part of the list beginning at root
	 * into a heap
	 */
	private void heapify(int root) {
		int max = list.size() - 1; 
		if(root >= max)
			return;
		heapify(root*2+1);
		heapify(root*2+2);
		percDown(root,max);
	}
	
	/**
	 * Move the root down, so as to make this part of the
	 * list into a heap. Do not go beyond max
	 * @param root
	 * @param max
	 */
	private void percDown(int root, int max) {
		int bc = biggerChild(root, max);
		while(2*root+1 <= max && greater(bc,root)) {
			swap(root,bc);
			root = bc;
			bc = biggerChild(root, max);
		}
	}
	
	/**
	 * @return the position of the bigger child of given
	 * root position.
	 * Pre: root has a left child
	 */
	private int biggerChild(int root, int max) {
		int left = 2*root+1, right = 2*root+2;
		if(right > max)
			return left;
		if(greater(left,right))
			return left;
		return right;
	}
	
	/**
	 * @return true iff the value at position p1 is greater
	 * than the value at position p2.
	 */
	private boolean greater(int p1, int p2) {
		int cmp = list.get(p1).compareTo(list.get(p2));
		return cmp > 0;
	}
	
	/**
	 * Swaps the values in the list at positions p1 and p2
	 */
	private void swap(int p1, int p2) {
		E temp = list.get(p2);
		list.set(p2, list.get(p1));
		list.set(p1, temp);
	}
}
