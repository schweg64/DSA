package hash;
import list.*;
/**
 * Provide quick access to data values, using ArrayList 
 * of LinkedLists. Performance is improved when the 
 * client's hashCode() minimizes collisions.
 * @author sdb
 * @author Ryan Schwegel
 */
public class HashTable<K> {
	List<List<K>> lists;
	int size = 0;
	
	public HashTable(int cap) {
		lists = new ArrayList<List<K>>(cap);
		for (int i = 0; i<cap; i++) {
			lists.add(new LinkedList<K>());
		}
	}
	
	/** Use this constructor for small HashTables */
	// Default ArrayList size is 10
	public HashTable() {
		this(1000);
	}
	
	/** @return a valid index to the ArrayLIst, using the client's
	 * hasCode() method
	 */
	private int getCode(Object obj) {
		int result = obj.hashCode();
		result = Math.abs(result);
		result = result % lists.size();
		return result;
	}
	
	/** @return true iff the given obj is in this HashTable. */
	public boolean containsKey(Object obj) {
		int code = getCode(obj);
		return lists.get(code).contains(obj);
	}
	
	/** Add the given key to this HashTable */
	public void put(K key) {
		int code = getCode(key);
		List<K> list = lists.get(code);
		list.add(key);
		size++;
	}
	
	/** @return a matching key from this HashTable,
	 * or null if not found.
	 */
	public K get(K key) {
		int code = getCode(key);
		List<K> list = lists.get(code);
		int ndx = list.indexOf(key);
		if (ndx<0)
			return null;
		return list.get(ndx);
	}
	
	/** Remove the given obj from this HashTable, if
	 * possible.
	 * @return true iff it was removed.
	 */
	public boolean remove(Object obj) {
		int code = getCode(obj);
		List<K> list = lists.get(code);
		if(list.remove(obj)) {
			size--;
			return true;
		}
		return false;
	}
	/** @return the size of this HashTable */
	public int size() {
		return size;
	}
	/** Clears this HashTable of all values */
	public void clear() {
		size = 0;
		for (int i = 0; i<lists.size(); i++) {
			lists.get(i).clear();
		}
	}
	/** @return true iff this HashTable is empty */
	public boolean isEmpty() {
		return size == 0;
	}
	
	public Iterator<K> iterator(){
		return new TableIterator<K>(this);
	}
	
	public String toString() {
		/*
		Iterator<K> it = iterator();
		String out = "[";
		if(it.hasNext()) {
			out += it.next();
			while(it.hasNext())
				out+= "," + it.next();
		}
		return out + "]";
		*/
		return lists.toString();
	}
}
