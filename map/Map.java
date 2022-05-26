package map;

import set.Set;

/** Each entry in a Map consists of a key and a value.
 * Keys must be unique.
 * Access the values via the keys
 * @author sdb
 * @author Ryan Schwegel
 */
public interface Map<K, V> {
	/** @return true iff this Map contains the given key */
	boolean containsKey(K key);
	
	/** @return the value corresponding to the given key,
	 * or null if not in this Map.
	 */
	V get (K key);
	
	/** If the given key is already in this Map, change
	 * its corresponding value to the given value. If not,
	 * include the key-value pair in this Map.
	 * @return the old value, or null if not in this Map.
	 */
	V put (K key, V value);
	
	/** Remove the key-value pair having the given key 
	 * from this Map.
	 * @return the value, or null if not in this Map.
	 */
	V remove (K key);
	
	/** @return the size of this Map */
	int size();

	/** clear this Map */
	void clear();

	/** @return true iff this Map is empty */
	boolean isEmpty();
	
	/**  @return the entries in this Map as a String, in the format key=value */
	String toString();
	
	/** @ return a Set of all the keys in this Map */
	Set<K> keySet(); 
	
	/** @return true iff obj is a Map which contains all the same entries as this Map (and no other entries) */
	public boolean equals(Object obj);
}
