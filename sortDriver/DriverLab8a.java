package sortDriver;

import java.util.Random;
import list.*;
import sort.*;
/**
 * Driver to test three sorting algorithms on a large ArrayList of
 * integers.
 * @author Ryan Schwegel
 */
public class DriverLab8a {
	public static void main(String[] args) {
		/*
		Random rand = new Random();
		BubbleSort bubSorter = new BubbleSort();
		QuickSort quickSorter = new QuickSort();
		SelectionSort slctnSorter = new SelectionSort();
		
		List<Integer> nums = new ArrayList<Integer>(100000);
		List<Integer> sorted = new ArrayList<Integer>(100000);
		for(int i = 0; i < 100000; i++)
			nums.add(rand.nextInt());
		
		//run BubbleSort
		sorted.addAll(nums);
		System.out.println("Sorting with BubbleSort...");
		long start = System.nanoTime();
		bubSorter.sort(sorted);
		System.out.println("Done in " + ((System.nanoTime()-start)/1000000000.0) + " seconds");
		printFirst50(sorted);
		System.out.println();
		//check BubbleSort
		if(!check(sorted))
			System.out.println("Error with BubbleSort");
		
		sorted.clear();
		sorted.addAll(nums);
		//Run QuickSort
		System.out.println("Sorting with QuickSort...");
		start = System.nanoTime();
		quickSorter.sort(sorted);
		System.out.println("Done in " + ((System.nanoTime()-start)/1000000000.0) + " seconds");
		printFirst50(sorted);
		System.out.println();
		//Check QuickSort
		if(!check(sorted))
			System.out.println("Error with QuickSort");
		
		sorted.clear();
		sorted.addAll(nums);
		//Run SelectionSort
		System.out.println("Sorting with SelectionSort...");
		start = System.nanoTime();
		slctnSorter.sort(sorted);
		System.out.println("Done in " + ((System.nanoTime()-start)/1000000000.0) + " seconds");
		printFirst50(sorted);
		//Check SelectionSort
		if(!check(sorted))
			System.out.println("Error with SelectionSort");
			*/
		List<String> list = new ArrayList<String>();
		list.add("al");
		list.add("alan");
		list.add("bob");
		list.add("bob");
		list.add("jim");
		list.add("jimmy");
		list.add("mike");
		list.add("sue");
		list.add("tom");
		BinarySearch bin = new BinarySearch(list);
		bin.search("jim");
		System.out.println();
		bin.search("bob");
		System.out.println();
		bin.search("tom");
		System.out.println();
		bin.search("susie");
		System.out.println();
		bin.search("abby");
	}
	
	/**
	 * @return true iff given list is sorted in ascending order
	 */
	private static boolean check(List<Integer> sorted) {
		for(int i = 0; i < sorted.size()-1; i++) {
			if(Integer.compare(sorted.get(i), sorted.get(i+1)) > 0)
				return false;
		}
		return true;
	}
	
	/**
	 * Prints first 50 elements of provided list.
	 */
	private static void printFirst50(List<Integer> list){
		System.out.print("First 50 elements: [" + list.get(0));
		for(int i = 1; i < 50; i++)
			System.out.print("," + list.get(i));
		System.out.println("]");
	}
}
