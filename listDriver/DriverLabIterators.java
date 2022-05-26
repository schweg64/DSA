package listDriver;
import list.*;
import java.util.Random;
////// Do NOT change the imports

/**
 * Data Structures and Algorithms.
 * Lab 2
 * Test Iterators
 * 
 * @author (sdb) 
 * @version (Sep 2020)
 */
public class DriverLabIterators
{
    public static void main(String[] args)
    {
        System.out.println ("Testing problem 1; Please wait...");
        List <String> strings = new LinkedList <String>();
        test1 (strings);
   
   ////// Should take about 5-10 seconds:
        List <Integer> numbers = new ArrayList <Integer>();
        test2(numbers);
        numbers = new LinkedList<Integer>();
        test2(numbers);
       
        System.out.println ("Testing problem 1 - Finished.");
   
}

private static void test1 (List <String> strings)
{   for (int i=0; i<1000000; i++)
        strings.add ("s" + i);
    if (! strings.get(3).equals ("s3"))
        System.err.println ("Not correct");
    if (! strings.get(999993).equals ("s999993"))
        System.err.println ("Not correct");
}

private static void test2 (List <Integer> nums)
{   
    Random rand = new Random(1);
    for (int i=0; i<100000; i++)
        nums.add (rand.nextInt(1000)-100);
    removeNegs(nums);
    if (nums.size() != 89979)
        System.err.println ("Wrong size: Error in removeNegs");
}

/** Remove all negative numbers from the given List. 
 *  @author Ryan Schwegel
 */
private static void removeNegs(List<Integer>numbers)
{   
	Iterator<Integer> it = numbers.iterator();
	while(it.hasNext()) {
		if(it.next() < 0)
			it.remove();
	}
}
    

}
