package hashDriver;
import hash.*;
import list.Iterator;

/**
 * Test the HashTable
 * 
 * @author (sdb) 
 * @version (2020)
 */
public class LabHashStudentsIterator 
{
    public static void main(String [] args)
    {   
         HashTable <Student> students = new HashTable <Student> (10);
      
         students.put (new Student ("jim", "423", 25, new HomeTown ("Glassboro", "NJ", "08028")));
         students.put (new Student ("joe", "424", 32, new HomeTown ("Glassboro", "NJ", "08028")));
         students.put (new Student ("jim", "433", 120, new HomeTown ("Pitman", "NJ", "08028")));
         students.put (new Student ("mary", "443", 0, new HomeTown ("Elk", "NJ", "08018")));
         students.put (new Student ("jim", "501", 25, new HomeTown ("Glassboro", "NJ", "08028")));
         
         Student key = new Student ("jim", "", 25, new HomeTown ("", "", "08028"));
         Student st = students.get (key);
         System.out.println ("Retrieving " + key + ": " + st);
         System.out.println();
         
         System.out.println ("The students are\n" + students);
         System.out.println ("There are " + students.size() + " students");
         removeFrosh(students,30);
         System.out.println ("\nFrosh are removed\n" + students);
         System.out.println ("We now have " + students.size() + " students\n");
         
         students.clear();
         students.put (new Student ("joe", "424", 32, new HomeTown ("Glassboro", "NJ", "08028")));
         students.put (new Student ("jim", "433", 120, new HomeTown ("Pitman", "NJ", "08028")));
         students.put (new Student ("mary", "443", 0, new HomeTown ("Elk", "NJ", "08018")));
         System.out.println (students);
         System.out.println ("We now have "+ students.size() + " students");
        
        } 
    
   /** remove all students from roster who have fewer than maxCr credits
      @author Ryan Schwegel
   */
   private static void removeFrosh (HashTable<Student> roster,int maxCr)
   {   
       Iterator<Student> it = roster.iterator();
       while(it.hasNext()) {
    	   if(it.next().credits < maxCr)
    		   it.remove();
       }
    }
       
}
