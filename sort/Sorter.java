package sort;

import list.List;

/**
 * Encapsulate a sorting algorithm
 *
 */
public interface Sorter<E extends Comparable> {
	/**
	 * Post: the given list will be arranged in
	 * ascending order
	 */
	void sort (List<E> list);
}
