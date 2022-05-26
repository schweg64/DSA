package recursion;

/**
 * A class to test recursive methods from lecture and prelab.
 * @author Ryan Schwegel
 * @version Sept 30 2020
 */
public class RecursionDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Recursion.rem(10, 3));    //1
		System.out.println(Recursion.rem(5, 5));   	 //0
		System.out.println(Recursion.rem(1, 3));   	 //1
		System.out.println(Recursion.rem(10, 2));  	 //0
		System.out.println(Recursion.rem(110, 56));  //54
		System.out.println(Recursion.rem(-110, 56)); //-54
		System.out.println(Recursion.rem(110, -56)); //54
		System.out.println(-110%56 + "\n\n");
		
		int n = 1;
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j<i; j++) {
				System.out.println(n++);
			}
		}
	}

}
