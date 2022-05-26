package listDriver;
import list.*;

/**
 * Test methods added to the List interface
 * 
 * @author (sdb) 
 * @version (Sep 2019)  
 */
public class DriverLinkedList
{
     
/**
 *  This main method tests the LinkedList class
 */
    List<String> friends = new LinkedList <String> ();
    
    public static void main (String[] args)
    {   DriverLinkedList driver = new DriverLinkedList();
        driver.problem1();
	    //Uncomment the following when ready for problem 2
	         driver.problem2();
    }
    
   
        
    private void init()
    {
         friends.add ("joe");
         friends.add ("mary");
         friends.add ("jim");
         friends.add ("joe");                            // Lists may contain duplicate elements
         friends.add (2, "sally");                       // Insert at position 2
    }
        
    private void problem1()
     {  System.out.println ("Testing problem 1");
        List<Integer> numbers = new LinkedList <Integer> ();
        for (int i=0; i<100000; i++)
            numbers.add(i);
        
        for (int i=0; i<1000000; i++)
            {   int smallNdx = i % 5;
                if (numbers.get(smallNdx) != smallNdx)
                    System.err.println ("Error for " + smallNdx);
                int largeNdx = 100000 - smallNdx - 1;
                if (numbers.get(largeNdx) != largeNdx)
                    System.err.println ("Error for " + largeNdx);
           }
           System.out.println ("Problem 1 complete");
        }
    
  
    private void problem2()
    {
        init();
        System.out.println ("\nTesting problem 2 for LinkedList");
        test();
        System.out.println ("\nTesting problem 2 for ArrayList");
        friends = new ArrayList<String>();
        init();
        test();
        System.out.println ("\nProblem 2 complete");
    }

    
    
    private void test()
    {   
    friends.clear();
    for (int i=0; i< 25; i++)
        friends.add ("str" + i);
    friends.add("str3");
    if (friends.indexOf(new String("str3")) != 3)
        System.err.println ("Error in indexOf");
    if (friends.remove("foo"))
        System.err.println ("Error in remove(Object)");
    for (int i=0; i<100; i = i+2)               // remove even values
        friends.remove(new String("str"+i));
    if (friends.size() != 13)
        System.err.println ("Error in remove(Object)");
    System.out.println (friends);
        }
}       
