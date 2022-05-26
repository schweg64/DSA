package set;
import hash.HashTable;
import list.Iterator;
/** An implementation of Set, using a HashTable
 * @author Ryan Schwegel
 * @author sdb
 */
public class HashSet<E> implements Set<E> {
	HashTable<E> table = new HashTable<E>();
	
	public boolean contains(Object obj) {
		return table.containsKey(obj);
	}

	public boolean add(E value) {
		if(table.containsKey(value))
			return false;
		table.put(value);
		return true;
	}

	public boolean remove(Object obj) {
		return table.remove(obj);
	}

	public Iterator<E> iterator() {
		return table.iterator();
	}
	
	public int size() {
		return table.size();
	}
	
	public void clear() {
		table.clear();
	}
	
	public boolean isEmpty() {
		return table.isEmpty();
	}
	
	public String toString() {
		Iterator<E> it = table.iterator();
		if(table.isEmpty())
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
		if(other.size()!=table.size())
			return false;
		Iterator<E> it = other.iterator();
		while (it.hasNext()){
			if(!table.containsKey(it.next()))
				return false;
		}
		return true;
	}
	
	public Set<E> intersection (Set<E> otherSet){
		Set<E> intersect = new HashSet<E>();
		Iterator<E> itOther = otherSet.iterator();
		while(itOther.hasNext()) {
			E current = itOther.next();
			if(contains(current))
				intersect.add(current);
		}
		return intersect;
	}
}
