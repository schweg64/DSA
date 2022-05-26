package list;

/**
 * An implementation of the List interface that uses
 * references rather than an array.
 * @author Ryan Schwegel
 * @author sdb
 * @version September 9 2020
 */
public class LinkedList<E> implements List<E> {
	int size = 0;
	Node<E> head = new Node<E>(null,null,null);
	Node<E> tail = new Node<E>(null,null,head);
	private Node<E> ref;
	
	public LinkedList() {
		head.next = tail;
	}
	
	//Post - ref refers to the node at the given index
	//Pre - 0<=ndx<size
	private void setRef(int ndx) {
		if(ndx < size/2) {
			ref = head.next;
			for(int i=0; i<ndx; i++) 
				ref = ref.next;
		} else {
			ref = tail.prev;
			for(int i=size-1; i>ndx; i--)
				ref = ref.prev;
		}
	}
	
	public void add(E value) {
		Node<E> temp = new Node<E>(value, tail, tail.prev);
		tail.prev.next = temp;
		tail.prev = temp;
		size++;
	}
	
	public void add(int ndx, E value) {
		setRef(ndx);
		Node<E> temp = new Node<E>(value, ref, ref.prev);
		ref.prev.next = temp;
		ref.prev = temp;
		size++;		
	}
	
	
	public E get (int ndx) {
		setRef(ndx);
		return ref.value;
	}
	
	public E set (int ndx, E value) {
		setRef(ndx);
		E result = ref.value;
		ref.value = value;
		return result;
	}
	
	public E remove (int ndx) {
		setRef(ndx);
		ref.next.prev = ref.prev;
		ref.prev.next = ref.next;
		size--;
		return ref.value;
	}
	
	/**
	 * @return size of this list
	 */
	public int size() {
		return size;
	}
	
	/**
	 * clears this list
	 */
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	/**
	 * @return true iff this list is empty
	 */
	public boolean isEmpty() {
		if(size==0)
			return true;
		return false;
	}
	
	/**
	 * @return index of given object in this list, or -1 if not found.
	 */
	public int indexOf(Object obj) {
		Node<E> ref = head.next;
		int ndx = 0;
		while(ndx<size) {
			if(ref.value.equals(obj))
				return ndx;
			ndx++;
			ref = ref.next;
		}
		return -1;
	}

	/**
	 * @return true iff list contains obj
	 */
	public boolean contains(Object obj) {
		if(indexOf(obj)==-1)
			return false;
		return true;
	}
	
	/**
	 * @return this list as a string.
	 */
	public String toString() {
		String output = "[";
		Node<E> ref = head.next;
		if(size!=0) {
			output = output + ref.value;
			ref = ref.next;
			while(ref!=tail) {
				output = output + "," + ref.value;
				ref = ref.next;
			}	
		}
		return output + "]";
	}

	public boolean remove(Object obj) {
		ref = head.next;
		for(int i = 0; i<size; i++) {
			if(ref.value.equals(obj)) {
				ref.next.prev = ref.prev;
				ref.prev.next = ref.next;
				size--;
				return true;
			}
			ref=ref.next;
		}
		return false;
	}
	
	public Iterator<E> iterator(){
		return new RefIterator<E>(this);
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof List) {
			List other = (List) obj;
			Iterator<E> it1 = this.iterator();
			Iterator<E> it2 = other.iterator();
			if(other.size()!=size)
				return false;
			while(it1.hasNext()) {
				if(!it1.next().equals(it2.next()))
					return false;
			}
			return true;
		}
		return false;
	}
	
	public ListIterator<E> listIterator(){
		return new RefListIterator<E>(this);
	}
	public ListIterator<E> listIterator(int start){
		return new RefListIterator<E>(this,start);
	}
	public void addAll(List<E> list) {
		Iterator<E> it = list.iterator();
		while(it.hasNext())
			add(it.next());
	}
	
	/** @return a hashCode for this LinkedList */
	public int hashCode() {
		Iterator<E> it = iterator();
		int code = size;
		while(it.hasNext()) {
			code += code*31 + it.next().hashCode();
		}
		return code;
	}
}
