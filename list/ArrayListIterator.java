package list;

/**
 * A ListIterator specifically for ArrayLists
 * @author Ryan Schwegel
 * @author sdb
 * @version Sept 2020
 */
class ArrayListIterator<E> 
	extends ArrayIterator<E> 
	implements ListIterator<E>{
	/*
	 * ndx is in super class. Implicit cursor is between 
	 * positions ndx and ndx + 1
	 * 
	 * 			0	1	2	3	4
	 * 			a	b	c	d	e
	 * ndx   -1   0   1   2   3   4   implicit cursor
	 */
	
	//forward => iterating left to right, using next()
	//!forward => iterating right to left, using previous()
	private boolean forward = true;
	
	ArrayListIterator(List<E> list)
	{super (list);}
	
	ArrayListIterator(List<E> list, int start){
		super(list);
		ndx = start - 1;
	}
	
	public boolean hasPrevious() {
		return ndx>=0;
	}
	
	public E previous() {
		ndx--;
		forward = false;
		return list.get(ndx+1);
	}
	
	public void remove() {
		if(forward) 
			super.remove();
		else {
			list.remove(ndx+1);
		}
	}
	
	public E next() {
		forward = true;
		return super.next();
	}
	
	public void add(E value) {
		list.add(ndx + 1, value);
		ndx++;
	}
}
