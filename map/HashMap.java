package map;

import set.*;

import hash.HashTable;
import list.Iterator;
import map.TreeMap.Entry;

public class HashMap<K, V> implements Map<K, V> {
	class Entry<K,V>{
		K key;
		V value;
		
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
		}
		
		/** @return true iff the given object is an Entry, 
		 * and its key is equal to the key of this Entry
		 */
		public boolean equals(Object obj) {
			if(!(obj instanceof Entry))
				return false;
			Entry<K,V> entry = (Entry<K,V>)obj;
			return this.key.equals(entry.key);
		}
		public int hashCode() {
			return key.hashCode();
		}
		public String toString() {
			return key + "=" + value;
		}
	}
	HashTable<Entry<K,V>> table;
	
	public HashMap() {
		table = new HashTable<Entry<K,V>>();
	}
	public HashMap(int size) {
		table = new HashTable<Entry<K,V>>(size);
	}
	public boolean containsKey(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		return table.containsKey(entry);
	}

	
	public V get(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null);
		entry = table.get(entry);
		if (entry == null)
			return null;
		return entry.value;
	}

	
	public V put(K key, V value) {
		Entry<K,V> newEntry = new Entry<K,V>(key, value),
				oldEntry = table.get(newEntry);
		if(oldEntry == null) {
			table.put(newEntry);
			return null;
		}
		V oldValue = oldEntry.value;
		oldEntry.value = value;
		return oldValue;
	}

	
	public V remove(K key) {
		Entry<K,V> entry = new Entry<K,V>(key, null),
				result = table.get(entry);
		if(table.remove(entry))
			return result.value;
		return null;
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
		String out = "[";
		if(!isEmpty()) {
			Iterator<Entry<K,V>> it = table.iterator();
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
		Iterator<Entry<K,V>> it = table.iterator();
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
		Iterator<Entry<K,V>> it = table.iterator();
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
	
	/** @return any key for the given value, or null if the value is not in the map */

	public K  getKey(V value)
	{
		Iterator<K> it = keySet().iterator();
		K current;
		V currentVal;
		while(it.hasNext()) {
			current = it.next();
			currentVal = get(current);
			if((currentVal == null && value == null) || currentVal.equals(value))
				return current;
		}
		return null;
	}
}
