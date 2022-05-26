package map;
import list.Iterator;
import map.HashMap.Entry;
import set.HashSet;
import set.Set;
import tree.*;
/**
 * An implementation of the Map interface using a Binary tree of entries.
 * @author Ryan Schwegel
 * @author sdb
 */
public class TreeMap<K extends Comparable, V> 
	implements Map<K,V>{
	class Entry<K extends Comparable, V> implements Comparable<Entry<K,V>>{
		K key;
		V value;
		Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		public int compareTo(Entry<K,V> other) {
			return key.compareTo(other.key);
		}
		
		public String toString() {
			return key.toString() + "=" + value.toString();
		}
	}
	BinaryTree<Entry<K,V>> tree = new EmptyBinarySearchTree<Entry<K,V>>();
	int size = 0;
	
	public boolean containsKey(K key){
		Entry<K,V> entry = new Entry<K,V>(key,null);
		return tree.containsKey(entry);
	}
	
	public V get (K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if (entry == null)
			return null;
		return entry.value;
	}
	
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value),
				oldEntry = tree.get(newEntry);
		if(oldEntry==null) {
			tree = tree.add(newEntry);
			size++;
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
		
	}
	
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = tree.get(entry);
		if(entry == null)
			return null;
		size--;
		tree = tree.remove(entry);
		return entry.value;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		tree = new EmptyBinarySearchTree<Entry<K,V>>();
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		String out = "[";
		if(!isEmpty()) {
			Iterator<Entry<K,V>> it = tree.iterator();
			Entry<K,V> current = it.next();
			out += current.toString();
			while(it.hasNext()) {
				current = it.next();
				out += "," + current;
			}
		}
		return out += "]";
	}
	
	public Set<K> keySet(){
		Set<K> keySet = new HashSet<K>();
		Iterator<Entry<K,V>> it = tree.iterator();
		while(it.hasNext()) {
			keySet.add(it.next().key);
		}
		return keySet;
	}
	
	/** @return true iff obj is a Map which contains all the same entries as this Map (and no other entries) */
	public boolean equals(Object obj) {
		if(!(obj instanceof Map))
			return false;
		Map other = (Map)obj;
		if(other.size()!=size())
			return false;
		Iterator<Entry<K,V>> it = tree.iterator();
		while(it.hasNext()) {
			Entry<K,V> entry = it.next();
			Object value = other.get(entry.key);
			if((value == null || entry.value == null) && !(value == entry.value))
				return false;
			if(!value.equals(entry.value))
				return false;
		}
		return true;
	}
}
