package listDriver;
import list.*;
public class Testing {

	public static void main(String[] args) {
		//testRemove2();
		testHashCode();
	}
	private static void testHashCode() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		list2.add(4);
		
		list3.add(1);
		list3.add(3);
		list3.add(2);
		list3.add(4);
		
		System.out.println(list1.equals(list2));
		System.out.println(list1.equals(list3));
		
		System.out.println(list1.hashCode() + " " + list2.hashCode());
		System.out.println(list1.hashCode() + " " + list3.hashCode());
	}
	private static void testRemove2() {
		ArrayList<Integer> alist = new ArrayList<Integer>();
		LinkedList<Integer> llist = new LinkedList<Integer>();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		alist.add(4);
		
		llist.add(1);
		llist.add(2);
		llist.add(3);
		llist.add(4);
		System.out.println(alist + "\n" + llist);
		Iterator<Integer> ait = alist.iterator();
		Iterator<Integer> lit = llist.iterator();
		ait.next();
		ait.next();
		
		lit.next();
		lit.next();
		ait.remove2();
		lit.remove2();
		System.out.println(alist + "\n" + llist);
	}
}
