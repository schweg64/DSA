package hashDriver;
import hash.*;
public class Testing2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTable<Integer> table = new HashTable<Integer>(5);
		table.put(17);
		table.put(3);
		table.put(193939);
		table.put(4);
		System.out.println(table);
	}

}
