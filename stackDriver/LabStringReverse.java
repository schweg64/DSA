package stackDriver;
import stack.*;
import java.util.Scanner;
/**
 * Test the reverse method for Strings
 * 
 * @author (sdb) 
 * @version (Feb 2017)
 */
public class LabStringReverse
{
    public static void main(String [] args)
    {   String input = " ";
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Enter several lines of input, or just Enter to terminate");
        while (input.length() > 0)
            {   input = scanner.nextLine();
                System.out.println (reverse (input));
            }
     }
      
     
     /** @return the given String, s, in reverse sequence.
       * @author  Ryan Schwegel 
       */
    public static String reverse (String s)
    {   
        StackADT<Character> stack = new Stack<Character>();
    	for(int i=0; i < s.length(); i++) {
    		stack.push(s.charAt(i));
    	}
    	String reversed = "";
        while(!stack.isEmpty()) {
        	reversed = reversed + stack.pop();
        }
        return reversed;
        
        
       
    }


}
