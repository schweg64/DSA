package set;

import list.Iterator;
import tree.*;
/** An implementation of Set, using a BinaryTree
 * @author sdb
 * @author Ryan Schwegel
 */
public class TreeSet<E extends Comparable> implements Set<E> {
	BinaryTree<E> tree = new EmptyBinarySearchTree<E>();
	int size = 0;
	public boolean contains(Object obj) {
		return tree.containsKey(obj);
	}

	public boolean add(E value) {
		if(tree.containsKey(value))
			return false;
		tree = tree.add(value);
		size++;
		return true;
	}

	public boolean remove(Object obj) {
		if(!tree.containsKey(obj))
			return false;
		tree = tree.remove(obj);
		size--;
		return true;
	}

	public Iterator<E> iterator() {
		return tree.iterator();
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
		tree= new EmptyBinarySearchTree<E>();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		Iterator<E> it = tree.iterator();
		if(tree.isEmpty())
			return "[]";
		String out = "[" + it.next();
		while(it.hasNext())
			out += "," + it.next();
		return out + "]";
	}
	
	/** @return true iff obj is a Set which contains the same values as this Set */
	public boolean equals(Object obj) {
		if(!(obj instanceof Set))
			return false;
		Set<E> other = (Set<E>)obj;
		if(other.size()!=size)
			return false;
		Iterator<E> it = other.iterator();
		while (it.hasNext()){
			if(!tree.containsKey(it.next()))
				return false;
		}
		return true;
	}
	
	public Set<E> intersection (Set<E> otherSet){
		Set<E> intersect = new TreeSet<E>();
		Iterator<E> itOther = otherSet.iterator();
		while(itOther.hasNext()) {
			E current = itOther.next();
			if(contains(current))
				intersect.add(current);
		}
		return intersect;
	}
}
