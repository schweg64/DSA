package mapDriver;

import map.*;
import set.*;
import sort.HeapSort;
import list.*;
import java.io.*;
import sort.*;
/** Use a list of English words to unscramble
 *  the enemies messages.
 *  @author (sdb & Ryan Schwegel)
 *  @version (2020)
 */
public class CodeBreakerHelp
{
    List<String> words;   // All English words
    Map<String,List<String>> map = new HashMap<String,List<String>>();  // anagrams
    

    public static void main(String [] args)
    {   CodeBreakerHelp nsa = new CodeBreakerHelp();
        nsa.getWords();                 // Read the file of English words
        nsa.buildMap();           // Build the map: keys are sorted words
                                    // value is corresponding List of anagrams
                            // Example [...opst=[opts,post,pots,spot,stop,tops],...]
        String key = nsa.sort("niaiuanmrisotzrtiiocm");
        System.out.println (nsa.map.get(key));
        key = nsa.sort("fo");
        System.out.println (nsa.map.get(key));
        key = nsa.sort("uealcisonlesm");
        System.out.println (nsa.map.get(key));
        key = nsa.sort("npesoaw");
        System.out.println (nsa.map.get(key));
        key = nsa.sort("tpso");
        System.out.println (nsa.map.get(key));
        key = nsa.sort("nialtrenosotiaertuc");
        System.out.println (nsa.map.get(key));
    }
     
   // get a list of English words from a text file
    private void getWords ()
    {
    words = new ArrayList <String> ();
    try
    {
    File wordFile = new File ("words.txt");
    java.util.Scanner scanner = new java.util.Scanner (wordFile);
    String word;
    while (scanner.hasNextLine())
        words.add (scanner.nextLine());
    }
   catch (FileNotFoundException fnfe)
    {   System.err.println (fnfe);   }
    }
    

    /** @return the given string, with letters in alphabetic order
     *  If str is "pots" the result should be "opst"
     */
    private String sort (String str)
    {   List <Character> chars = new ArrayList <Character> ();
    for (int i=0; i<str.length(); i++)
        chars.add (str.charAt(i));
     //////////
     ///////// Call a sorting algorithm, or sort the list of chars here.
     /////////
    Sorter<Character> sort = new HeapSort<Character>();
    sort.sort(chars);
     String result = "";
    Iterator <Character> itty = chars.iterator();
    while (itty.hasNext())
        result += itty.next();
    return result;
    }
    
    // Build the map in which the keys are English words, sorted.
    // Values are all the anagrams of that word.
    private void buildMap()
    {
    	Iterator<String> it = words.iterator();
    	String word = "", sorted = "";
    	List<String> value;
    	
    	while(it.hasNext()) {
    		word = it.next();
    		sorted = sort(word);
    		value = map.get(sorted);
    		if(value != null)
    			value.add(word);
    		else {
    			value = new ArrayList<String>();
    			value.add(word);
    			map.put(sorted, value);
    		}
    	}
    }

}
