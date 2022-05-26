package list;

/**
 * Nodes store a value in a LinkedList and
 * the reference to the next Node in the list.
 * @author ryang
 * @author sdb
 * @version September 9 2020
 */
public class Node <E>{
	E value;
	Node<E> next;
	Node<E> prev;
	
	//Constructor
	public Node(E value, Node<E> next, Node<E> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
	}
	
	
}
