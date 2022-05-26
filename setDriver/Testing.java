package setDriver;
import set.*;
public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		set1.add(1);
		set1.add(2);
		set1.add(21);
		set1.add(2012);
		
		set2.add(2);
		set2.add(21);
		set2.add(3000);
		
		System.out.print(set1.intersection(set2));
	}

}
