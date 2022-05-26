package hash;
import list.Iterator;
/**
 * A TableIterator permits the client to
 * iterator through a HashTable.
 * @author Ryan Schwegel
 * @author sdb
 */
public class TableIterator<K> implements Iterator<K> {
	HashTable<K> table;
	int ndx=0;        //current ArrayList index
	Iterator<K> itty; //For a LinkedList
	TableIterator(HashTable<K> table){
		this.table = table;
		setItty(ndx);
	}
	
	/** Set the iterator to the LInkedList at the given
	 * ndx in the ArrayList
	 */
	private void setItty(int ndx) {
		itty = table.lists.get(ndx).iterator();
	}
	
	/** @return the index of the next non-empty
	 * LinkedList or -1 if none.
	 */
	private int nextList() {
		for(int i = ndx+1; i<table.lists.size(); i++) {
			if(!table.lists.get(i).isEmpty())
				return i;
		}
		return -1;
	}
	
	public boolean hasNext() {
		if(itty.hasNext())
			return true;
		return nextList() > 0;
	}
	
	public K next() {
		if(!itty.hasNext()) {
			ndx = nextList();
			setItty(ndx);
		}
		return itty.next();
	}
	
	public void remove() {
		itty.remove();
		table.size--;
	}
	
	public boolean has2More() {
		int ndxCp = ndx;
		ndx = nextList();
		if(ndx < 0) {
			ndx = ndxCp;
			return false;
		} 
		int second = nextList();
		ndx = ndxCp;
		if(second < 0) {
			return false;
		}
		return true;
	}
	
	public void remove2() {
		
	}
}
