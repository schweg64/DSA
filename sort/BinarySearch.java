package sort;
import list.List;
/**
 * Binary Search algorithm of a sorted List.
 * For fast performance, the List should be 
 * an ArrayList
 */
public class BinarySearch<E extends Comparable> {
	private List<E> list;
	public BinarySearch(List<E> list) {
		this.list = list;
	}
	
	/**
	 * @return a position of the target, or -1 if not found
	 */
	public int search(E target) {
		return binSrch(0, list.size()-1, target);
	}
	
	private int binSrch (int start, int end, E target) {
		if(start > end)
			return -1;
		int mid = (start + end)/2;
		System.out.print(mid + ",");
		int cmp = target.compareTo(list.get(mid));
		if (cmp == 0)
			return mid;
		if (cmp < 0)
			return binSrch(start, mid-1, target);
		return binSrch(mid+1, end, target);
	}
}
