package list;
/**
 * A RefIterator is an Iterator which allows iteration through a
 * LinkedList.
 * @author Ryan Schwegel
 * @author sdb
 * @version September 2020
 */
class RefIterator<E> implements Iterator<E>{
	LinkedList<E> list;
	//Reference to the Node storing the last value obtained
	//by a call to next()
	Node<E> cursor;
	
	//Constructor
	RefIterator(LinkedList<E> list){
		this.list = list;
		cursor = list.head;
	}
	
	public boolean hasNext() {
		return cursor.next != list.tail;
	}
	
	public E next() {
		cursor = cursor.next;
		return cursor.value;
	}
	
	public void remove() {
		cursor.prev.next = cursor.next;
		cursor.next.prev = cursor.prev;
		list.size--;
	}
	
	public void remove2() {
		cursor.prev.next = cursor.next.next;
		cursor.next.next.prev = cursor.prev;
		list.size = list.size - 2;
	}
	
	public boolean has2More() {
		return cursor.next.next != list.tail;
	}
}
