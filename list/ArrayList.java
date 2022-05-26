package list;

/**
 * An implementation of the List interface,
 * using an array to store the values
 * @author Ryan Schwegel
 * @author sdb
 * @version September 6 2020
 */
public class ArrayList <E> implements List <E>{
	int size = 0;
	E[] values;
	
	//Constructors
	public ArrayList ()
	{	this (10);}
	
	public ArrayList (int cap)
	{ 	values = (E[]) new Object[cap]; }
	
	//copy constructor
	public ArrayList (List<E> other) {
		this(other.size()==0 ? 1 : other.size());
		for(int i=0; i<other.size(); i++) {
			add(other.get(i));
		}
	}
	//Methods
	
	public E get (int ndx)
	{ 	return values[ndx]; };
	
	public E set (int ndx, E value)
	{ 	E result = values[ndx];
		values[ndx] = value;
		return result;
	}
	
	public void add(E value)
	{	add(size,value);	}
	
	public void add(int ndx, E value)
	{	//Is the array full?
		if (values.length == size)
			alloc();
		//Make room for the insertion
		for(int i=size; i>ndx; i--)
			values[i] = values[i-1];
		values[ndx] = value;
		size++;
	}
	
	/**
	 * Allocate a new array, twice as big,
	 * and copy all values
	 */
	private void alloc() {
		E[] tempArray =
				(E[]) new Object[2*values.length];
		for(int i=0; i<size; i++)
			tempArray[i] = values[i];
		values = tempArray;
	}
	
	public E remove(int ndx)
	{  //Don't clobber the result
		E result = values[ndx];
		for(int i=ndx; i<size-1; i++)
			values[i] = values[i+1];
		size--;
		return result;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;		
	}
	
	public void clear() {
		size = 0;
	}
	
	public int indexOf(Object obj) {
		for(int i=0; i<size; i++) {
			if(values[i].equals(obj))
				return i;
		}
		return -1;
	}
	
	public boolean contains(Object obj) {
		if(indexOf(obj)!=-1)
			return true;
		return false;
	}
	
	/** @return this ArrayList as a String */
	public String toString()
	{ 
		String output = "[";
		if(size!=0)
		{
			output = "[" + values[0];
			for(int i=1; i<size; i++)
				output += "," + values[i];
		}
		return output + "]";
	}
	
	public boolean remove(Object obj) {
		int ndx = indexOf(obj);
		if(ndx!=-1) {
			remove(ndx);
			return true;
		}
		return false;
	}
	
	public Iterator<E> iterator(){
		return new ArrayIterator<E>(this);
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
		return new ArrayListIterator<E>(this);
	}
	
	public ListIterator<E> listIterator(int start){
		return new ArrayListIterator<E>(this, start);
	}
	
	public void addAll(List<E> list) {
		Iterator<E> it = list.iterator();
		while(it.hasNext())
			add(it.next());
	}
}

