package list;

/**
 * An ArrayIterator is an Iterator which allows iteration through
 * an ArrayList.
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
class ArrayIterator<E> implements Iterator<E>{
	List<E> list;
	//Position for the last value obtained by a call to next();
	int ndx = -1;
	ArrayIterator(List<E> list){
		this.list = list;
	}
	public boolean hasNext() {
		return ndx < list.size() - 1;
	}
	public E next() {
		ndx++;
		return list.get(ndx);
	}
	public void remove() {
		list.remove(ndx);
		ndx--;
	}
	
	public void remove2() {
		list.remove(ndx+1);
		list.remove(ndx);
		ndx--;
	}
	
	public boolean has2More() {
		return ndx < list.size() - 2;
	}
}
