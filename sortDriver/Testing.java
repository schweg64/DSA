package sortDriver;
import sort.*;
import list.*;
public class Testing {
	
	public static void main (String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		/* Q1
		ints.add(6);
		ints.add(3);
		ints.add(4);
		ints.add(7);
		ints.add(5);
		ints.add(8);
		ints.add(5);
		ints.add(2);
		ints.add(4);
		ints.add(9);
		*/
		ints.add(3);
		ints.add(7);
		ints.add(8);
		ints.add(6);
		ints.add(5);
		ints.add(4);
		ints.add(5);
		ints.add(2);
		ints.add(4);
		ints.add(9);
		HeapSort<Integer> sort = new HeapSort<Integer>();
		sort.sort(ints);
	}
}
