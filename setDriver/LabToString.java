package setDriver;
import set.*;
public class LabToString {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		System.out.println("Testing HashSet");
		printSet(set);
		System.out.println("Testing TreeSet");
		set = new TreeSet<String>();
		printSet(set);
	}
	
	private static void printSet(Set<String> set) {
		set.add("foo");
		set.add("bar");
		set.add("zaz");
		set.add("baz");
		System.out.println(set);
		set.clear();
		System.out.println(set);
		set.add("foo");
		System.out.println(set);
		System.out.println();
	}
}
