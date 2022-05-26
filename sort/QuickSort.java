package sort;

import list.List;

/**
 * An implementation of the QuickSort algorithm
 */
public class QuickSort<E extends Comparable> implements Sorter<E> {

	List<E> list;
	public void sort(List<E> list) {
		this.list = list;
		qSort(0, list.size()-1);
	}
	
	public void qSort(int start, int end) {
		if(start >= end)
			return;
		int p = partition(start, end);
		qSort(start, p-1);
		qSort(p+1, end);
	}
	
	/**
	 * Partition the values from start to end about a pivot value.
	 * @return the pivot position
	 */
	public int partition(int start, int end) {
		int p = start;
		int mid = (start+end)/2;
		E pivot = list.get(mid);
		list.set(mid, list.get(start));
		for(int i = start+1; i <= end; i++) {
			if(pivot.compareTo(list.get(i)) > 0) {
				list.set(p, list.get(i));
				p++;
				list.set(i, list.get(p));
			}
		}
		list.set(p, pivot);
		return p;
	}
}
