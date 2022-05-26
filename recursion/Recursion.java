package recursion;

/**
 * Test class for methods defined in Recursion lecture
 * @author Ryan Schwegel
 *
 */
public class Recursion {
	public static int fact(int n) {
		if(n==0)
			return 1;
		return fact(n * fact(n-1));
	}
	
	public static int fib(int n) {
		if(n<2)
			return 1;
		return fib(n-1) + fib(n-2);
	}
	
	public static int mult(int x, int y) {
		if(x<1)
			return 0;
		return y + mult(x-1,y);
	}
	
	public static boolean pal(String s) {
		if(s.length() < 2) //Base case
			return true;
		if(s.charAt(0)!=s.charAt(s.length()-1))
			return false;
		//Recursive case
		return pal(s.substring(1,s.length()-1));
	}
	
	/**
	 * @return the remainder on integer division 
	 * @param dvsr divisor (number to be divided) dvnd dividend (number to divide by)
	 * Pre: dvnd != 0
	 */
	public static int rem(int dvsr, int dvnd) {
		if(dvsr < 0)
			return -rem(-dvsr, dvnd);
		if(dvnd < 0)
			return rem(dvsr, -dvnd);

		if(dvsr-dvnd < 0)
			return dvsr;

		return rem(dvsr-dvnd, dvnd);
	}
	
	/** @return the remainder when x is divided by y.
    *   @param x >= 0 and y > 0
	 */
	public static int mod(int x, int y) {
		if(x-y < 0)
			return x;
		return mod(x-y, y);
	}
	
	
	
	
}
